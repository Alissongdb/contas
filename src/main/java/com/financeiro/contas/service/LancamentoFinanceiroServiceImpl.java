package com.financeiro.contas.service;

import com.financeiro.contas.model.financeiro.LancamentoFinanceiro;
import com.financeiro.contas.dto.LancamentoFinanceiroDTO;
import com.financeiro.contas.mapper.LancamentoFinanceiroMapper;
import com.financeiro.contas.repository.LancamentoFinanceiroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class LancamentoFinanceiroServiceImpl implements LancamentoFinanceiroService {

    private final LancamentoFinanceiroRepository lancamentoFinanceiroRepository;
    private final LancamentoFinanceiroMapper lancamentoFinanceiroMapper;
    @Override
    public LancamentoFinanceiroDTO criarLancamento(LancamentoFinanceiroDTO lancamentoFinanceiroDTO) {
        LancamentoFinanceiro lancamentoFinanceiro = lancamentoFinanceiroMapper.toEntity(lancamentoFinanceiroDTO);
        LancamentoFinanceiro lancamentoFinanceiroSalvo = lancamentoFinanceiroRepository.save(lancamentoFinanceiro);
        return lancamentoFinanceiroMapper.toDTO(lancamentoFinanceiroSalvo);
    }

    @Override
    public List<LancamentoFinanceiroDTO> listarLancamentos() {
        return lancamentoFinanceiroRepository.findAll()
                .stream()
                .map(lancamentoFinanceiroMapper::toDTO)
                .toList();
    }

    @Override
    public Optional<LancamentoFinanceiroDTO> listarLancamentosPorId(Long id) {
        return lancamentoFinanceiroRepository.findById(id)
                .map(lancamentoFinanceiroMapper::toDTO);
    }

    @Override
    public LancamentoFinanceiroDTO atualizarLancamento(Long id, LancamentoFinanceiroDTO lancamentoFinanceiroDTO) {

        LancamentoFinanceiro lancamentoFinanceiro = getLancamento(id);

        lancamentoFinanceiro.setDescricao(lancamentoFinanceiroDTO.descricao());
        lancamentoFinanceiro.setValor(lancamentoFinanceiroDTO.valor());
        lancamentoFinanceiro.setDataVencimento(lancamentoFinanceiroDTO.dataVencimento());
        lancamentoFinanceiro.setDataPagamento(lancamentoFinanceiroDTO.dataPagamento());
        lancamentoFinanceiro.setTipoLancamento(lancamentoFinanceiroDTO.tipoLancamento());
        lancamentoFinanceiro.setStatusLancamento(lancamentoFinanceiroDTO.statusLancamento());

        return lancamentoFinanceiroMapper.toDTO(lancamentoFinanceiroRepository.save(lancamentoFinanceiro));

    }

    @Override
    public void deletarLancamento(Long id) {
        lancamentoFinanceiroRepository.deleteById(id);
    }

    private LancamentoFinanceiro getLancamento(Long id) {
        return lancamentoFinanceiroRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Lançamento não encontrado para o ID: " + id));
    }

}
