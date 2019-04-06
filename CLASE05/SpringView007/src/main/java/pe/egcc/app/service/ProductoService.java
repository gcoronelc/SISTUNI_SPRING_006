package pe.egcc.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import pe.egcc.app.model.ProductoBean;

/**
 * 
 * @author Gustavo Coronel
 * @blog   gcoronelc.blogspot.com
 *
 */
@Service
public class ProductoService {

	private static List<ProductoBean> listaProductos = new ArrayList<ProductoBean>();

	static {
	  listaProductos.add(new ProductoBean(1001, "Laptop 7i", 7890.00, 500));
	  listaProductos.add(new ProductoBean(1002, "Impresora Laser", 560.00, 200));
	  listaProductos.add(new ProductoBean(1003, "Table 10 pulgadas", 780.00, 300));
	  listaProductos.add(new ProductoBean(1004, "Memoria USB 64 GB", 55.00, 1500));
	  listaProductos.add(new ProductoBean(1005, "Disco duro externo 1TB", 350.0, 856));
	}

	public List<ProductoBean> getListaProductos() {
		return listaProductos;
	}

}
