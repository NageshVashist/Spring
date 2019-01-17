package com.example.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.web.config.OrderProps;
import com.example.web.domain.Order;
import com.example.web.domain.User;
import com.example.web.repository.OrderRepository;

@Controller
@RequestMapping("/orders")
@SessionAttributes("order")
@ConfigurationProperties(prefix = "taco.orders")
public class OrderController {

	private OrderProps props;

	@Autowired
	OrderRepository orderRepo;
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);

	@GetMapping("/current")
	public String orderForm() {
		return "orderForm";
	}

	@PostMapping
	public String processOrder(@Valid Order order, Errors errors, SessionStatus sessionStatus,
			@AuthenticationPrincipal User user) {
		if (errors.hasErrors()) {
			return "orderForm";
		}
		order.setUser(user);
		orderRepo.save(order);
		log.info("Order submitted: " + order);
		sessionStatus.setComplete();
		return "redirect:/design";
	}

	@GetMapping
	public String ordersForUser(@AuthenticationPrincipal User user, Model model) {
		Pageable pageable = PageRequest.of(0, props.getPageSize());
		model.addAttribute("orders", orderRepo.findByUserOrderByPlacedAtDesc(user, pageable));
		return "orderList";
	}
}