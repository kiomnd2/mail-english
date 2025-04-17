package kr.kiomn2.subscriber.domain.model;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Getter
@Table(name = "tb_subscribe")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Subscribe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private DifficultyLevel difficultyLevel;

    @Column
    private Integer numberOfProblems;


    @RequiredArgsConstructor
    @Getter
    enum Status {
        SUBSCRIBED("구독중"), NOT_SUBSCRIBED("구독 안함");

        private final String description;
    }

    @RequiredArgsConstructor
    @Getter
    enum DifficultyLevel {
        EASY("쉬움"), MEDIUM("중간"), HARD("어려움");

        private final String description;
    }

}
