package com.PS18524.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.PS18524.DAO.OrderDetailDAO;

@Controller
public class ChartController {
	@Autowired
	OrderDetailDAO dao;
	@RequestMapping("/admin/thongke/doanhthu") 
	public String main(Model model) {
		List<String> name = dao.sanphammuanhieu().stream().map(x -> x.getName()).collect(Collectors.toList());
		List<Long> soluong = dao.sanphammuanhieu().stream().map(x -> x.getSoluong()).collect(Collectors.toList());
		List<String> name1 = dao.sanphamtien().stream().map(y -> y.getName()).collect(Collectors.toList());
		List<Double> tien = dao.sanphamtien().stream().map(y-> y.getTien()).collect(Collectors.toList());
		model.addAttribute("name",name);
		model.addAttribute("soluong",soluong);
//		model.addAttribute("name1",name1);
//		model.addAttribute("tien",tien);
		model.addAttribute("sptien",dao.sanphamtien());
		return "/cozastore-master/chart";
	}
}
