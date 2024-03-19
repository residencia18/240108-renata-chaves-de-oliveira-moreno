package com.danielmonteiro.leilao.controle;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.danielmonteiro.leilao.controller.form.LanceForm;
import com.danielmonteiro.leilao.controllerDTO.LanceDTO;
import com.danielmonteiro.leilao.modelo.Lance;
import com.danielmonteiro.leilao.modelo.Leilao;
import com.danielmonteiro.leilao.repositorio.LanceRepositorio;

@RestController
@RequestMapping("/lance/")
public class LanceController {

	@Autowired
	private LanceRepositorio lanceRepo;
		
	@PostMapping
	public List<LanceDTO> listaLance(Leilao leilao,double valor ){
		
		List<Lance> lance;
		
		if(leilao != null) {
			lance = (ArrayList<Lance>) lanceRepo.findByLeilao(leilao);	
			}
		if(valor > 0) {
			lance = (ArrayList<Lance>) lanceRepo.findByValor(valor);			
			}
		else {
			lance = (ArrayList<Lance>) lanceRepo.findAll();		
			}
		
		List<LanceDTO> lista = new ArrayList<LanceDTO>();
		for(Lance lances: lance) {
			LanceDTO lanceDTO = new LanceDTO(lances);
			lista.add(lanceDTO);
		}//for 
		
		return lista;
	}
	
	
	//metodo listar por ID
    @GetMapping("/{id}")
	public ResponseEntity<?> listaLancesId(@PathVariable Long id){
		
		try {
			Lance lance = lanceRepo.getReferenceById(id);
			LanceDTO lanceDTO = new LanceDTO(lance);
			return ResponseEntity.ok(lanceDTO);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	
}

  //metodo para alterar
    @PutMapping("/{id}")
    public ResponseEntity<?> alteraLance(@PathVariable Long id, @RequestBody LanceForm lanceForm){
		
    	if(id == null) {
    		return ResponseEntity.badRequest().build();    		
    	}
    	
    	try {
    		Lance lance = lanceRepo.getReferenceById(id); //buscar pelo ID
    		lance.setLeilao(lanceForm.getLeilao());
    		lance.setValor(lanceForm.getValor());
    		lanceRepo.save(lance); //Salva
    		LanceDTO lanceDTO = new LanceDTO(lance); //instancia do repositorio
			return ResponseEntity.ok(lanceDTO);
    		
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    }
    
    
  //metodo para excluir buscando pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaLeilao(@PathVariable Long id){
		//busca pelo id e exclui
    	if(id == null) {
    		return ResponseEntity.badRequest().build();    		
    	}
    	
    	try {
    		Lance lance = lanceRepo.getReferenceById(id); //buscar pelo ID
    		lanceRepo.delete(lance); //Exclui o usuario
    		LanceDTO lanceDTO = new LanceDTO(lance); //instancia do repositorio
			return ResponseEntity.ok(lanceDTO);
    		
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
}
    
	
	
	
}
