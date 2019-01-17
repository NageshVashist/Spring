package com.api.inventory.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.inventory.model.Inventory;

public interface ItemRepo extends JpaRepository<Inventory, Integer> {

}
