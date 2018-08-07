package com.example.cidadaofiscal.api;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.beans.DeputadoDTO;
import com.example.cidadaofiscal.repository.CfAlepeRepository;
import com.example.cidadaofiscal.service.CfAlepeService;

@RestController
@RequestMapping("/alepe")
public class CfAlepeController {
	
	@Autowired 
	private CfAlepeService cfAlepeService;
	
	@Autowired
	private CfAlepeRepository rep;
	
	@GetMapping
	public List<CfAlepe> returnAll(){
		return cfAlepeService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public CfAlepe findOne(@PathVariable("id") Long id) {
		return cfAlepeService.findOne(id);
	}
	
	@GetMapping(path = "/deputado")
	public Collection<DeputadoDTO> getDeputadosView(){
		Collection<DeputadoDTO> x = rep.getDeputadosSomasEMedias(DeputadoDTO.class);
		return x;
	}
	
	/*@GetMapping(path = "/deputado")
	public List<DeputadoDTO> getDeputadosView2(){
		return cfAlepeService.getDeputadosView();
	}*/
	
	/*@GetMapping(path = "/deputado2")
	public List<DeputadoDTO> getDeputadosView2(){
		List<DeputadoDTO> x = rep.getDeputadosView();
		return x;
	}*/

}
