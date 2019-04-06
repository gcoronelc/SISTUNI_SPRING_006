package pe.egcc.app.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import pe.egcc.app.model.ProductoBean;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
public class ListaProductosExcelView extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String,Object> model, HSSFWorkbook workbook,
			HttpServletRequest request, HttpServletResponse response)
			throws Exception {

		HSSFSheet excelSheet = workbook.createSheet("LISTADO DE PRODUCTOS");
		setExcelHeader(excelSheet);
		
		@SuppressWarnings("unchecked")
    List<ProductoBean> listaProductos = (List<ProductoBean>) model.get("listaProductos");
		setExcelRows(excelSheet,listaProductos);
		
	}

	public void setExcelHeader(HSSFSheet excelSheet) {
		HSSFRow excelHeader = excelSheet.createRow(0);
		excelHeader.createCell(0).setCellValue("ID");
		excelHeader.createCell(1).setCellValue("NOMBRE");
		excelHeader.createCell(2).setCellValue("PRECIO");
		excelHeader.createCell(3).setCellValue("STOCK");
	}
	
	public void setExcelRows(HSSFSheet excelSheet, List<ProductoBean> listaProductos){
		int fila = 1;
		for (ProductoBean r : listaProductos) {
			HSSFRow excelRow = excelSheet.createRow(fila);
			excelRow.createCell(0).setCellValue(r.getId());
			excelRow.createCell(1).setCellValue(r.getNombre());
			excelRow.createCell(2).setCellValue(r.getPrecio());
			excelRow.createCell(3).setCellValue(r.getStock());
			fila++;
		}
	}
}
