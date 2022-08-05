package com.PS18524.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PS18524.DAO.OrderDAO;

@Controller
public class OrderController {
	@Autowired
	OrderDAO dao;
	@RequestMapping("/order/checkout")
	private String index() {
		return "/cozastore-master/checkout";
	}
	@RequestMapping("/order/list")
	private String list(Model model,HttpServletRequest request) {
		String username = request.getRemoteUser();
		model.addAttribute("orders",dao.findByUsername(username));
		return "/cozastore-master/checklist";
	}
	@RequestMapping("/order/detail/{id}")
	private String detail(@PathVariable("id") Long id,Model model) {
		model.addAttribute("order",dao.findById(id).get());
		return "/cozastore-master/checkdetail";
	}
}
