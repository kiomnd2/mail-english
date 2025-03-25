package kr.kiomnd2.kafkaproducer.infrastructure.history;

import kr.kiomnd2.kafkaproducer.domain.history.KafkaMessageHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KafkaHistoryRepository extends JpaRepository<KafkaMessageHistory, Long> {
}
