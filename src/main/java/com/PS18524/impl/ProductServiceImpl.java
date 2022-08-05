package com.PS18524.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS18524.DAO.ProductDAO;
import com.PS18524.entity.Product;
import com.PS18524.service.ProductService;
@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	ProductDAO pdao;

	@Override
	public List<Product> findAll() {
		return pdao.findAll();
	}
 
	@Override
	public Product findById(Integer id) {
		return pdao.findById(id).get();
	}

	@Override
	public List<Product> findByCategoryId(String cid) {
		// TODO Auto-generated method stub 
		return pdao.findByCategoryId(cid);
	}
}
