package com.renatachom.empresaAerea.controllerDTO;

import com.renatachom.empresaAerea.Model.ModeloAeronave;

public class ModeloAeronaveDTO {

	private Long id;
	private String fabricante,nome;

	//construtor
	public ModeloAeronaveDTO(ModeloAeronave modeloAeronave) {

		this.id = modeloAeronave.getId();
		this.fabricante = modeloAeronave.getFabricante();
		this.nome = modeloAeronave.getNome();
	}

	//gets DTO
	public Long getId() {
		return id;
	}

	public String getFabricante() {
		return fabricante;
	}

	public String getNome() {
		return nome;
	}
	
	
	
	
}