package pe.egcc.app.controller;

import java.util.List;

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
 * @blog   gcoronelc.blogspot.com
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
	
	@RequestMapping(value="/verExcel01",method=RequestMethod.GET,
	    produces = "text/csv")
	@ResponseBody
	public String verExcel01(){
	  String texto = "";
	  texto += "CODIGO,NOMBRE,NOTA1,NOTA2\n";
	  texto += "E001,Gustavo,15,16\n";
	  texto += "E002,Karla,18,20\n";
	  texto += "E003,Claudia,17,18\n";
	  return texto;
	}

}