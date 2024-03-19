package com.danielmonteiro.leilao.controller.form;

import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.danielmonteiro.leilao.controllerDTO.ConcorrenteDTO;
import com.danielmonteiro.leilao.modelo.Concorrente;
import com.danielmonteiro.leilao.repositorio.ConcorrenteRepositorio;

public class ConcorrenteForm {

	private String nome,cpf;

	//construtor
	public ConcorrenteForm(String nome, String cpf) {
		this.nome = nome;
		this.cpf = cpf;
	}

	public ConcorrenteForm() {
	}

	//gets e sets
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	//metodo de criação
	public Concorrente criaConcorrente() {
		
		Concorrente concorrente = new Concorrente();
		nome = concorrente.getNome();
		cpf = concorrente.getCpf();
		
		return concorrente;	
	}
	
	//metodo toString
	public Concorrente toConcorrente() {
		
		Concorrente concorrente = new Concorrente();
		concorrente.setNome(nome);
		concorrente.setCpf(cpf);
		
		return concorrente;
	}
	
	@SuppressWarnings("null")
	@PostMapping
	public ResponseEntity<ConcorrenteDTO> inserir(@RequestBody ConcorrenteForm concorrenteForm, UriComponentsBuilder uriBuilder){
		
		Concorrente concorrente = concorrenteForm.toConcorrente();
		ConcorrenteRepositorio concorrenteRepo = null; //instancia do repositorio
		concorrenteRepo.save(concorrente);//salva 
		
		ConcorrenteDTO concorrenteDTO = new ConcorrenteDTO(concorrente); //DTO para adiçao
		uriBuilder.path("/concorrente/{id}");//caminho 
		URI uri = uriBuilder.buildAndExpand(concorrente.getId()).toUri();
		
		return ResponseEntity.created(uri).body(concorrenteDTO);
	}
	
}
