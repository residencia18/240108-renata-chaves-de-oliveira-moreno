package com.renatachom.empresaAerea.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.renatachom.empresaAerea.Model.Piloto;
import com.renatachom.empresaAerea.controllerDTO.PilotoDTO;
import com.renatachom.empresaAerea.repositorio.PilotoRepositorio;

@RestController
public class PilotoController {
    
	@Autowired
	private PilotoRepositorio pilotoRepo;
	
	@RequestMapping("/pilotos")
	public List<PilotoDTO> listaDePilotos(){
		
		List<Piloto> listaPilotos = (ArrayList<Piloto>) pilotoRepo.findAll();
		List<PilotoDTO> lista = new ArrayList<PilotoDTO>();
		for(Piloto piloto: listaPilotos) {
			PilotoDTO pilotoDTO = new PilotoDTO(piloto);
			lista.add(pilotoDTO);
		}
		
		return lista;
	}
	
}