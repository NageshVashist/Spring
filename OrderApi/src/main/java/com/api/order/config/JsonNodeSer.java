package com.api.order.config;

import java.util.Map;

import org.apache.kafka.common.serialization.Serializer;

import com.api.order.model.Inventory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeSer implements Serializer<Inventory> {

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public byte[] serialize(String topic, Inventory data) {

		try {
			return mapper.writeValueAsBytes(data);
		} catch (JsonProcessingException e) {
			return new byte[0];
		}
	}

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}
}
