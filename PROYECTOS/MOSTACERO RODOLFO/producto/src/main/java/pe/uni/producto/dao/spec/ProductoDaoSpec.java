package pe.uni.producto.dao.spec;

import java.util.List;

import org.springframework.stereotype.Repository;

import pe.uni.producto.dto.ProductoDto;

@Repository
public interface ProductoDaoSpec  {
	

	// metodo para buscar
	public ProductoDto getProducto( String codigo );
	
	public List<ProductoDto> getProductos( String codigo, String descripcion );
			
	//metodo para agregar
	
	public void insertar(ProductoDto prod);
	
	//metodo para modificar
	public void modificar (ProductoDto prod);
	
	//metodo para eliminar
	public void eliminar (ProductoDto prod);
}
