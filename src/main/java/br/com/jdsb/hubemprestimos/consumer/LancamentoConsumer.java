package br.com.jdsb.hubemprestimos.consumer;


import br.com.jdsb.hubemprestimos.service.LancamentoService;
import br.com.jdsb.hublancamentos.avro.LancamentoEvent;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LancamentoConsumer {

    private final LancamentoService service;

    @KafkaListener(topics = "${hub.consumer.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, LancamentoEvent> record) {
        var event = record.value();
        System.out.println("### CONSUMIDO: " + event);
        // aqui você pode salvar no banco, logar, transformar, etc
        service.salvarLancamento(event);
    }
}
