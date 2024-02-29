package com.formula.um.piloto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PilotoController{

    @Autowired
    private ResourceLoader resourceLoader;

    // Método para ler o arquivo pilotos.csv
    private List<String[]> lerArquivo() {
        List<String[]> records = new ArrayList<>();
        try {
            Resource resource = resourceLoader.getResource("classpath:pilotos.csv");
            InputStream inputStream = resource.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));

            // Pular a primeira linha que contém o cabeçalho
            String header = reader.readLine();

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                records.add(parts);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Adicionar mensagens de log para verificar os registros lidos
        System.out.println("Registros lidos:");
        for (String[] record : records) {
            System.out.println(Arrays.toString(record));
        }

        return records;
    }

    // Endpoint para listar todos os vencedores
    @RequestMapping("/todos")
    @ResponseBody
    public List<String[]> listarTodos() {
        return lerArquivo();
    }

    // Endpoint para listar os vencedores brasileiros
    @RequestMapping("/brasileiros")
    @ResponseBody
    public List<String[]> listarBrasileiros() {
        List<String[]> records = lerArquivo();
        List<String[]> brasileiros = new ArrayList<>();
        for (String[] record : records) {
            if (record[0].equals("Brasil")) {
                brasileiros.add(record);
            }
        }
        return brasileiros;
    }

    // Endpoint para listar o Top 5 vencedores em ordem decrescente
    @RequestMapping("/top5")
    @ResponseBody
    public List<String[]> listarTop5() {
        List<String[]> records = lerArquivo();
        Collections.sort(records, (a, b) -> Integer.compare(Integer.parseInt(b[2]), Integer.parseInt(a[2])));
        return records.subList(0, Math.min(records.size(), 5));
    }

    // Endpoint para listar o Top 10 vencedores em ordem decrescente
    @RequestMapping("/top10")
    @ResponseBody
    public List<String[]> listarTop10() {
        List<String[]> records = lerArquivo();
        Collections.sort(records, (a, b) -> Integer.compare(Integer.parseInt(b[2]), Integer.parseInt(a[2])));
        return records.subList(0, Math.min(records.size(), 10));
    }

    // Endpoint para listar o número de vitórias por país em ordem decrescente
    @RequestMapping("/porpais")
    @ResponseBody
    public Map<String, Integer> listarVitoriasPorPais() {
        List<String[]> records = lerArquivo();
        Map<String, Integer> vitoriasPorPais = new HashMap<>();
        for (String[] record : records) {
            String pais = record[0];
            int vitorias = Integer.parseInt(record[2]);
            vitoriasPorPais.put(pais, vitoriasPorPais.getOrDefault(pais, 0) + vitorias);
        }
        // Ordena o mapa pelo valor (número de vitórias) em ordem decrescente
        Map<String, Integer> vitoriasPorPaisOrdenado = vitoriasPorPais.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        return vitoriasPorPaisOrdenado;
    }

    // Endpoint para listar a média de vitórias por país em ordem decrescente
    @RequestMapping("/mediaporpais")
    @ResponseBody
    public Map<String, Double> listarMediaVitoriasPorPais() {
        List<String[]> records = lerArquivo();
        Map<String, Integer> totalVitoriasPorPais = new HashMap<>();
        Map<String, Integer> totalVencedoresPorPais = new HashMap<>();
        for (String[] record : records) {
            String pais = record[0];
            int vitorias = Integer.parseInt(record[2]);
            totalVitoriasPorPais.put(pais, totalVitoriasPorPais.getOrDefault(pais, 0) + vitorias);
            totalVencedoresPorPais.put(pais, totalVencedoresPorPais.getOrDefault(pais, 0) + 1);
        }
        // Calcula a média de vitórias por país
        Map<String, Double> mediaVitoriasPorPais = new HashMap<>();
        for (String pais : totalVitoriasPorPais.keySet()) {
            int totalVitorias = totalVitoriasPorPais.get(pais);
            int totalVencedores = totalVencedoresPorPais.get(pais);
            double media = totalVitorias / (double) totalVencedores;
            mediaVitoriasPorPais.put(pais, media);
        }
        // Ordena o mapa pela média em ordem decrescente
        Map<String, Double> mediaVitoriasPorPaisOrdenada = mediaVitoriasPorPais.entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> oldValue,
                        LinkedHashMap::new));
        return mediaVitoriasPorPaisOrdenada;
    }
}
