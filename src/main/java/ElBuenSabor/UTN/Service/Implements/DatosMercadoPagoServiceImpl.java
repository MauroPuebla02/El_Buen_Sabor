package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.DatosMercadoPago;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Repository.BaseRepository;
import ElBuenSabor.UTN.Repository.DatosMercadoPagoRepository;
import ElBuenSabor.UTN.Service.BaseServiceImpl;
import ElBuenSabor.UTN.Service.Interface.iDatosMercadoPagoService;
import com.mercadopago.client.preference.PreferenceClient;
import com.mercadopago.client.preference.PreferenceItemRequest;
import com.mercadopago.client.preference.PreferenceRequest;
import com.mercadopago.exceptions.MPApiException;
import com.mercadopago.resources.preference.Preference;
import com.mercadopago.exceptions.MPException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DatosMercadoPagoServiceImpl extends BaseServiceImpl<DatosMercadoPago,Long> implements iDatosMercadoPagoService {

    @Autowired
    private DatosMercadoPagoRepository pagoRepo;
    @Autowired
    private PedidoServiceImpl pedidoServiceImpl;
    public DatosMercadoPagoServiceImpl(BaseRepository<DatosMercadoPago,Long> baseRepository) {super(baseRepository);}

    private final PreferenceClient preferenceClient = new PreferenceClient();

    @Override
    public String crearPreferencia(Pedido pedido) {
        try {
            pedido = pedidoServiceImpl.save(pedido);
            List<PreferenceItemRequest> items = pedido.getDetalles().stream()
                    .map(det -> {
                        // 1) formateo el precio con 2 decimales
                        BigDecimal precio = BigDecimal.valueOf(det.getArticulo().getPrecio_venta())
                                .setScale(2, RoundingMode.HALF_UP);
                        // 2) chequeo mínimo
                        if (precio.compareTo(BigDecimal.valueOf(0.01)) < 0) {
                            throw new IllegalArgumentException(
                                    "Precio inválido para el ítem " + det.getArticulo().getDenominacion() + ": " + precio
                            );
                        }
                        // 3) build del ítem incluyendo currency_id
                        return PreferenceItemRequest.builder()
                                .title("Pedido Buen Sabor")
                                .quantity(det.getCantidad())
                                .unitPrice(precio)
                                .currencyId("ARS")              // <- obligatorio
                                .build();
                    })
                    .collect(Collectors.toList());


            // 2) Build de BackUrls
          /*  PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("https://tudominio.com/pagos/success")
                    .failure("https://tudominio.com/pagos/failure")
                    .pending("https://tudominio.com/pagos/pending")
                    .build();
        */
            // 3) Build de la PreferenceRequest
            PreferenceRequest request = PreferenceRequest.builder()
                    .items(items)
                    //.backUrls(backUrls)
                    //.autoReturn("all")
                    .build();

            // 4) Llamada al cliente
            Preference preference = preferenceClient.create(request);

            return preference.getInitPoint();

        } catch (MPApiException e) {
            System.err.println("MPApiException Message: " + e.getMessage());
            System.err.println("MPApiException Apiresponse status: " + e.getApiResponse().getStatusCode());

            System.err.println("MPApiException Apiresponse content: " + e.getApiResponse().getContent());
            throw new RuntimeException(e);

        } catch (MPException e) {
            System.err.println("MPException response: " + e.getMessage());
            throw new RuntimeException("Error creando preferencia MercadoPago", e);
        }
    }

    public void actualizarPago(String paymentId, String status, String preferenceId, BigDecimal monto) {
        DatosMercadoPago pago = pagoRepo.findByPreferenceId(preferenceId);
        if(pago != null) {
            pago.setPaymentId(paymentId);
            pago.setStatus(status);
            pago.setAmount(monto);
            pago.setDate(LocalDateTime.now());
            pagoRepo.save(pago);
        }else{
            throw new RuntimeException("Error actualizando pago de MercadoPago");
        }

    }

}
