package com.example.cidadaofiscal.service;

import java.util.List;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.beans.DeputadoDTO;
import com.example.cidadaofiscal.repository.CfAlepeRepository;

@Service
public class CfAlepeService {
	
	@Autowired
	private CfAlepeRepository cfAlepeRepository;
	private EntityManager entityManager;
	
	public List<CfAlepe> findAll(){
		return cfAlepeRepository.findAll();
	}
	
	public CfAlepe findOne(Long id) {
		return cfAlepeRepository.getOne(id);
	}
	
	public List<DeputadoDTO> getDeputadosView(){
	 List<DeputadoDTO> deputadoDTOs = entityManager
				.createQuery(
						"SELECT \n" + 
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
						" ", DeputadoDTO.class)
				.getResultList();
	 return deputadoDTOs;
	}
}
