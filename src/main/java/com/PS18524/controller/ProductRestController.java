package com.PS18524.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PS18524.DAO.ProductDAO;
import com.PS18524.entity.Product;
import com.PS18524.service.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/products")
public class ProductRestController {
	@Autowired
	ProductService service;
	@Autowired
	ProductDAO dao;
	@GetMapping()
	public List<Product> getAll() {
		return service.findAll();
	}
	@GetMapping("{id}")
	public Product getOne(@PathVariable("id") Integer id) {
		return service.findById(id);
	}
	@PostMapping()
	public Product create(@RequestBody Product product) {
		return dao.save(product);
	} 
	@PutMapping("{id}")
	public Product update(@PathVariable("id") Integer id,@RequestBody Product product) {
		return dao.save(product);
	} 
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		dao.deleteById(id);
	}
}  
