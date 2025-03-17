package br.com.jdsb.hubemprestimos.repository;

import br.com.jdsb.hubemprestimos.entity.LancamentoEntity;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;


@EnableScan
public interface LancamentoRepository extends CrudRepository<LancamentoEntity, String> {
}
