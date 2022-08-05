package com.PS18524.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PS18524.DAO.AccountDAO;
import com.PS18524.DAO.RoleDAO;
import com.PS18524.entity.Account;
import com.PS18524.entity.Role;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/accounts")
public class AccountRestController {
	@Autowired
	AccountDAO dao;
	
	@GetMapping
	public List<Account> getAll(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return dao.getAdministrators();
		}
		return dao.findAll();
	}
}
