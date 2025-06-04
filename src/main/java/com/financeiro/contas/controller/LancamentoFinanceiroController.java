package com.financeiro.contas.controller;

import com.financeiro.contas.dto.LancamentoFinanceiroDTO;
import com.financeiro.contas.service.LancamentoFinanceiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/lancamentos")
@RequiredArgsConstructor
public class LancamentoFinanceiroController {

    private final LancamentoFinanceiroService lancamentoFinanceiroService;

    @PostMapping
    public ResponseEntity<LancamentoFinanceiroDTO> criar(@RequestBody LancamentoFinanceiroDTO dto) {
        LancamentoFinanceiroDTO novoLancamento = lancamentoFinanceiroService.criarLancamento(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(novoLancamento);
    }

    @GetMapping
    public ResponseEntity<List<LancamentoFinanceiroDTO>> listarTodos() {
        return ResponseEntity.ok(lancamentoFinanceiroService.listarLancamentos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<LancamentoFinanceiroDTO>> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(lancamentoFinanceiroService.listarLancamentosPorId(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<LancamentoFinanceiroDTO> atualizar(@PathVariable Long id,
                                                             @RequestBody LancamentoFinanceiroDTO dto) {
        try {
            LancamentoFinanceiroDTO atualizado = lancamentoFinanceiroService.atualizarLancamento(id, dto);
            return ResponseEntity.ok(atualizado);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        lancamentoFinanceiroService.deletarLancamento(id);
        return ResponseEntity.noContent().build();
    }
}