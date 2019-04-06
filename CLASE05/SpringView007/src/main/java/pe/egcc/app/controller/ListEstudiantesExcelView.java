package pe.egcc.app.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class ListEstudiantesExcelView extends AbstractExcelView{

  @Override
  protected void buildExcelDocument(Map<String, Object> model, HSSFWorkbook libro, HttpServletRequest request,
      HttpServletResponse response) throws Exception {

    HSSFSheet hoja = libro.createSheet("ESTUDIANTES");
    
    HSSFRow fila = hoja.createRow(0);
    fila.createCell(0).setCellValue("COIDGO");
    fila.createCell(1).setCellValue("NOMBRE");
    
    fila = hoja.createRow(1);
    fila.createCell(0).setCellValue("E01");
    fila.createCell(1).setCellValue("CLAUDIA");
    
    fila = hoja.createRow(2);
    fila.createCell(0).setCellValue("E02");
    fila.createCell(1).setCellValue("MARTHA");
    
    
  }

}
