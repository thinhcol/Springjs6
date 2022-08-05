package com.PS18524.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PS18524.entity.Order;





public interface OrderDAO extends JpaRepository<Order, Long>{
	@Query("SELECT o FROM Order o where o.account.username = ?1")
	List<Order> findByUsername(String username);
}
