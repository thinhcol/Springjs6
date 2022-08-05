package com.PS18524.service;

import com.PS18524.entity.Order;
import com.fasterxml.jackson.databind.JsonNode;

public interface OrderService {
 
	Order create(JsonNode data);

}
  