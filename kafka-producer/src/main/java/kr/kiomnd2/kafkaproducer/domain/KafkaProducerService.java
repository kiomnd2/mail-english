package kr.kiomnd2.kafkaproducer.domain;

import kr.kiomnd2.kafkaproducer.domain.history.KafkaHistoryMessageStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaProducerService<T> {
    private final KafkaProducer<T> kafkaProducer;
    private final KafkaHistoryMessageStore messageStore;

    public void produce(String topic, String senderId, T message) {
        kafkaProducer.sendMessage(topic, senderId, message).whenComplete((r, throwable) -> {
            if (throwable == null) {

            } else {

            }
        });
    }
}
