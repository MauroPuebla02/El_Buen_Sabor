package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.DatosMercadoPago;
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
import java.time.LocalDateTime;
import java.util.List;

@Service
public class DatosMercadoPagoServiceImpl extends BaseServiceImpl<DatosMercadoPago,Long> implements iDatosMercadoPagoService {

    @Autowired
    private DatosMercadoPagoRepository pagoRepo;
    public DatosMercadoPagoServiceImpl(BaseRepository<DatosMercadoPago,Long> baseRepository) {super(baseRepository);}

    private final PreferenceClient preferenceClient = new PreferenceClient();

    @Override
    public String crearPreferencia(BigDecimal monto, String descripcion) {
        try {
            // 1) Build de ítems
            PreferenceItemRequest item = PreferenceItemRequest.builder()
                    .title(descripcion)
                    .quantity(1)
                    .unitPrice(monto)
                    .build();

            // 2) Build de BackUrls
          /*  PreferenceBackUrlsRequest backUrls = PreferenceBackUrlsRequest.builder()
                    .success("https://tudominio.com/pagos/success")
                    .failure("https://tudominio.com/pagos/failure")
                    .pending("https://tudominio.com/pagos/pending")
                    .build();
        */
            // 3) Build de la PreferenceRequest
            PreferenceRequest request = PreferenceRequest.builder()
                    .items(List.of(item))
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
