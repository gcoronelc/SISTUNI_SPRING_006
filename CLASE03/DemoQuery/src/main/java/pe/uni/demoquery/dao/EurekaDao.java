package pe.uni.demoquery.dao;

import org.springframework.stereotype.Repository;

import pe.uni.demoquery.dao.spec.EurekaDaoSpec;

@Repository
public class EurekaDao extends AbstractDaoSupport implements EurekaDaoSpec{

	@Override
	public Integer getCantCuentas() {
		String sql= "select count(*) from eureka.cuenta";
		int rowCount= jdbcTemplate.queryForObject(sql,Integer.class);
		return rowCount;
	}

	@Override
	public Double getSaldo() {
		String sql= "select sum(dec_cuensaldo) from eureka.cuenta";
		Double saldo = jdbcTemplate.queryForObject(sql, Double.class);
		return saldo;
	}

	
	
}
