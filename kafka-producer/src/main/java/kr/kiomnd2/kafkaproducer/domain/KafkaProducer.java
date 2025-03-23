package kr.kiomnd2.kafkaproducer.domain;

import kr.kiomnd2.kafkaproducer.domain.model.KafkaMessage;
import org.springframework.kafka.support.SendResult;

import java.util.concurrent.CompletableFuture;

public interface KafkaProducer<T> {
    CompletableFuture<SendResult<String, KafkaMessage<Object>>> sendMessage(String topic, String senderId, T message);
}
