package com.example.cidadaofiscal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({
	"com.example.cidadaofiscal.repository",
	"com.example.cidadaofiscal.controller",
	"com.example.cidadaofiscal.beans",
	"com.example.cidadaofiscal.services"
})
public class BackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BackApplication.class, args);
	}
}
