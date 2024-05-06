package com.renatachom.ap002.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.renatachom.ap002.dto.AcessDTO;
import com.renatachom.ap002.dto.AuthenticationDTO;
import com.renatachom.ap002.security.jwt.JwtUtils;

@Service
public class AuthService {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtils jwtUtils;

    public AcessDTO login(AuthenticationDTO authDto) {

        try {
            // Cria mecanismo de credencial para o Spring
            UsernamePasswordAuthenticationToken userAuth =
                    new UsernamePasswordAuthenticationToken(authDto.getUsername(), authDto.getPassword());

            // Prepara mecanismo para autenticacao
            Authentication authentication = authenticationManager.authenticate(userAuth);

            // Busca usuário logado
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();

            String token = jwtUtils.generateToken(userDetails);

            AcessDTO accessDto = new AcessDTO(token);

            return accessDto;

        } catch (BadCredentialsException e) {
            // TODO: Tratar login ou senha inválidos
            return new AcessDTO("Acesso negado");
        }
    }
}
