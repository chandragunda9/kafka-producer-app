package com.learning.kafka_producer;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.awaitility.Awaitility;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.kafka.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import com.learning.dto.Student;
import com.learning.kafka_producer.service.KafkaMessagePublisher;

import scala.concurrent.Await;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Testcontainers
public class KafkaProducerApplicationTests {

//	@Container
//	static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("confluentinc/cp-kafka:latest"));

	
	@Container
	static KafkaContainer kafkaContainer = new KafkaContainer(DockerImageName.parse("apache/kafka"));

	
	@DynamicPropertySource
	static void initKafkaProps(DynamicPropertyRegistry registry) {
		registry.add("spring.kafka.bootstrap-servers", kafkaContainer::getBootstrapServers);
	}

	@Autowired
	private KafkaMessagePublisher publisher;

//	@Test
//	void contextLoads() {
//	}

	@Test
	public void testStudentEvent() {
		publisher.sendEventToStudentTopic(new Student(1, "chandra", "GMR", "Hyd"));
		Awaitility.await().pollInterval(Duration.ofSeconds(3)).atMost(10, TimeUnit.SECONDS).untilAsserted(() -> {
			//assert statement
		});
	}

}
