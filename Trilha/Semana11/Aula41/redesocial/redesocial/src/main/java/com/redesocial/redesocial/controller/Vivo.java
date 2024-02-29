package com.redesocial.redesocial.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Vivo {
	private int valor= 99;
	
	@RequestMapping("/vivo")
	public int getvalor() {
		return valor;
	}

	
}
