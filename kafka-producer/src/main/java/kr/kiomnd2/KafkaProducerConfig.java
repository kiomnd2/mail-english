package kr.kiomnd2;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = {
        "classpath:kafka-producer-${spring.profiles.active}.properties",
        "classpath:kafka-producer.properties"
}, encoding = "UTF-8", ignoreResourceNotFound = true)
public class KafkaProducerConfig {
}
