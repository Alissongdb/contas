package com.financeiro.contas.service;

import com.financeiro.contas.dto.LancamentoFinanceiroDTO;

import java.util.List;
import java.util.Optional;

public interface LancamentoFinanceiroService {

    LancamentoFinanceiroDTO criarLancamento(LancamentoFinanceiroDTO lancamentoFinanceiroDTO);

    List<LancamentoFinanceiroDTO> listarLancamentos();

    Optional<LancamentoFinanceiroDTO> listarLancamentosPorId(Long id);

    LancamentoFinanceiroDTO atualizarLancamento(Long id, LancamentoFinanceiroDTO lancamentoFinanceiroDTO);

    void deletarLancamento (Long id);
}
