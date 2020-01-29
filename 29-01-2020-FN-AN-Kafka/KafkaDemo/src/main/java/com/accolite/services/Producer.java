package com.accolite.services;

import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class Producer {
	
	private static final Logger logger = LoggerFactory.getLogger(Producer.class);
	private static final String TOPIC = "darshan"; // topic created through kafka cli

	@Autowired // for accessing topics on kafka
	private KafkaTemplate<String, String> kafkaTemplate;

	// for sending message to topic darshan
	public void sendMessage() { 

		Timer timer = new Timer(); // for running it every 2 seconds
		timer.schedule(new TimerTask() {

			@Override
			public void run() {

				Random rand = new Random(); // instance of random class
				String int_random = Integer.toString(rand.nextInt(10000));

				logger.info(String.format("Produced message by Producer = %s", int_random)); // displaying sent message
				
				kafkaTemplate.send(TOPIC, int_random); // send message to topic
			}
		}, 0, 2000); 

	}

}