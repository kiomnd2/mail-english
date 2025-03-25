package kr.kiomnd2.kafkaproducer.infrastructure.history;

import kr.kiomnd2.kafkaproducer.domain.history.KafkaMessageHistory;
import kr.kiomnd2.kafkaproducer.domain.history.KafkaHistoryMessageStore;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class KafkaHistoryMessageStoreImpl implements KafkaHistoryMessageStore {
    private final KafkaHistoryRepository kafkaHistoryRepository;

    @Override
    public void store(KafkaMessageHistory history) {
        kafkaHistoryRepository.save(history);
    }
}
