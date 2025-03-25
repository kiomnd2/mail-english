package kr.kiomnd2.kafkaproducer.domain.history;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import kr.kiomnd2.kafkaproducer.domain.KafkaStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class KafkaMessageHistory {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String messageId;
    private KafkaStatus status;
    private String errorMessage;
    LocalDateTime createAt;

    @Builder
    public KafkaMessageHistory(String messageId, KafkaStatus status, String errorMessage) {
        this.messageId = messageId;
        this.status = status;
        this.errorMessage = errorMessage;
        this.createAt = LocalDateTime.now();
    }
}
