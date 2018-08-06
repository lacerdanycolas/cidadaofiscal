package com.example.cidadaofiscal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.repository.CfAlepeRepository;
import com.example.cidadaofiscal.service.CfAlepeService;
import com.fasterxml.jackson.annotation.JsonView;

@RestController
@RequestMapping("/alepe")
public class CfAlepeController {
	
	@Autowired 
	private CfAlepeRepository cfAlepeService;
	
	@GetMapping
	public List<CfAlepe> returnAll(){
		return cfAlepeService.findAll();
	}
	
	@GetMapping(path = "/{id}")
	public CfAlepe findOne(@PathVariable("id") Long id) {
		return cfAlepeService.getOne(id);
	}
}
