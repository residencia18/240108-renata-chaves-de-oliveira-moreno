package com.renatachom.ap002.dto;

import org.springframework.beans.BeanUtils;

import com.renatachom.ap002.entity.PerfilEntity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PerfilDTO {

	private Long id;
	private String descricao;
	
	public PerfilDTO(PerfilEntity perfil) {
		BeanUtils.copyProperties(perfil, this);
	}
}