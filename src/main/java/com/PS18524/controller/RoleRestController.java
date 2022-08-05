package com.PS18524.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.PS18524.DAO.RoleDAO;
import com.PS18524.entity.Role;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/roles")
public class RoleRestController {
	@Autowired
	RoleDAO dao;
	
	@GetMapping
	public List<Role> getAll(){
		return dao.findAll();
	}
}
