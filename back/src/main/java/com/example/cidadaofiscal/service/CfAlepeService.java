package com.example.cidadaofiscal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cidadaofiscal.beans.CfAlepe;
import com.example.cidadaofiscal.repository.CfAlepeRepository;

@Service
public class CfAlepeService {
	
	@Autowired
	private CfAlepeRepository cfAlepeRepository;
	
	public List<CfAlepe> findAll(){
		return cfAlepeRepository.findAll();
	}
	
	public CfAlepe findOne(Long id) {
		return cfAlepeRepository.getOne(id);
	}
}
