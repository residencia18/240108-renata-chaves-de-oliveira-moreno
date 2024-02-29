package com.formula.um.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.formula.um.VencedorService;
import com.formula.um.model.Vencedor;

@RestController
@RequestMapping("/corridas")
public class CorridaController {

    @Autowired
    private VencedorService vencedorService;

    @GetMapping("/todos")
    public List<Vencedor> listarTodosVencedores() {
        return vencedorService.listarTodos();
    }

    @GetMapping("/brasileiros")
    public List<Vencedor> listarVencedoresBrasileiros() {
        return vencedorService.listarBrasileiros();
    }

    @GetMapping("/top5")
    public List<Vencedor> listarTop5Vencedores() {
        return vencedorService.listarTopNVencedores(5);
    }

    @GetMapping("/top10")
    public List<Vencedor> listarTop10Vencedores() {
        return vencedorService.listarTopNVencedores(10);
    }

    @GetMapping("/porpais")
    public Map<String, Integer> listarVitoriasPorPais() {
        return vencedorService.listarVitoriasPorPais();
    }

    @GetMapping("/mediaporpais")
    public Map<String, Double> listarMediaVitoriasPorPais() {
        return vencedorService.listarMediaVitoriasPorPais();
    }

    @GetMapping("/vencedoresPorPais")
    public List<Vencedor> listarVencedoresPorPais(String pais) {
        return vencedorService.listarVencedoresPorPais(pais);
    }

    @RequestMapping("/error")
    public String handleError() {
      
        return "error";
    }
}

