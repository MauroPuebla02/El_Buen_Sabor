package ElBuenSabor.UTN.Models.Mappers;

import ElBuenSabor.UTN.Models.DTO.PedidoHistorialClienteDTO;
import ElBuenSabor.UTN.Models.Model.Pedido;
import ElBuenSabor.UTN.Models.Model.PedidoDetalle;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Mapper(componentModel = "spring")
public interface PedidoHistorialClienteMapper {

    @Mapping(source = "fecha_pedido", target = "fecha", qualifiedByName = "formatearFecha")
    @Mapping(source = "hora_estimada_finalizacion", target = "hora", qualifiedByName = "formatearHora")
    @Mapping(source = "estado_pedido", target = "estado")
    @Mapping(source = "detalles", target = "productos", qualifiedByName = "mapearDetallesAStrings")
    PedidoHistorialClienteDTO toHistorialDTO(Pedido pedido);

    List<PedidoHistorialClienteDTO> toHistorialDTOList(List<Pedido> pedidos);

    @Named("formatearFecha")
    static String formatearFecha(LocalDate fecha) {
        return fecha != null ? fecha.format(DateTimeFormatter.ofPattern("dd-MM-yyyy")) : null;
    }

    @Named("formatearHora")
    static String formatearHora(LocalTime hora) {
        return hora != null ? hora.format(DateTimeFormatter.ofPattern("HH:mm")) : null;
    }

    @Named("mapearDetallesAStrings")
    static List<String> mapearDetallesAStrings(List<PedidoDetalle> detalles) {
        if (detalles == null) return List.of();
        return detalles.stream()
                .filter(det -> det.getArticulo() != null)
                .map(det -> det.getCantidad() + " - " + det.getArticulo().getDenominacion())
                .toList();
    }
}
