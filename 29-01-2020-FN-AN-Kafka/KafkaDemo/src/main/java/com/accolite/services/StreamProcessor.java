package com.accolite.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class StreamProcessor {
	private final Logger logger = LoggerFactory.getLogger(StreamProcessor.class);
	private static final String TOPIC = "darshan2"; // topic darshan2 created through kafka cli

	@KafkaListener(topics = "darshan", groupId = "group_id") // listening for topic darshan
	public void consume(String message) {

		String sendMsg = " ";
		
		// checks if odd and compute length of number
		if (Integer.parseInt(message) % 2 != 0) {
			sendMsg = Integer.toString(message.length());
		} 
		else
			sendMsg = message;

		logger.info(String.format("Consumed in Stream Processor => %s", sendMsg));
		
		this.sendMessage(sendMsg); // sends computed result to another topic
	}

	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendMessage(String message) {

		logger.info(String.format("Produced message in Stream Processor => %s", message));
		
		this.kafkaTemplate.send(TOPIC, message); // sends computed result to another topic darshan2
	 }
}


