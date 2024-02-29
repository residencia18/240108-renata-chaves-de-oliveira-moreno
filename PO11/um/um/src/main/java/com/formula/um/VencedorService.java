package com.formula.um;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import com.formula.um.model.Vencedor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class VencedorService {

    private static final String CAMINHO_ARQUIVO = "pilotos.csv";

    public List<Vencedor> listarTodos() {
        List<Vencedor> vencedores = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(new ClassPathResource(CAMINHO_ARQUIVO).getInputStream()))) {
            String linha;
            while ((linha = br.readLine()) != null) {
                String[] dados = linha.split(",");
                String nome = dados[0];
                String pais = dados[1];
                int numeroVitorias = Integer.parseInt(dados[2]);
                Vencedor vencedor = new Vencedor(nome, pais, numeroVitorias);
                vencedores.add(vencedor);
            }
        } catch (IOException e) {
            e.printStackTrace();
           
        }
        return vencedores;
    }


    public List<Vencedor> listarBrasileiros() {
        List<Vencedor> brasileiros = new ArrayList<>();
        List<Vencedor> todos = listarTodos();
        for (Vencedor vencedor : todos) {
            if ("Brasil".equalsIgnoreCase(vencedor.getPais())) {
                brasileiros.add(vencedor);
            }
        }
        return brasileiros;
    }

    public List<Vencedor> listarTopNVencedores(int n) {
        List<Vencedor> todos = listarTodos();
        todos.sort((v1, v2) -> Integer.compare(v2.getNumeroVitorias(), v1.getNumeroVitorias()));
        return todos.subList(0, Math.min(n, todos.size()));
    }

    public Map<String, Integer> listarVitoriasPorPais() {
        List<Vencedor> todos = listarTodos();
        Map<String, Integer> vitoriasPorPais = new HashMap<>();
        for (Vencedor vencedor : todos) {
            String pais = vencedor.getPais();
            vitoriasPorPais.put(pais, vitoriasPorPais.getOrDefault(pais, 0) + 1);
        }
        return vitoriasPorPais;
    }

    public Map<String, Double> listarMediaVitoriasPorPais() {
        List<Vencedor> todos = listarTodos();
        Map<String, Integer> vitoriasPorPais = listarVitoriasPorPais();
        Map<String, Double> mediaVitoriasPorPais = new HashMap<>();
        for (Map.Entry<String, Integer> entry : vitoriasPorPais.entrySet()) {
            String pais = entry.getKey();
            int vitorias = entry.getValue();
            long totalVencedores = todos.stream().filter(v -> v.getPais().equals(pais)).count();
            double media = (double) vitorias / totalVencedores;
            mediaVitoriasPorPais.put(pais, media);
        }
        return mediaVitoriasPorPais;
    }


    public List<Vencedor> listarVencedoresPorPais(String pais) {
        List<Vencedor> vencedoresPorPais = new ArrayList<>();
        List<Vencedor> todos = listarTodos();
        for (Vencedor vencedor : todos) {
            if (pais.equalsIgnoreCase(vencedor.getPais())) {
                vencedoresPorPais.add(vencedor);
            }
        }
        return vencedoresPorPais;
    }


}
