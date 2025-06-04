package com.financeiro.contas.mapper;

import com.financeiro.contas.dto.LancamentoFinanceiroDTO;
import com.financeiro.contas.model.financeiro.LancamentoFinanceiro;
import org.springframework.stereotype.Component;

@Component
public class LancamentoFinanceiroMapper {

    public LancamentoFinanceiro toEntity(LancamentoFinanceiroDTO lancamentoFinanceiroDTO) {
        return LancamentoFinanceiro.builder()
                .id(lancamentoFinanceiroDTO.id())
                .descricao(lancamentoFinanceiroDTO.descricao())
                .valor(lancamentoFinanceiroDTO.valor())
                .dataVencimento(lancamentoFinanceiroDTO.dataVencimento())
                .dataPagamento(lancamentoFinanceiroDTO.dataPagamento())
                .tipoLancamento(lancamentoFinanceiroDTO.tipoLancamento())
                .statusLancamento(lancamentoFinanceiroDTO.statusLancamento())
                .build();
    }

    public LancamentoFinanceiroDTO toDTO(LancamentoFinanceiro lancamentoFinanceiro) {
        return LancamentoFinanceiroDTO.builder()
                .id(lancamentoFinanceiro.getId())
                .descricao(lancamentoFinanceiro.getDescricao())
                .valor(lancamentoFinanceiro.getValor())
                .dataVencimento(lancamentoFinanceiro.getDataVencimento())
                .dataPagamento(lancamentoFinanceiro.getDataPagamento())
                .tipoLancamento(lancamentoFinanceiro.getTipoLancamento())
                .statusLancamento(lancamentoFinanceiro.getStatusLancamento())
                .build();
    }
}
