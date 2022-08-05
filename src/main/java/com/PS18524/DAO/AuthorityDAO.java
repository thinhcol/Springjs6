package com.PS18524.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PS18524.entity.Account;
import com.PS18524.entity.Authority;

public interface AuthorityDAO extends JpaRepository<Authority, Integer>{
	@Query("Select DISTINCT a FROM Authority a Where a.account IN ?1")
	List<Authority> Authorityof(List<Account> accounts);
}
