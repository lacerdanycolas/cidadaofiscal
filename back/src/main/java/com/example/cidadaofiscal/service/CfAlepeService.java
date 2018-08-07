package com.example.cidadaofiscal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.beans.DeputadoDTO;
import com.example.cidadaofiscal.beans.DespesaDTO;
import com.example.cidadaofiscal.beans.FornecedorDTO;
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
}
