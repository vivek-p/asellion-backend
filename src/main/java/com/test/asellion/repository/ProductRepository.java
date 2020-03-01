package com.test.asellion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.test.asellion.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
