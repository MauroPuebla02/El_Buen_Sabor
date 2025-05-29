package ElBuenSabor.UTN.Models.DTO;

public interface ArticuloManufacturadoByCategoriaDTO {
    Long getId();
    String getDenominacion();
    String getDescripcion();
    Long getPrecio_venta();
    Integer getTiempo_estimado_en_minutos();

}
