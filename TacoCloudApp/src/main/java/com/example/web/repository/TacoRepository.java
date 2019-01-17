package com.example.web.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.domain.Taco;

public interface TacoRepository extends JpaRepository<Taco, Integer> {

}
