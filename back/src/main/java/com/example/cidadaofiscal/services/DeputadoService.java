package com.example.cidadaofiscal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import com.example.cidadaofiscal.beans.Deputado;
import com.example.cidadaofiscal.repository.DeputadoRepository;

@Service
public class DeputadoService {
	
	@Autowired
	private DeputadoRepository deputadorep;
	
	public Deputado save(Deputado deputado) {
		return this.deputadorep.save(deputado);
	}
	
	public Page<Deputado> findAll(Pageable pageable){
		return this.deputadorep.findAll(pageable);
	}
	
	public Deputado findOne(Long id) {
		Deputado depresultado = this.deputadorep.getOne(id);
		if(depresultado!= null)
			return depresultado;
		else
			 return null;
		
	}
	
	public boolean Delete(Long id) {
		Deputado depresultado = this.deputadorep.getOne(id);
		if(depresultado!=null) {
			this.deputadorep.delete(depresultado);
			return true;
		}else
			return false;
	}
}
