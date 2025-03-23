package kr.kiomnd2.kafkaproducer.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum KafkaStatus {
    ERROR("오류"),
    NORMAL("정상");

    private final String description;
}
