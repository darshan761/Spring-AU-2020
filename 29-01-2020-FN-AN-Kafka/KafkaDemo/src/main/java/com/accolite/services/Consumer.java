package com.accolite.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
	
	private final Logger logger = LoggerFactory.getLogger(Consumer.class);

	@KafkaListener(topics = "darshan2", groupId = "group_id") // listening to topic darshan2 created through kafka cli
	public void consume(String message) {
		
		logger.info(String.format("Consumed message in Consumer => %s", message)); // displays message received from stream processor
		
	}
}
