package kr.kiomnd2.kafkaproducer.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.UUID;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class KafkaMessage<T> {
    private String id;
    private T message;
    private String sender;
    private LocalDateTime sendAt;

    public KafkaMessage(T message, String sender) {
        this.id = UUID.randomUUID().toString();
        this.message = message;
        this.sender = sender;
        this.sendAt = LocalDateTime.now();
    }
}
