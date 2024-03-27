package com.renata.gerenciamento.funcionario;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Slf4j
@SpringBootApplication
public class FuncionarioApplication {
	private static Class<FuncionarioApplication> clazz;
	public static final Logger log = LoggerFactory.getLogger
	(clazz=FuncionarioApplication.class);
	

public static void main(String[] args) {
	SpringApplication.run(FuncionarioApplication.class, args);
	
	String msg;
	log.info(msg="Aplication started...");
}

}