package com.danielmonteiro.leilao.controller.form;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.danielmonteiro.leilao.controllerDTO.LanceDTO;
import com.danielmonteiro.leilao.modelo.Lance;
import com.danielmonteiro.leilao.modelo.Leilao;
import com.danielmonteiro.leilao.repositorio.LanceRepositorio;

public class LanceForm {

	private Leilao leilao;
	private double valor;
	
	//construtor
	public LanceForm() {
	}

	public LanceForm(Leilao leilao, double valor) {
		this.leilao = leilao;
		this.valor = valor;
	}

	//gets e sets
	public Leilao getLeilao() {
		return leilao;
	}

	public void setLeilao(Leilao leilao) {
		this.leilao = leilao;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	
	//metodo criação
	public Lance criaLance() {
		Lance lance = new Lance();
		leilao = lance.getLeilao();
		valor = lance.getValor();
		
		return lance;
	}
	
	//metodo toString
	public Lance toLance() {
		
		Lance lance = new Lance();
		lance.setLeilao(leilao);
		lance.setValor(valor);
		
		return lance;
}
		
	@SuppressWarnings("null")
	@PostMapping
	public ResponseEntity<LanceDTO> inserir(@RequestBody LanceForm lanceForm, UriComponentsBuilder uriBuilder){
		
		Lance lance = lanceForm.toLance();
		LanceRepositorio lanceRepo = null; //instancia do repositorio
		lanceRepo.save(lance);//salva 
		
		LanceDTO lanceDTO = new LanceDTO(lance); //DTO para adiçao
		uriBuilder.path("/lance/{id}");//caminho 
		URI uri = uriBuilder.buildAndExpand(lance.getId()).toUri();
		
		return ResponseEntity.created(uri).body(lanceDTO);
	}
	
}
