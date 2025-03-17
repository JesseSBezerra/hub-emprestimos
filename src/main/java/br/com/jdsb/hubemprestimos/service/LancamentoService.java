package br.com.jdsb.hubemprestimos.service;

import br.com.jdsb.hubemprestimos.entity.LancamentoEntity;
import br.com.jdsb.hubemprestimos.mapper.LancamentoMapper;
import br.com.jdsb.hubemprestimos.repository.LancamentoRepository;
import br.com.jdsb.hublancamentos.avro.LancamentoEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LancamentoService {

    private final LancamentoRepository repository;

    public void salvarLancamento(LancamentoEvent dto) {
        LancamentoEntity entity = LancamentoMapper.toEntity(dto);
        repository.save(entity);
    }
}
