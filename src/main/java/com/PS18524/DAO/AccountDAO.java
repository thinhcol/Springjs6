	package com.PS18524.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PS18524.entity.Account;





public interface AccountDAO extends JpaRepository<Account, String>{
	@Query("Select DISTINCT ar.account FROM Authority ar Where ar.role.id IN ('DIRE','STAF')")
	List<Account> getAdministrators();
}
