package kr.kiomnd2.kafkaproducer.domain.history;

public interface KafkaHistoryMessageStore {
    void store(KafkaMessageHistory history);
}
