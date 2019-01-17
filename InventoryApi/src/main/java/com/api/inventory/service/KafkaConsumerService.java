package com.api.inventory.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.api.inventory.model.Inventory;
import com.api.inventory.repository.ItemRepo;

@Service
public class KafkaConsumerService {
	@Autowired
	private ItemRepo ir;

	@KafkaListener(topics = "MyTopic")
	public void processMessage(Inventory item) {
		System.out.println("received content = " + item);
		Optional<Inventory> findById = ir.findById(item.getId());
		if (findById.isPresent()) {
			Inventory order2 = findById.get();
			order2.setQuantity(order2.getQuantity() - 1);
			ir.save(order2);
		}
	}

}
