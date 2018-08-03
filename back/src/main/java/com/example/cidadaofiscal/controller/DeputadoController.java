package com.example.cidadaofiscal.controller;

import java.awt.PageAttributes.MediaType;
import java.util.List;

import org.hibernate.criterion.Example;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidadaofiscal.repository.*;
import com.example.cidadaofiscal.services.DeputadoService;
import com.example.cidadaofiscal.beans.Deputado;

@RestController
@RequestMapping("/deputados")
public class DeputadoController {
	
	/*@Autowired
	public DeputadoService deputadoservice;*/
	
	@Autowired
	private DeputadoRepository deputadorep;
	
	@GetMapping(produces="application/json")
	public ResponseEntity<?> list(Pageable pageable){
		return new ResponseEntity<>(this.deputadorep.findAll(pageable), HttpStatus.OK);
	}
	
	
	
}
