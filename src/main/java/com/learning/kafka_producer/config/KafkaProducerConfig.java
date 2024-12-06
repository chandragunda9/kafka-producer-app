package com.learning.kafka_producer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaProducerConfig {

//	@Bean
//	NewTopic createTopic() {
////		return new NewTopic("spring-topic3", 5, (short) 1);
////		return new NewTopic("spring-topic4", 3, (short) 1);
//		return new NewTopic("kafka-topic-1", 3, (short) 1);
//	}
	
	@Bean
	NewTopic createStudentTopic() {
		return new NewTopic("student-topic-2", 3, (short) 1);
	}

}
