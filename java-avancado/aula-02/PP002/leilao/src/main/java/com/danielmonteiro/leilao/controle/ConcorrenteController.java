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
import com.danielmonteiro.leilao.controller.form.ConcorrenteForm;
import com.danielmonteiro.leilao.controllerDTO.ConcorrenteDTO;
import com.danielmonteiro.leilao.modelo.Concorrente;
import com.danielmonteiro.leilao.repositorio.ConcorrenteRepositorio;

@RestController
@RequestMapping("/concorrente/")
public class ConcorrenteController {

	@Autowired
	private ConcorrenteRepositorio concorrenteRepo;
	
	@PostMapping
	public List<ConcorrenteDTO> listaConcorrente(String nome,String cpf ){
		
		List<Concorrente> concorrente;
		
		if(nome != null) {
			concorrente = (ArrayList<Concorrente>) concorrenteRepo.findByNome(nome);	
			}
		if(cpf != null) {
			concorrente = (ArrayList<Concorrente>) concorrenteRepo.findByCpf(cpf);			
			}
		else {
			concorrente = (ArrayList<Concorrente>) concorrenteRepo.findAll();		
			}
		
		List<ConcorrenteDTO> lista = new ArrayList<ConcorrenteDTO>();
		for(Concorrente concorrentes: concorrente) {
			ConcorrenteDTO concorrenteDTO = new ConcorrenteDTO(concorrentes);
			lista.add(concorrenteDTO);
		}//for 
		
		return lista;
	}
	
	
	//metodo listar por ID
    @GetMapping("/{id}")
	public ResponseEntity<?> listaConcorrentes(@PathVariable Long id){
		
		try {
			Concorrente concorrente = concorrenteRepo.getReferenceById(id);
			ConcorrenteDTO concorrenteDTO = new ConcorrenteDTO(concorrente);
			return ResponseEntity.ok(concorrenteDTO);
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}	
}

  //metodo para alterar
    @PutMapping("/{id}")
    public ResponseEntity<?> alteraLeilao(@PathVariable Long id, @RequestBody ConcorrenteForm cForm){
		
    	if(id == null) {
    		return ResponseEntity.badRequest().build();    		
    	}
    	
    	try {
    		Concorrente concorrente = concorrenteRepo.getReferenceById(id); //buscar pelo ID
    		concorrente.setNome(cForm.getNome());
    		concorrente.setCpf(cForm.getCpf());
		
    		concorrenteRepo.save(concorrente); //Salva
    		ConcorrenteDTO concorrenteDTO = new ConcorrenteDTO(concorrente); //instancia do repositorio
			return ResponseEntity.ok(concorrenteDTO);
    		
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
    }
    
    
  //metodo para excluir buscando pelo ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletaLeilao(@PathVariable Long id){
		//busca pelo id e exclui os dados do usuario
    	if(id == null) {
    		return ResponseEntity.badRequest().build();    		
    	}
    	
    	try {
    		Concorrente concorrente = concorrenteRepo.getReferenceById(id); //buscar pelo ID
    		concorrenteRepo.delete(concorrente); //Exclui o usuario
    		ConcorrenteDTO concorrenteDTO = new ConcorrenteDTO(concorrente); //instancia usuarioDTO com o usuario do repositorio
			return ResponseEntity.ok(concorrenteDTO);
    		
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
}
    
	
}
