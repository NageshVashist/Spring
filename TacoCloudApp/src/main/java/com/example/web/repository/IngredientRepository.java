package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.domain.Ingredient;

public interface IngredientRepository extends JpaRepository<Ingredient, String> {

}
