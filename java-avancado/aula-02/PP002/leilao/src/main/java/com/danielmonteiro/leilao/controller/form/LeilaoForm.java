package com.danielmonteiro.leilao.controller.form;



import java.net.URI;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.util.UriComponentsBuilder;

import com.danielmonteiro.leilao.controllerDTO.LeilaoDTO;
import com.danielmonteiro.leilao.modelo.Leilao;
import com.danielmonteiro.leilao.repositorio.LeilaoRepositorio;

public class LeilaoForm {
	
	private String descricao,status;
	private double valorMinimo;
	
	//construtor
	public LeilaoForm(String descricao, String status, double valorMinimo) {
		this.descricao = descricao;
		this.status = status;
		this.valorMinimo = valorMinimo;
	}

	public LeilaoForm() {
	}

	//gets e sets
	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public double getValorMinimo() {
		return valorMinimo;
	}

	public void setValorMinimo(double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	
	
	//Metodo de criação
	public Leilao criaLeilao() {
		
		Leilao leilao = new Leilao();
		descricao = leilao.getDescricao();
		status = leilao.getStatus();
		valorMinimo = leilao.getValorMinimo();
		
		return leilao;
}
	
	//Metodo ToString
	public Leilao toLeilao() {
		
		Leilao leilao = new Leilao();
		leilao.setDescricao(descricao);
		leilao.setStatus(status);
		leilao.setValorMinimo(valorMinimo);
		
		return leilao;
	}
	
	@GetMapping
	public ResponseEntity<LeilaoDTO> inserir(@RequestBody LeilaoForm leilaoForm, UriComponentsBuilder uriBuilder){
		
		Leilao leilao = leilaoForm.toLeilao();
		LeilaoRepositorio leilaoRepo = null; //instancia do repositorio
		leilaoRepo.save(leilao);//salva 
		
		LeilaoDTO leilaoDTO = new LeilaoDTO(leilao);//DTO para adiçao
		uriBuilder.path("/leilao/{id}");//caminho 
		URI uri = uriBuilder.buildAndExpand(leilao.getId()).toUri();
		
		return ResponseEntity.created(uri).body(leilaoDTO);
	}
	

}
