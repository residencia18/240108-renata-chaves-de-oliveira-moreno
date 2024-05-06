package com.renatachom.ap002.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.renatachom.ap002.entity.UsuarioEntity;
import com.renatachom.ap002.repository.UsuarioRepository;

@Service
public class UserDetailServiceImpl implements UserDetailsService{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UsuarioEntity usuario = usuarioRepository.findByLogin(username).get();
		return UserDetailsImpl.build(usuario);
	}

}