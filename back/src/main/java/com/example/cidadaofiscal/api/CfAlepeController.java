package com.example.cidadaofiscal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.beans.DeputadoDTO;
import com.example.cidadaofiscal.beans.DespesaDTO;
import com.example.cidadaofiscal.beans.FornecedorDTO;
import com.example.cidadaofiscal.beans.PesquisaDTO;
import com.example.cidadaofiscal.repository.CfAlepeRepository;
import com.example.cidadaofiscal.service.CfAlepeService;

@RestController
@RequestMapping("/alepe")
@CrossOrigin
public class CfAlepeController {
	
	@Autowired 
	private CfAlepeService cfAlepeService;
	@Autowired
	private CfAlepeRepository cfAlepeRepository;
	
	@GetMapping
	public List<CfAlepe> returnAll(){
		return cfAlepeService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public CfAlepe findOne(@PathVariable("id") Long id) {
		return cfAlepeService.findOne(id);
	}
	
	@GetMapping(path = "/deputado")
	public List<DeputadoDTO> getDeputadosView(){
		return cfAlepeService.getDeputadosView();
	}
	
	@GetMapping(path = "/despesa")
	public List<DespesaDTO> getDespesasView(){
		return cfAlepeService.getDespesasView();
	}
	
	@GetMapping(path = "/fornecedor")
	public List<FornecedorDTO> getFornecedoresView(){
		return cfAlepeService.getFornecedoresView();
	}
	
	@GetMapping(path = "/pesquisa")
	public List<PesquisaDTO> getPesquisaResults(
			@RequestParam(value="parlamentar_fantasia", required=false) String parlamentar_fantasia,
			@RequestParam(value="parlamentar_partido", required=false)String parlamentar_partido,
			@RequestParam(value="parlamentar_nome", required=false)String parlamentar_nome,
			@RequestParam(value="ordem_ano", required=false)String ordem_ano,
			@RequestParam(value="ordem_mes", required=false)String ordem_mes,
			@RequestParam(value="fornecedor_id", required=false)String fornecedor_id,
			@RequestParam(value="fornecedor_nome", required=false)String fornecedor_nome,
			@RequestParam(value="despesa_tipo", required=false)String despesa_tipo,
			@RequestParam(value="despesa_valor", required=false)String despesa_valor,
			@RequestParam(value="despesa_data", required=false)String despesa_data,
			@RequestParam(value="despesa_cancelada", required=false)String despesa_cancelada){
		return cfAlepeService.getPesquisaResult(parlamentar_fantasia, parlamentar_partido, parlamentar_nome, ordem_ano, ordem_mes, fornecedor_id, fornecedor_nome, despesa_tipo, despesa_valor, despesa_cancelada, despesa_data);
	}
}
