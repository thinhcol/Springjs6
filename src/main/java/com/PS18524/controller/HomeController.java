package com.PS18524.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PS18524.DAO.OrderDetailDAO;


@Controller
public class HomeController {
	
	@RequestMapping({"/","/home/index"})
	public String home() {
		return "redirect:/product/list";
	}
	@RequestMapping({"/admin","/admin/home/index"})
	public String admin(Model model) {
		return "redirect:/admin/home.html";
	}
}
