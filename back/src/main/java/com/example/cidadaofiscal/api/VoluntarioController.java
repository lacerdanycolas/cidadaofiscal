package com.example.cidadaofiscal.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.cidadaofiscal.beans.Voluntario;
import com.example.cidadaofiscal.service.VoluntarioService;

@RestController
@RequestMapping("/voluntario")
@CrossOrigin
public class VoluntarioController {
	
	@Autowired
	private VoluntarioService voluntarioService;
	
	@PostMapping
	public Voluntario save(@RequestBody Voluntario voluntario) {
		return voluntarioService.save(voluntario);
	}
	
	@GetMapping
	public List<Voluntario> findAll(){
		return voluntarioService.findall();
	}
	
	@GetMapping(path = "/{id}")
	public Voluntario voluntario(@PathVariable("id") Long id) {
		return voluntarioService.findOne(id);
	}
	
	@PutMapping(path = "/{id}")
	public Voluntario update(@PathVariable("id") Long id, @RequestBody Voluntario voluntario) {
		return voluntarioService.update(id, voluntario);
	}
	
	@DeleteMapping(path = "/{id}")
	public void deleteOne(@PathVariable("id") Long id) {
		voluntarioService.delete(id);
	}
}
