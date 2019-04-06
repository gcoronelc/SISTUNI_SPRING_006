package pe.uni.producto.dao;

import java.util.List;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;

import pe.uni.producto.dao.mapper.ProductoMapper;
import pe.uni.producto.dao.spec.ProductoDaoSpec;
import pe.uni.producto.dto.ProductoDto;


@Repository
public class ProductoDao extends AbstractDaoSupport implements ProductoDaoSpec {

	@Override
	public ProductoDto getProducto(String codigo) {
		String sql = "select codigo, descripcion, precio, stock "
				     + "from producto where codigo = ? or descripcion like ?"; 
		ProductoDto dto;
		dto=jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper(ProductoDto.class), codigo);
		return dto;
	}
	

	@Override
	public List<ProductoDto> getProductos(String codigo, String descripcion) {
		String sql = "select codigo, descripcion, precio, stock "
			     + "from producto where codigo like ? and descripcion like ?"; 
		List<ProductoDto> lista;
		lista=jdbcTemplate.query(sql, new ProductoMapper(), codigo+ "%" , "%" +descripcion+"%");
		return lista;
		
	}

	@Override
	public void insertar(ProductoDto prod) {
		String sql = "insert into Producto Values( ?, ?, ? ,?)";
				jdbcTemplate.update
				(sql, prod.getCodigo(), prod.getDescripcion(), 
			     prod.getPrecio(), prod.getStock());
	}

	@Override
	public void modificar(ProductoDto prod) {
		String sql = "update Producto "
				+ "set descripcion = ?, precio = ?, stock = ?"
				+ " where codigo = ?";
		int filas = jdbcTemplate.update(sql, 
				prod.getDescripcion(), prod.getPrecio(), prod.getStock());
	}

	@Override
	public void eliminar(ProductoDto prod) {
		String sql = "delete Producto where codigo = ?";
		int filas = jdbcTemplate.update(sql, prod.getCodigo());
		
	}
	
	
	
	
}
