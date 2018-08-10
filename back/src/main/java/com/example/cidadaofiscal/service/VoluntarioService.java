package com.example.cidadaofiscal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.cidadaofiscal.beans.Voluntario;
import com.example.cidadaofiscal.exception.VoluntarioNotFoundException;
import com.example.cidadaofiscal.repository.VoluntarioRepository;

@Service
public class VoluntarioService {
	
	@Autowired
	private VoluntarioRepository voluntarioRepository;
	
	
	public List<Voluntario> findall(){
		return voluntarioRepository.findAll();
	}
	
	public Page<Voluntario> findAllByPage(Pageable pageable){
		return voluntarioRepository.findAll(pageable);
	}
	
	public Voluntario findOne(Long id) {
		return voluntarioRepository.findById(id).get();
	}
	
	public Voluntario save(Voluntario voluntario) {
		return voluntarioRepository.save(voluntario);
	}
	
	public void delete(Long id) {
		Voluntario voluntario = voluntarioRepository.getOne(id);
		if(voluntario == null) {
			throw new VoluntarioNotFoundException(id);
		}else {
		voluntarioRepository.delete(voluntario);
		}
	}
	
	public Voluntario update(Long id, Voluntario voluntarioUpdated) {
		Voluntario voluntario = voluntarioRepository.getOne(id);
		
		if(voluntario == null) {
			throw new VoluntarioNotFoundException(id);
		}else {
			voluntario.setNome(voluntarioUpdated.getNome());
			voluntario.setEmail(voluntarioUpdated.getEmail());
			voluntario.setEstado(voluntarioUpdated.getEstado());
			voluntario.setTelefone(voluntarioUpdated.getTelefone());
		}
		return voluntarioRepository.save(voluntario);
	}
}
