package com.renatachom.ap002.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.renatachom.ap002.dto.RecursoDTO;
import com.renatachom.ap002.entity.RecursoEntity;
import com.renatachom.ap002.repository.RecursoRepository;

@Service
public class RecursoService {

	@Autowired
	private RecursoRepository recursoRepository;
	
	public List<RecursoDTO> listarTodos(){
		List<RecursoEntity> recursos = recursoRepository.findAll();
		return recursos.stream().map(RecursoDTO::new).toList();
	}
	
	public void inserir(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		recursoRepository.save(recursoEntity);
	}
	
	public RecursoDTO alterar(RecursoDTO recurso) {
		RecursoEntity recursoEntity = new RecursoEntity(recurso);
		return new RecursoDTO(recursoRepository.save(recursoEntity));
	}
	
	public void excluir(Long id) {
		RecursoEntity recurso = recursoRepository.findById(id).get();
		recursoRepository.delete(recurso);
	}
	
	public RecursoDTO buscarPorId(Long id) {
		return new RecursoDTO(recursoRepository.findById(id).get());
	}
}