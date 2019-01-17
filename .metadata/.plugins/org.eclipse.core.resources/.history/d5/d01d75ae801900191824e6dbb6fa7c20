package com.api.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.order.model.Inventory;
import com.api.order.service.KafkaServiceProducer;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@RequestMapping("api/orders")
public class OrderController {

	@Autowired
	private KafkaServiceProducer kafkaServiec;

	@PostMapping
	public ResponseEntity<Inventory> placeOrder(@RequestBody Inventory order) {

		kafkaServiec.sendOrder(order);
		System.out.println(order);
		return ResponseEntity.ok(order);

	}

}
