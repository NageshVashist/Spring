package com.api.order.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.api.order.model.Inventory;

@Service
public class KafkaServiceProducer {
	private KafkaTemplate<String, Inventory> kafkaTemplate;

	@Autowired
	public KafkaServiceProducer(KafkaTemplate<String, Inventory> kafkaTemplate) {
		this.kafkaTemplate = kafkaTemplate;
	}

	public void sendOrder(Inventory order) {
		kafkaTemplate.send("MyTopic", order);
	}

}
