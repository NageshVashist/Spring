package com.example.web.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.web.domain.Ingredient;
import com.example.web.domain.Order;
import com.example.web.domain.Taco;
import com.example.web.domain.Ingredient.Type;
import com.example.web.repository.IngredientRepository;
import com.example.web.repository.TacoRepository;

@Controller
@RequestMapping("/design")
@SessionAttributes("order")
public class DesignTacoController {
	private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(DesignTacoController.class);
	@Autowired
	IngredientRepository ingredientsRepo;
	@Autowired
	TacoRepository tacoRepo;

	@ModelAttribute(name = "order")
	public Order order() {
		return new Order();
	}

	@ModelAttribute(name = "taco")
	public Taco taco() {
		return new Taco();
	}

	@GetMapping
	public String showDesignForm(Model model) {
		List<Ingredient> ingredients = ingredientsRepo.findAll();
		Type[] types = Ingredient.Type.values();
		for (Type type : types) {
			model.addAttribute(type.toString().toLowerCase(), filterByType(ingredients, type));
		}
		model.addAttribute("taco", new Taco());
		return "design";
	}

	@PostMapping
	public String processDesign(@Valid Taco taco, Errors errors,@ModelAttribute Order order) {

		if (errors.hasErrors()) {
			return "design";
		}
		tacoRepo.save(taco);
		order.addTaco(taco);
		log.info("Processing design: " + taco);
		return "redirect:/orders/current";
	}

	private Object filterByType(List<Ingredient> ingredients, Type type) {
		List<Ingredient> filteredList = new ArrayList<>();
		for (Ingredient ingredient : ingredients) {
			if (ingredient.getType().equals(type)) {
				filteredList.add(ingredient);
			}

		}
		return filteredList;
	}

}
