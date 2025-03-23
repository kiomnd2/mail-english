package kr.kiomnd2.kafkaproducer.domain.history;

import kr.kiomnd2.kafkaproducer.domain.history.model.KafkaMessageHistory;

public interface KafkaHistoryMessageStore {
    void store(KafkaMessageHistory history);
}
