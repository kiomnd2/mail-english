package kr.kiomnd2.kafkaproducer.infrastructure;

import kr.kiomnd2.kafkaproducer.domain.KafkaProducer;
import kr.kiomnd2.kafkaproducer.domain.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.serialization.Serdes;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Slf4j
@Component
@RequiredArgsConstructor
public class KafkaProducerImpl<T> implements KafkaProducer<T> {
    private final KafkaTemplate<String, KafkaMessage<Object>> kafkaTemplate;

    @Override
    public CompletableFuture<SendResult<String, KafkaMessage<Object>>> sendMessage(String topic,
                                                                                   KafkaMessage<Object> kafkaMessage) {
        return kafkaTemplate.send(topic, kafkaMessage);
    }
}
