package com.example.cidadaofiscal.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="No such Voluntario")  // 404
public class VoluntarioNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 137744895179504666L;
	
	public VoluntarioNotFoundException(Long id) {
	}
}
