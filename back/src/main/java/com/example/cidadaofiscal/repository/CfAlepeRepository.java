package com.example.cidadaofiscal.repository;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.cidadaofiscal.beans.CfAlepe;

@Repository
public interface CfAlepeRepository extends JpaRepository<CfAlepe, Long>{
	
	/*@Query("SELECT \n" + 
			"	new com.example.cidadaofiscal.beans.DeputadoDTO(parlamentar_fantasia,\n" + 
			"	AVG(despesa_soma_mes),\n" + 
			"	sum(despesa_soma_mes))\n" + 
			"FROM\n" + 
			"	(SELECT \n" + 
			"		parlamentar_fantasia,\n" + 
			"		SUM(despesa_valor) AS despesa_soma_mes\n" + 
			"	FROM\n" + 
			"		cidadaofiscal.cf_alepe\n" + 
			"	GROUP BY\n" + 
			"		parlamentar_fantasia,\n" + 
			"		ordem_ano,\n" + 
			"		ordem_mes) AS month_sum\n" + 
			"GROUP BY parlamentar_fantasia\n" + 
			"ORDER BY soma desc\n" + 
			"             \n" + 
			" ")
	List<DeputadoDTO> getDeputadosView();*/

	@Query(
	value= "SELECT \n" + 
	"	parlamentar_fantasia,\n" + 
	"	AVG(despesa_soma_mes) AS despesa_media_mes,\n" + 
	"	sum(despesa_soma_mes) as soma\n" + 
	"FROM\n" + 
	"	(SELECT \n" + 
	"		parlamentar_fantasia,\n" + 
	"		SUM(despesa_valor) AS despesa_soma_mes\n" + 
	"	FROM\n" + 
	"		cidadaofiscal.cf_alepe\n" + 
	"	GROUP BY\n" + 
	"		parlamentar_fantasia,\n" + 
	"		ordem_ano,\n" + 
	"		ordem_mes) AS month_sum\n" + 
	"GROUP BY parlamentar_fantasia\n" + 
	"ORDER BY soma desc\n" + 
	"             \n" + 
	" ",
	nativeQuery = true)
	<T> Collection<T> getDeputadosSomasEMedias(Class<T> type);
	
}
