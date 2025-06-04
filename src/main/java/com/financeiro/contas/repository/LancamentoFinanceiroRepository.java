package com.financeiro.contas.repository;

import com.financeiro.contas.model.financeiro.LancamentoFinanceiro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LancamentoFinanceiroRepository extends JpaRepository<LancamentoFinanceiro, Long> {
}
