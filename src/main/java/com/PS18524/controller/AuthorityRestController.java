package com.PS18524.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.PS18524.DAO.AccountDAO;
import com.PS18524.DAO.AuthorityDAO;
import com.PS18524.DAO.RoleDAO;
import com.PS18524.entity.Account;
import com.PS18524.entity.Authority;
import com.PS18524.entity.Role;
import com.PS18524.service.AuthorityService;

@CrossOrigin("*")
@RestController
@RequestMapping("/rest/authorities")
public class AuthorityRestController {
	@Autowired
	AuthorityDAO dao;
	
	@Autowired
	AuthorityService service;
	@GetMapping
	public List<Authority> getAll(@RequestParam("admin") Optional<Boolean> admin){
		if(admin.orElse(false)) {
			return service.findOfAdministrators();
		}
		return dao.findAll();
	}
	
	@PostMapping
	public Authority post(@RequestBody Authority auth) {
		return dao.save(auth);
	}
	
	@DeleteMapping("{id}")
	public void delete(@PathVariable("id") Integer id) {
		dao.deleteById(id);
	}
}
