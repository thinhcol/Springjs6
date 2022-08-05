package com.PS18524.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.PS18524.entity.OrderDetail;
import com.PS18524.entity.TKDT;
import com.PS18524.entity.TKSP;
@Repository
public interface OrderDetailDAO extends JpaRepository<OrderDetail, Long> {
	@Query("SELECT new com.PS18524.entity.TKSP(ord.product.name,sum(ord.quantity)) FROM OrderDetail ord group by ord.product.name")
	List<TKSP> sanphammuanhieu();
	@Query("SELECT new com.PS18524.entity.TKDT(ord.product.name,sum(ord.price)) FROM OrderDetail ord group by ord.product.name")
	List<TKDT> sanphamtien(); 
} 