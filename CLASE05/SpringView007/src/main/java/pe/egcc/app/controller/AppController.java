package pe.egcc.app.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import pe.egcc.app.model.ProductoBean;
import pe.egcc.app.service.ProductoService;

/**
 * 
 * @author Gustavo Coronel
 * @blog gcoronelc.blogspot.com
 *
 */
@Controller
public class AppController {

	@Autowired
	protected ProductoService productoService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		List<ProductoBean> listaProductos = productoService.getListaProductos();
		model.addAttribute("listaProductos", listaProductos);
		return "listaProductos";
	}

	@RequestMapping(value = "/exportExcel", method = RequestMethod.GET)
	public ModelAndView getExcel() {
		List<ProductoBean> listaProductos = productoService.getListaProductos();
		return new ModelAndView("listaProductosExcelView", "listaProductos", listaProductos);
	}

	@RequestMapping(value = "/exportExcel2", method = RequestMethod.GET)
	public ModelAndView getExcel2() {
		return new ModelAndView("estudiantesExcelView");
	}

	@RequestMapping(value = "/verExcel01", method = RequestMethod.GET, produces = "text/csv")
	@ResponseBody
	public String verExcel01() {
		String texto = "";
		texto += "CODIGO,NOMBRE,NOTA1,NOTA2\n";
		texto += "E001,Gustavo,15,16\n";
		texto += "E002,Karla,18,20\n";
		texto += "E003,Claudia,17,18\n";
		return texto;
	}

	@RequestMapping(value = "/verExcel03", method = RequestMethod.GET)
	public void verExcel03(HttpServletResponse response) throws IOException {
		
		response.setContentType("application/vnd.ms-excel");
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet("new sheet");

		HSSFRow fila = sheet.createRow(0);
    fila.createCell(0).setCellValue("COIDGO");
    fila.createCell(1).setCellValue("NOMBRE");
    
    fila = sheet.createRow(1);
    fila.createCell(0).setCellValue("E01");
    fila.createCell(1).setCellValue("CLAUDIA");
    
    fila = sheet.createRow(2);
    fila.createCell(0).setCellValue("E02");
    fila.createCell(1).setCellValue("MARTHA");
		
		// Write the output
		OutputStream out = response.getOutputStream();
		wb.write(out);
		out.close();
		
	}

}