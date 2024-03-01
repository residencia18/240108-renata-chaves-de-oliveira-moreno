package com.leilaoonline.leiloajava.controller;

import com.leilaoonline.leiloajava.controller.dto.LeilaoDTO;
import com.leilaoonline.leiloajava.controller.form.LeilaoForm;
import com.leilaoonline.leiloajava.modelo.Leilao;
import com.leilaoonline.leiloajava.service.LeilaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/leilao")
public class LeilaoController {

    private final LeilaoService leilaoService;

    @Autowired
    public LeilaoController(LeilaoService leilaoService) {
        this.leilaoService = leilaoService;
    }

    @GetMapping("/")
    public List<LeilaoDTO> listarLeiloes() {
        List<Leilao> leiloes = leilaoService.listarLeiloes();
        return leiloes.stream().map(this::convertLeilaoToDTO).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<LeilaoDTO> obterLeilaoPorId(@PathVariable Long id) {
        Optional<Leilao> leilaoOptional = leilaoService.obterLeilaoPorId(id);
        if (leilaoOptional.isPresent()) {
            Leilao leilao = leilaoOptional.get();
            LeilaoDTO leilaoDTO = convertLeilaoToDTO(leilao);
            return ResponseEntity.ok(leilaoDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<LeilaoDTO> criarLeilao(@RequestBody LeilaoForm leilaoForm) {
        Leilao leilao = leilaoService.criarLeilao(leilaoForm);
        LeilaoDTO leilaoDTO = convertLeilaoToDTO(leilao);
        return ResponseEntity.status(HttpStatus.CREATED).body(leilaoDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<LeilaoDTO> atualizarLeilao(@PathVariable Long id, @RequestBody LeilaoForm leilaoForm) {
        Leilao leilao = leilaoService.atualizarLeilao(id, leilaoForm);
        LeilaoDTO leilaoDTO = convertLeilaoToDTO(leilao);
        return ResponseEntity.ok(leilaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletarLeilao(@PathVariable Long id) {
        leilaoService.deletarLeilao(id);
        return ResponseEntity.noContent().build();
    }

    private LeilaoDTO convertLeilaoToDTO(Leilao leilao) {
        return new LeilaoDTO(leilao.getId(), leilao.getDescricao());
    }
}
