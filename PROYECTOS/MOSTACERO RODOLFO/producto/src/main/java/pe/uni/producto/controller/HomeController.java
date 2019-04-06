package pe.uni.producto.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;

import pe.uni.producto.dto.ProductoDto;
import pe.uni.producto.service.ProductoService;

@Controller
public class HomeController {
	@Autowired
	private ProductoService productoService;
	
	private Gson gson;
	
	@PostConstruct
	public void InicializarObject() {
		gson = new Gson();
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		
		return "index";
	}
	
	@RequestMapping(value = "/ConsultarProductos.htm", method = RequestMethod.GET)
	public String ConsultarProductos() {	
		return "ConsultarProductos";
	}
	
	@RequestMapping(value = "/Insertar.htm", method = RequestMethod.GET)
	public String InsertarProducto() {	
		return "Insertar";
	}
	
	@RequestMapping(value = "/ConsultarProductosResp1.htm", method = RequestMethod.GET)
	public @ResponseBody String ConsultarProductoResp1(
			@RequestParam("codigo") String codigo, 
			@RequestParam("descripcion") String descripcion
		
			) {	
		
		// Proceso de busqueda
		List<ProductoDto> lista = productoService.getProductos(codigo, descripcion);
		String respJSON = gson.toJson(lista);
		return respJSON;
	}
	
	@RequestMapping(value = "/InsertarProductoResp2.htm", method = RequestMethod.POST)
	public @ResponseBody String InsertarProductoResp2(
			@RequestParam("codigo") String codigo, 
			@RequestParam("descripcion") String descripcion,
			@RequestParam("precio") Double precio,
			@RequestParam("stock") Integer stock
			
			) {	
		ProductoDto producto = new ProductoDto();
		producto.setCodigo(codigo);
		producto.setDescripcion(descripcion);
		producto.setPrecio(precio);
		producto.setStock(stock);
		productoService.insertar(producto);
		String respJSON = gson.toJson("OK");
		return respJSON;
		}
}
