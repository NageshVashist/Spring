package com.api.inventory.config;

import java.io.IOException;
import java.util.Map;

import org.apache.kafka.common.serialization.Deserializer;

import com.api.inventory.model.Inventory;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonNodeDes implements Deserializer<Inventory> {

	private ObjectMapper mapper = new ObjectMapper();

	@Override
	public Inventory deserialize(String topic, byte[] data) {

		try {
			return mapper.readValue(data, Inventory.class);
		} catch (IOException e) {
			return null;
		}
	}

	@Override
	public void close() {
	}

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {
		// TODO Auto-generated method stub

	}
}
