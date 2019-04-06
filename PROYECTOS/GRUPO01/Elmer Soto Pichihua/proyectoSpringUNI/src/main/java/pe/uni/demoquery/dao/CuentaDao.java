package pe.uni.demoquery.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import pe.uni.demoquery.dao.mapper.ClienteMapper;
import pe.uni.demoquery.dao.spec.ClienteDaoSpec;
import pe.uni.demoquery.dao.spec.CuentaDaoSpec;
import pe.uni.demoquery.dto.ClienteDto;

@Repository
public class CuentaDao extends AbstractDaoSupport implements CuentaDaoSpec {

	@Override
	public Integer getCantCuentas() {
		String sql = "select count(*) from eureka.cuenta";
		int rowCount = jdbcTemplate.queryForObject(sql, Integer.class);
		return rowCount;
	}

	@Override
	public Double getSaldo(String moneda) {
		String sql = "select sum(dec_cuensaldo) from eureka.cuenta " + "where chr_monecodigo = ?";
		Double saldo = jdbcTemplate.queryForObject(sql, Double.class, moneda);
		return saldo;
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
	@Override
	public void procRetiro(String cuenta, Double importe, String clave, String empleado) {
		String SQL;
		Integer conta;
		// Verificar la cuenta
		SQL = "SELECT COUNT(1) FILAS  " + "FROM EUREKA.CUENTA " + "WHERE CHR_CUENCODIGO = ? "
				+ "AND   CHR_CUENCLAVE = ? " + "AND   VCH_CUENESTADO = 'ACTIVO'";
		conta = jdbcTemplate.queryForObject(SQL, Integer.class, cuenta, clave);
		if (conta == 0) {
			throw new RuntimeException("Cuenta no existe.");
		}
		// Datos de la cuenta
		SQL = "SELECT DEC_CUENSALDO SALDO, INT_CUENCONTMOV CONTMOV " + "FROM EUREKA.CUENTA "
				+ "WHERE CHR_CUENCODIGO = ? " + "FOR UPDATE";

		try {
			Thread.currentThread().sleep(5000);
		} catch (Exception e) {
		}

		Map<String, Object> rec = jdbcTemplate.queryForMap(SQL, cuenta);
		Double saldo = Double.parseDouble(rec.get("SALDO").toString());
		Integer contMov = Integer.parseInt(rec.get("CONTMOV").toString());
		// Validar saldo
		if (saldo < importe) {
			throw new RuntimeException("No existe Saldo suficiente.");
		}
		// Actualizar datos
		saldo = saldo - importe;
		contMov++;
		SQL = "UPDATE EUREKA.CUENTA " + "SET DEC_CUENSALDO = ?, " + "INT_CUENCONTMOV = ? " + "WHERE CHR_CUENCODIGO = ?";
		int filas = jdbcTemplate.update(SQL, saldo, contMov, cuenta);
		if (filas == 0) {
			throw new RuntimeException("no se ha logrado actualizar la cuenta.");
		}
		// Registrar movimiento
		SQL = "INSERT INTO EUREKA.MOVIMIENTO(CHR_CUENCODIGO, " + "INT_MOVINUMERO,DTT_MOVIFECHA,CHR_EMPLCODIGO, "
				+ "CHR_TIPOCODIGO,DEC_MOVIIMPORTE) " + "VALUES(?,?,SYSDATE,?,'004',?) ";
		jdbcTemplate.update(SQL, cuenta, contMov, empleado, importe);
	}

}
