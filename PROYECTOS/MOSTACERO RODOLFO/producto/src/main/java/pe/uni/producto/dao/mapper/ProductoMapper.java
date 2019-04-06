package pe.uni.producto.dao.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import pe.uni.producto.dto.ProductoDto;

public class ProductoMapper implements RowMapper<ProductoDto> {
	
	@Override
	public ProductoDto mapRow(ResultSet rs, int n) throws SQLException {
		ProductoDto dto = new ProductoDto();
		dto.setCodigo(rs.getString("codigo"));
		dto.setDescripcion(rs.getString("descripcion"));
		return dto;
	}
}
