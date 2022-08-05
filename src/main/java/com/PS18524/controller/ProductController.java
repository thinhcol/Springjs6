package com.PS18524.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.PS18524.DAO.ProductDAO;
import com.PS18524.entity.Product;
import com.PS18524.service.ProductService;

@Controller
public class ProductController {
	@Autowired
	ProductService proservice;
	@Autowired
	ProductDAO dao;
	@RequestMapping("/product/list")
	private String list(Model model,@RequestParam("cid") Optional<String> cid) {
		if(cid.isPresent()) {
			List<Product> list = proservice.findByCategoryId(cid.get());
			model.addAttribute("items",list);
		}else {
			List<Product> list = dao.findTOP10();
			model.addAttribute("items",list); 
		}
		
		return "/cozastore-master/home";
	}
	
	@RequestMapping("/product/detail/{id}")
	private String findid(Model model,@PathVariable("id") Integer id) {
		Product item = proservice.findById(id);
		model.addAttribute("item",item); 
		return "/cozastore-master/product-detail"; 
	}
}
