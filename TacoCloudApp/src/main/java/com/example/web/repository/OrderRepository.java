package com.example.web.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.web.domain.Order;
import com.example.web.domain.User;

public interface OrderRepository extends JpaRepository<Order, Integer> {
	List<Order> findByZip(String zip);

	List<Order> readOrdersByZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

	List<Order> findByUserOrderByPlacedAtDesc(User user, Pageable pageable);
}
