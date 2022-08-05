package com.PS18524.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PS18524.DAO.OrderDAO;
import com.PS18524.entity.Order;
import com.PS18524.entity.Product;
import com.PS18524.service.OrderService;
import com.PS18524.service.ProductService;
import com.fasterxml.jackson.databind.JsonNode;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/orders")
public class OrderRestController {
	@Autowired
	OrderService service;
	
	@PostMapping()
	public Order create(@RequestBody JsonNode data) {
		return service.create(data);
	}
}
