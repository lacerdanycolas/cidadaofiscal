package com.example.cidadaofiscal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.beans.DeputadoDTO;
import com.example.cidadaofiscal.beans.DespesaDTO;
import com.example.cidadaofiscal.beans.FornecedorDTO;
import com.example.cidadaofiscal.beans.PesquisaDTO;
import com.example.cidadaofiscal.repository.CfAlepeRepository;

@Service
public class CfAlepeService {
	
	@Autowired
	private CfAlepeRepository cfAlepeRepository;
	
	
	
	public List<CfAlepe> findAll(){
		return cfAlepeRepository.findAll();
	}
	
	public CfAlepe findOne(Long id) {
		return cfAlepeRepository.findById(id).get();
	}
	
	public List<DeputadoDTO> getDeputadosView(){
		List<DeputadoDTO> deputados = new ArrayList<DeputadoDTO>();
		List<Object[]> result = cfAlepeRepository.getDeputadosView();
		result.forEach(r -> deputados.add(new DeputadoDTO(r[0].toString(), r[1].toString(), r[2].toString())));
		return deputados;
	}
	
	public List<DespesaDTO> getDespesasView(){
		List<DespesaDTO> despesas = new ArrayList<DespesaDTO>();
		List<Object[]> result = cfAlepeRepository.getDespesasView();
		result.forEach(r -> despesas.add(new DespesaDTO(r[0].toString(), r[1].toString(), r[2].toString(), r[3].toString(), r[4].toString())));
		return despesas;
	}
	
	public List<FornecedorDTO> getFornecedoresView(){
		List<FornecedorDTO> fornecedores = new ArrayList<FornecedorDTO>();
		List<Object[]> result = cfAlepeRepository.getFornecedoresView();
		result.forEach(r -> fornecedores.add(new FornecedorDTO(r[0].toString(), r[1].toString(), r[2].toString())));
		return fornecedores;
	}
	
	public List<PesquisaDTO> getPesquisaResult(String parlamentar_fantasia, String parlamentar_partido, String parlamentar_nome, String ordem_ano, String ordem_mes, String fornecedor_id, String fornecedor_nome, String despesa_tipo, String despesa_valorDe, String despesa_valorAte, String despesa_dataDe, String despesa_dataAte, String despesa_cancelada){
		List<PesquisaDTO> pesquisa = new ArrayList<PesquisaDTO>();
		List<Object[]> result = cfAlepeRepository.getPesquisaResults(parlamentar_fantasia, parlamentar_partido, parlamentar_nome, ordem_ano, ordem_mes, fornecedor_id, fornecedor_nome, despesa_tipo, despesa_valorDe, despesa_valorAte, despesa_dataDe, despesa_dataAte, despesa_cancelada);
		result.forEach(r -> pesquisa.add(new PesquisaDTO(r[0].toString(), r[1].toString(), r[2].toString(), r[3].toString(), r[4].toString(), r[5].toString(), r[6].toString(), r[7].toString(), r[8].toString(), r[9].toString(), r[10].toString() )));
		return pesquisa;
	}
}
