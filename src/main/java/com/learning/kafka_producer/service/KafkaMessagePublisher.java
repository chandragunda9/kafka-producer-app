package com.learning.kafka_producer.service;

import java.util.concurrent.CompletableFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import com.learning.dto.Student;


@Service
public class KafkaMessagePublisher {

	@Autowired
	KafkaTemplate<String, Object> template;

	public void sendMessageToTopic(String message) {
//		CompletableFuture<SendResult<String, Object>> future = template.send("spring-topic", message);
//		CompletableFuture<SendResult<String, Object>> future = template.send("spring-topic2", message);
//		CompletableFuture<SendResult<String, Object>> future = template.send("spring-topic3", message);
//		CompletableFuture<SendResult<String, Object>> future = template.send("spring-topic4", message);
		CompletableFuture<SendResult<String, Object>> future = template.send("kafka-topic-1", message);
		future.whenComplete((res, ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent message=[" + message + "] with partition=[" + res.getRecordMetadata().partition() + "]");
				System.out.println(
						"Sent message=[" + message + "] with offset=[" + res.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to sent message - Exception e=["+ex.getMessage()+"]");
			}
		});
	}
	
	
	public void sendEventToStudentTopic(Student student) {
		CompletableFuture<SendResult<String, Object>> future = template.send("student-topic-2", student);
		future.whenComplete((res, ex) -> {
			if (ex == null) {
				System.out.println(
						"Sent message=[" + student + "] with partition=[" + res.getRecordMetadata().partition() + "]");
				System.out.println(
						"Sent message=[" + student + "] with offset=[" + res.getRecordMetadata().offset() + "]");
			} else {
				System.out.println("Unable to sent message - Exception e=["+ex.getMessage()+"]");
			}
		});
	}

}
