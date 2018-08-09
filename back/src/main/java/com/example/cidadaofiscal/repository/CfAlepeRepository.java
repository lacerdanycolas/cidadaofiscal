package com.example.cidadaofiscal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
	 List<Object[]> getDeputadosView();
	 
	 @Query(
	 value= "SELECT res_by_type.despesa_tipo AS despesa_tipo,\n" + 
	 		"    sum(y2015) as y2015,\n" + 
	 		"    sum(y2016) as y2016,\n" + 
	 		"    sum(y2017) as y2017,\n" + 
	 		"    sum(despesa_valor) AS total\n" + 
	 		"    FROM (\n" + 
	 		"        SELECT \n" + 
	 		"        despesa_tipo,\n" + 
	 		"        despesa_valor,\n" + 
	 		"        CASE(ordem_ano) WHEN (2015) THEN despesa_valor ELSE 0 END AS y2015,\n" + 
	 		"        CASE(ordem_ano) WHEN (2016) THEN despesa_valor ELSE 0 END AS y2016,\n" + 
	 		"        CASE(ordem_ano) WHEN (2017) THEN despesa_valor ELSE 0 END AS y2017        \n" + 
	 		"		FROM\n" + 
	 		"        cidadaofiscal.cf_alepe\n" + 
	 		"        )\n" + 
	 		"        AS res_by_type\n" + 
	 		"    GROUP BY\n" + 
	 		"        despesa_tipo\n" + 
	 		"    ORDER BY \n" + 
	 		"        total DESC;",
	 		nativeQuery = true)
	 		 List<Object[]> getDespesasView();
	 		 
	 @Query(
	 value = "SELECT \n" + 
	 		"        plain_data.fornecedor_nome AS fornecedor_nome,\n" + 
	 		"        SUM(despesa_valor) AS soma,\n" + 
	 		"        COUNT(DISTINCT parlamentar_nome) AS deputados_contador\n" + 
	 		"    FROM\n" + 
	 		"        cidadaofiscal.cf_alepe AS plain_data\n" + 
	 		"        JOIN (\n" + 
	 		"            SELECT \n" + 
	 		"                fornecedor_nome,\n" + 
	 		"                AVG(despesa_soma_mes) AS despesa_media_mes\n" + 
	 		"            FROM\n" + 
	 		"                (SELECT \n" + 
	 		"                    fornecedor_nome,\n" + 
	 		"                    SUM(despesa_valor) AS despesa_soma_mes\n" + 
	 		"                FROM\n" + 
	 		"                    cidadaofiscal.cf_alepe\n" + 
	 		"                    \n" + 
	 		"			GROUP BY\n" + 
	 		"                    fornecedor_nome,\n" + 
	 		"                    ordem_ano,\n" + 
	 		"                    ordem_mes) AS month_sum\n" + 
	 		"            GROUP\n" + 
	 		"                BY fornecedor_nome\n" + 
	 		"        ) AS month_avg \n" + 
	 		"        ON month_avg.fornecedor_nome = plain_data.fornecedor_nome\n" + 
	 		"    GROUP BY\n" + 
	 		"        fornecedor_nome\n" + 
	 		"    ORDER BY\n" + 
	 		"        soma DESC", 
	 		nativeQuery=true)
	 		 List<Object[]> getFornecedoresView();
	 		 
	 		@Query(
	 		value="SELECT\n" + 
	 				"	parlamentar_fantasia, \n" + 
	 				"	parlamentar_partido, \n" + 
	 				"	parlamentar_nome,\n" + 
	 				"	ordem_ano,\n" + 
	 				"	ordem_mes,\n" + 
	 				"    fornecedor_id,\n" + 
	 				"    fornecedor_nome,\n" + 
	 				"	despesa_tipo,\n" + 
	 				"	despesa_valor,\n" + 
	 				"	despesa_cancelada,\n" + 
	 				"    despesa_data\n" + 
	 				"FROM\n" + 
	 				"    cidadaofiscal.cf_alepe AS data\n" + 
	 				"WHERE \n" + 
	 				"(data.parlamentar_fantasia= :parlamentar_fantasia IS NULL OR data.parlamentar_fantasia= :parlamentar_fantasia) \n" + 
	 				"AND (data.parlamentar_partido= :parlamentar_partido IS NULL OR data.parlamentar_partido= parlamentar_partido)\n" + 
	 				"AND (data.parlamentar_nome= :parlamentar_nome IS NULL OR data.parlamentar_nome= :parlamentar_nome) \n" + 
	 				"AND (data.ordem_ano= :ordem_ano IS NULL OR data.ordem_ano= :ordem_ano) \n" + 
	 				"AND (data.ordem_mes= :ordem_mes IS NULL OR data.ordem_mes= :ordem_mes)\n" + 
	 				"AND (data.fornecedor_id= :fornecedor_id IS NULL OR data.fornecedor_id= :fornecedor_id)\n" + 
	 				"AND (data.fornecedor_nome= :fornecedor_nome IS NULL OR data.fornecedor_nome= :fornecedor_nome)\n" + 
	 				"AND (data.despesa_tipo= :despesa_tipo IS NULL OR data.despesa_tipo= :despesa_tipo)\n" + 
	 				"AND (data.despesa_valor= :despesa_valor IS NULL OR data.despesa_valor= :despesa_valor) \n" + 
	 				"AND (data.despesa_cancelada= :despesa_cancelada IS NULL OR data.despesa_cancelada= :despesa_cancelada)\n" + 
	 				"AND (data.despesa_data= :despesa_data IS NULL OR data.despesa_data= :despesa_data)\n" + 
	 				"ORDER BY data.despesa_data ASC\n" + 
	 				"\n" + 
	 				"\n" + 
	 				"\n" + 
	 				"", nativeQuery = true)
	 				 List<Object[]> getPesquisaResults(@Param("parlamentar_fantasia") String parlamentar_fantasia,
	 						                           @Param("parlamentar_partido") String parlamentar_partido,
	 						                           @Param("parlamentar_nome")String parlamentar_nome,
	 						                           @Param("ordem_ano")String ordem_ano,
	 						                           @Param("ordem_mes")String ordem_mes,
	 						                           @Param("fornecedor_id")String fornecedor_id,
	 						                           @Param("fornecedor_nome")String fornecedor_nome,
	 						                           @Param("despesa_tipo")String despesa_tipo,
	 						                           @Param("despesa_valor")String despesa_valor,
	 						                           @Param("despesa_cancelada")String despesa_cancelada,
	 						                           @Param("despesa_data")String despesa_data);
	
}
