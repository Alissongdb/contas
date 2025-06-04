package com.financeiro.contas.dto;

import com.financeiro.contas.model.financeiro.StatusLancamento;
import com.financeiro.contas.model.financeiro.TipoLancamento;
import lombok.Builder;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
public record LancamentoFinanceiroDTO(
        Long id,
        String descricao,
        BigDecimal valor,
        LocalDate dataVencimento,
        LocalDate dataPagamento,
        TipoLancamento tipoLancamento,
        StatusLancamento statusLancamento

) {
}
