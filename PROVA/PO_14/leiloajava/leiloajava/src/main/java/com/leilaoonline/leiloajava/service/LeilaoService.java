package com.leilaoonline.leiloajava.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leilaoonline.leiloajava.controller.form.LeilaoForm;
import com.leilaoonline.leiloajava.modelo.Leilao;
import com.leilaoonline.leiloajava.repositorio.LeilaoRepositorio;

@Service
public class LeilaoService {

    private final LeilaoRepositorio leilaoRepositorio;

    @Autowired
    public LeilaoService(LeilaoRepositorio leilaoRepositorio) {
        this.leilaoRepositorio = leilaoRepositorio;
    }

    public List<Leilao> listarLeiloes() {
        return leilaoRepositorio.findAll();
    }

    public Optional<Leilao> obterLeilaoPorId(Long id) {
        return leilaoRepositorio.findById(id);
    }

    public Leilao criarLeilao(LeilaoForm leilaoForm) {
        Leilao leilao = new Leilao(leilaoForm.getNome(), leilaoForm.getDescricao(), leilaoForm.getPrecoInicial());
        return leilaoRepositorio.save(leilao);
    }

    public Leilao atualizarLeilao(Long id, LeilaoForm leilaoForm) {
        Optional<Leilao> leilaoOptional = leilaoRepositorio.findById(id);
        if (leilaoOptional.isPresent()) {
            Leilao leilao = leilaoOptional.get();
            leilao.setNome(leilaoForm.getNome());
            leilao.setDescricao(leilaoForm.getDescricao());
            leilao.setPrecoInicial(leilaoForm.getPrecoInicial());
            return leilaoRepositorio.save(leilao);
        } else {
            // Se o leilão não existe, você pode lançar uma exceção ou retornar null
            return null;
        }
    }

    public boolean deletarLeilao(Long id) {
        if (leilaoRepositorio.existsById(id)) {
            leilaoRepositorio.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
}
