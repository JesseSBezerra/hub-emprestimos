package br.com.jdsb.hub.consumer;


import br.com.jdsb.hub.avro.LancamentoEvent;
import br.com.jdsb.hub.service.LancamentoService;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LancamentoConsumer {

    private final LancamentoService service;

    @KafkaListener(topics = "${hub.consumer.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consume(ConsumerRecord<String, Object> record) {
        var event = record.value();
        System.out.println("### CONSUMIDO: " + event);
        // aqui você pode salvar no banco, logar, transformar, etc
        //service.salvarLancamento(event);
    }
}
