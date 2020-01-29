package com.accolite.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.accolite.services.Producer;

@RestController
@RequestMapping(value = "/kafka") // root mapping
public class KafkaController {

	private final Producer producer; 

	@Autowired // to couple producer with the controller
	public KafkaController(Producer producer) {
		this.producer = producer;
	}

	@PostMapping(value = "/publish") // hit localhost:9000/kafka/publish to start sending 
	public void sendMessageToKafkaTopic() {
		this.producer.sendMessage();
	}
}
