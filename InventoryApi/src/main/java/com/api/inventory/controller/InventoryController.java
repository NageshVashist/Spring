package com.api.inventory.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.inventory.model.Inventory;
import com.api.inventory.repository.ItemRepo;

@RestController
@RequestMapping("api/inventory")
public class InventoryController {

	@Autowired
	ItemRepo repo;

	@GetMapping
	public List<Inventory> getAllItem() {
		return repo.findAll();
	}

}
