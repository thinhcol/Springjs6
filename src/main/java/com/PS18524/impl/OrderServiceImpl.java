package com.PS18524.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS18524.DAO.OrderDAO;
import com.PS18524.DAO.OrderDetailDAO;
import com.PS18524.entity.Order;
import com.PS18524.entity.OrderDetail;
import com.PS18524.service.OrderService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
@Service
public class OrderServiceImpl implements OrderService{
	@Autowired
	OrderDAO dao;
	@Autowired
	OrderDetailDAO ddao;
	@Override
	public Order create(JsonNode data) {
		ObjectMapper mapper = new ObjectMapper();
		Order order = mapper.convertValue(data, Order.class);
		dao.save(order);
		TypeReference<List<OrderDetail>> type = new TypeReference<List<OrderDetail>>() {};
		List<OrderDetail> details = mapper.convertValue(data.get("orderDetails"), type)
				.stream().peek(d -> d.setOrder(order)).collect(Collectors.toList());
		ddao.saveAll(details);
		
		return order;
	}
	
}		
