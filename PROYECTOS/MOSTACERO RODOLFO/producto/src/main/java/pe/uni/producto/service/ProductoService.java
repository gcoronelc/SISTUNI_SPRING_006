package pe.uni.producto.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.uni.producto.dto.ProductoDto;

import pe.uni.producto.dao.spec.ProductoDaoSpec;

@Service
public class ProductoService {
	
	@Autowired
	private ProductoDaoSpec productoDao;
	
	
	// metodo para buscar
		public ProductoDto getProducto( String codigo){
			return productoDao.getProducto(codigo);
		}
		public List<ProductoDto> getProductos( String codigo, String descripcion ){
			return productoDao.getProductos(codigo, descripcion);
		}
		public void insertar(ProductoDto prod) {
			productoDao.insertar(prod);
		}
		public void modificar(ProductoDto prod) {
			productoDao.modificar(prod);
		}
		public void eliminar(ProductoDto prod) {
			productoDao.eliminar(prod);
		}
	
				
	//metodo para agregar
		
		
}