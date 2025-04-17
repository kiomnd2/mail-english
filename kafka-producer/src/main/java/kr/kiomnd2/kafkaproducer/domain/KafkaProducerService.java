package kr.kiomnd2.kafkaproducer.domain;

import kr.kiomnd2.kafkaproducer.domain.history.KafkaHistoryMessageStore;
import kr.kiomnd2.kafkaproducer.domain.history.KafkaMessageHistory;
import kr.kiomnd2.kafkaproducer.domain.model.KafkaMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class KafkaProducerService<T> {
    private final KafkaProducer<T> kafkaProducer;
    private final KafkaHistoryMessageStore messageStore;

    public void produce(String topic, String senderId, T message) {
        KafkaMessage<Object> kafkaMessage = KafkaMessage.builder()
                .message(message)
                .sender(senderId).build();

        kafkaProducer.sendMessage(topic, kafkaMessage).whenComplete((r, throwable) -> {
            if (throwable == null) {
                // 성공처리
                messageStore.store(KafkaMessageHistory.builder()
                                .messageId(kafkaMessage.getId())
                                .errorMessage(null)
                                .status(KafkaStatus.NORMAL)
                        .build());
            } else {
                log.error("카프카 처리 중 오류", throwable);
                messageStore.store(KafkaMessageHistory.builder()
                        .messageId(kafkaMessage.getId())
                        .errorMessage(throwable.getMessage())
                        .status(KafkaStatus.ERROR)
                        .build());
            }
        });
    }
}
