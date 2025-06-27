package ElBuenSabor.UTN.Service.Implements;

import ElBuenSabor.UTN.Models.Model.*;
import ElBuenSabor.UTN.Models.ProjectionDTO.ClienteRankingProjectionDTO;
import ElBuenSabor.UTN.Models.ProjectionDTO.ProductoChartProjectionDTO;
import ElBuenSabor.UTN.Models.ProjectionDTO.RendimientoChartProjectionDTOImpl;
import ElBuenSabor.UTN.Repository.PedidoRepository;
import ElBuenSabor.UTN.Repository.UsuarioRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EstadisticasServiceImpl {

    private final PedidoRepository pedidoRepository;
    private final UsuarioRepository usuarioRepository;

    public EstadisticasServiceImpl(PedidoRepository pedidoRepository,
                                   UsuarioRepository usuarioRepository) {
        this.pedidoRepository = pedidoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    /**
     * Compone todas las secciones del reporte en una lista de filas.
     */
    public List<List<Object>> getDatosExcel(int periodo) {
        List<List<Object>> datos = new ArrayList<>();

        // 1. Rendimientos
        RendimientoChartProjectionDTOImpl rend = getRendimientos(periodo);
        datos.add(Arrays.asList("Ventas", "Ingresos", "Costo", "Nuevos Clientes"));
        datos.add(Arrays.asList(
                rend.getVentas(),
                rend.getIngresos(),
                rend.getCostos(),
                rend.getNuevosClientes()
        ));
        datos.add(Arrays.asList("")); // separador

        // 2. Productos más vendidos
        datos.addAll(getProductosMasVendidos(periodo));
        datos.add(Arrays.asList(""));

        // 3. Ranking de clientes
        datos.add(Arrays.asList("Cliente", "Pedidos", "Total"));
        datos.addAll(getRankingClientes(periodo));

        return datos;
    }

    /**
     * Genera el libro Excel completo en memoria y devuelve un stream de bytes.
     */
    public ByteArrayInputStream getExcelReporte(int periodo) {
        try (Workbook workbook = new XSSFWorkbook();
             ByteArrayOutputStream out = new ByteArrayOutputStream()) {

            Sheet sheet = workbook.createSheet("Reporte");
            int rowIdx = 0;

            // Estilos
            Font titleFont = workbook.createFont();
            titleFont.setBold(true);
            titleFont.setFontHeightInPoints((short) 16);
            CellStyle titleStyle = workbook.createCellStyle();
            titleStyle.setFont(titleFont);

            Font sectionFont = workbook.createFont();
            sectionFont.setBold(true);
            sectionFont.setFontHeightInPoints((short) 12);
            CellStyle sectionStyle = workbook.createCellStyle();
            sectionStyle.setFont(sectionFont);

            Font headerFont = workbook.createFont();
            headerFont.setBold(true);
            CellStyle headerStyle = workbook.createCellStyle();
            headerStyle.setFont(headerFont);
            headerStyle.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
            headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            // Título principal
            Row titleRow = sheet.createRow(rowIdx);
            Cell titleCell = titleRow.createCell(0);
            titleCell.setCellValue("Reporte Estadísticas - Periodo: " + periodo);
            titleCell.setCellStyle(titleStyle);
            // Combinar celdas para el título (0 a 3)
            sheet.addMergedRegion(new org.apache.poi.ss.util.CellRangeAddress(rowIdx, rowIdx, 0, 3));
            rowIdx += 2; // salto de línea

            // 1. Rendimientos
            Row sec1 = sheet.createRow(rowIdx++);
            Cell sec1Cell = sec1.createCell(0);
            sec1Cell.setCellValue("1. Rendimientos");
            sec1Cell.setCellStyle(sectionStyle);

            // Encabezado rendimiento
            List<Object> rendHeader = Arrays.asList("Ventas", "Ingresos", "Costo", "Nuevos Clientes");
            Row hdr1 = sheet.createRow(rowIdx++);
            for (int c = 0; c < rendHeader.size(); c++) {
                Cell cell = hdr1.createCell(c);
                cell.setCellValue(rendHeader.get(c).toString());
                cell.setCellStyle(headerStyle);
            }
            // Datos rendimiento
            RendimientoChartProjectionDTOImpl rend = getRendimientos(periodo);
            Row row1 = sheet.createRow(rowIdx++);
            row1.createCell(0).setCellValue(rend.getVentas());
            row1.createCell(1).setCellValue(rend.getIngresos().doubleValue());
            row1.createCell(2).setCellValue(rend.getCostos().doubleValue());
            row1.createCell(3).setCellValue(rend.getNuevosClientes());

            rowIdx++; // línea en blanco

            // 2. Productos más vendidos
            Row sec2 = sheet.createRow(rowIdx++);
            Cell sec2Cell = sec2.createCell(0);
            sec2Cell.setCellValue("2. Productos más vendidos");
            sec2Cell.setCellStyle(sectionStyle);

            // Encabezado productos
            List<List<Object>> prod = getProductosMasVendidos(periodo);
            Row hdr2 = sheet.createRow(rowIdx++);
            for (int c = 0; c < prod.get(0).size(); c++) {
                Cell cell = hdr2.createCell(c);
                cell.setCellValue(prod.get(0).get(c).toString());
                cell.setCellStyle(headerStyle);
            }
            // Filas de productos
            for (int i = 1; i < prod.size(); i++) {
                Row r = sheet.createRow(rowIdx++);
                r.createCell(0).setCellValue(prod.get(i).get(0).toString());
                r.createCell(1).setCellValue(((Number)prod.get(i).get(1)).doubleValue());
            }

            rowIdx++;

            // 3. Ranking de clientes
            Row sec3 = sheet.createRow(rowIdx++);
            Cell sec3Cell = sec3.createCell(0);
            sec3Cell.setCellValue("3. Ranking de clientes");
            sec3Cell.setCellStyle(sectionStyle);

            // Encabezado clientes
            Row hdr3 = sheet.createRow(rowIdx++);
            List<Object> cliHdr = Arrays.asList("Cliente", "Pedidos", "Total");
            for (int c = 0; c < cliHdr.size(); c++) {
                Cell cell = hdr3.createCell(c);
                cell.setCellValue(cliHdr.get(c).toString());
                cell.setCellStyle(headerStyle);
            }
            // Filas de clientes
            List<List<Object>> cli = getRankingClientes(periodo);
            for (List<Object> data : cli) {
                Row r = sheet.createRow(rowIdx++);
                r.createCell(0).setCellValue(data.get(0).toString());
                r.createCell(1).setCellValue(((Number)data.get(1)).doubleValue());
                r.createCell(2).setCellValue(((BigDecimal)data.get(2)).doubleValue());
            }

            // Auto-ajustar columnas
            for (int i = 0; i < 4; i++) {
                sheet.autoSizeColumn(i);
            }

            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        } catch (IOException e) {
            throw new RuntimeException("Error al generar Excel", e);
        }
    }

    // Métodos auxiliares:

    public RendimientoChartProjectionDTOImpl getRendimientos(int periodo) {
        LocalDate desde = calcularFechaDesde(periodo);
        LocalDate hasta = LocalDate.now();
        var dto = pedidoRepository.getRendimientosSinCosto(desde, hasta);
        BigDecimal costo = calcularCostos(desde, hasta);
        return new RendimientoChartProjectionDTOImpl(
                dto.getVentas(), dto.getIngresos(), costo, dto.getNuevosClientes());
    }

    public List<List<Object>> getProductosMasVendidos(int periodo) {
        List<List<Object>> lista = new ArrayList<>();
        LocalDate desde = calcularFechaDesde(periodo);
        LocalDate hasta = LocalDate.now();
        var resultados = pedidoRepository.getProductosMasVendidos(desde, hasta, PageRequest.of(0, 50));
        lista.add(Arrays.asList("Articulo", "Cantidad Vendida"));
        for (ProductoChartProjectionDTO r : resultados) {
            lista.add(Arrays.asList(r.getProducto(), r.getCantidadVendida()));
        }
        return lista;
    }

    public List<List<Object>> getRankingClientes(int periodo) {
        List<List<Object>> lista = new ArrayList<>();
        LocalDate desde = calcularFechaDesde(periodo);
        LocalDate hasta = LocalDate.now();
        var resultados = usuarioRepository.getRankingClientes(desde, hasta, PageRequest.of(0, 50));
        for (ClienteRankingProjectionDTO r : resultados) {
            lista.add(Arrays.asList(r.getCliente(), r.getPedidos(), r.getTotal()));
        }
        return lista;
    }

    private LocalDate calcularFechaDesde(int periodo) {
        LocalDate hoy = LocalDate.now();
        return switch (periodo) {
            case 1 -> hoy;
            case 2 -> hoy.minusWeeks(1);
            case 3 -> hoy.minusMonths(1);
            default -> throw new IllegalArgumentException("Periodo inválido: " + periodo);
        };
    }

    private BigDecimal calcularCostos(LocalDate desde, LocalDate hasta) {
        return pedidoRepository.findAllByFechaPedidoBetween(desde, hasta).stream()
                .flatMap(p -> p.getDetalles().stream())
                .map(det -> {
                    Articulo art = det.getArticulo();
                    BigDecimal qty = BigDecimal.valueOf(det.getCantidad());
                    if (art instanceof ArticuloInsumo insu) {
                        return insu.getStock_insumo_sucursales().stream()
                                .findFirst()
                                .map(s -> s.getPrecio_compra().multiply(qty))
                                .orElse(BigDecimal.ZERO);
                    } else if (art instanceof ArticuloManufacturado manu) {
                        return manu.getDetalles().stream()
                                .map(d -> {
                                    BigDecimal cant = qty.multiply(BigDecimal.valueOf(d.getCantidad()));
                                    return d.getArticulo_insumo().getStock_insumo_sucursales().stream()
                                            .findFirst()
                                            .map(s -> s.getPrecio_compra().multiply(cant))
                                            .orElse(BigDecimal.ZERO);
                                })
                                .reduce(BigDecimal.ZERO, BigDecimal::add);
                    }
                    return BigDecimal.ZERO;
                })
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}