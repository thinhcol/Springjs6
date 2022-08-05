package com.PS18524.DAO;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.PS18524.entity.Product;


//import com.j5.entity.Report;


public interface ProductDAO extends JpaRepository<Product, Integer>{
	@Query("SELECT o FROM Product o WHERE o.category.id = ?1 ")
	List<Product> findByCategoryId(String id);
//	@Query("SELECT o FROM Product o WHERE o.price BETWEEN ?1 AND ?2")
//	List<Product> findByPrice(double minPrice, double maxPrice);
	List<Product> findByPriceBetween(double minPrice, double maxPrice);

//@Query("SELECT o FROM Product o WHERE o.name LIKE ?1")
//Page<Product> findByKeywords(String keywords, Pageable pageable);

	Page<Product> findAllByNameLike(String keywords, Pageable pageable);
	@Query("SELECT o FROM Product o Order by NEWID()")
	List<Product> findByrandom(); 
	
	@Query(value = "SELECT TOP 12 * FROM Products o", nativeQuery =true)
	List<Product> findTOP10(); 

//	@Query("SELECT new Report(o.category, sum(o.price), count(o)) "
//			+ " FROM Product o "
//			+ " GROUP BY o.category"
//			+ " ORDER BY sum(o.price) DESC")
//	List<Report> getInventoryByCategory();

}
