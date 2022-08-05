package com.PS18524.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.PS18524.DAO.AccountDAO;
import com.PS18524.DAO.AuthorityDAO;
import com.PS18524.entity.Account;
import com.PS18524.entity.Authority;
import com.PS18524.service.AuthorityService;
@Service
public class AuthorityServiceImpl implements AuthorityService{
	@Autowired
	AuthorityDAO dao;
	@Autowired
	AccountDAO accdao;
	@Override
	public List<Authority> findOfAdministrators() {
		List<Account> acc = accdao.getAdministrators();
		return dao.Authorityof(acc);
	}

}
