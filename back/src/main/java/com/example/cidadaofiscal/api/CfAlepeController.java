package com.example.cidadaofiscal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.beans.DeputadoDTO;
import com.example.cidadaofiscal.beans.DespesaDTO;
import com.example.cidadaofiscal.beans.FornecedorDTO;
import com.example.cidadaofiscal.beans.PesquisaDTO;
import com.example.cidadaofiscal.service.CfAlepeService;

@RestController
@RequestMapping("/alepe")
@CrossOrigin
public class CfAlepeController {
	
	@Autowired 
	private CfAlepeService cfAlepeService;
	
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
	public List<PesquisaDTO> getPesquisaResults(){
		return cfAlepeService.getPesquisaResult();
	}
}
