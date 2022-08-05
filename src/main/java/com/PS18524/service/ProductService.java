package com.PS18524.service;

import java.util.List;
import java.util.Optional;

import com.PS18524.entity.Product;

public interface ProductService {

	List<Product> findAll();

	Product findById(Integer id);

	List<Product> findByCategoryId(String cid);

}
