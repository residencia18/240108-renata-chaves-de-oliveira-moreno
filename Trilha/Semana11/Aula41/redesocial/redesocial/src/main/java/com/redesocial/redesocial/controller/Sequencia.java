package com.redesocial.redesocial.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Sequencia {
	
		
	private int proximoNumero = 1;
	
	@RequestMapping("/sequencia")
	public int proximoNumeroSequencial() {
		
		return proximoNumero ++;
	}
	
	
	
}
