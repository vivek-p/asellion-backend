package com.test.asellion.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.asellion.entity.Product;
import com.test.asellion.exception.ResourceNotFoundException;
import com.test.asellion.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {
	
	@Autowired
	private ProductRepository productRepo;
	
	@GetMapping("/products")
	public List<Product> getAll() {
		return productRepo.findAll();
	}
	
	@GetMapping("/products/{id}")
	public Product findById(@PathVariable(value="id") Long id) {
		return productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
	}
	
	@PutMapping("/products/{id}")
	public Product updateProduct(@PathVariable(value="id") Long id, @Valid @RequestBody Product productDetails) {
		System.out.println("Input = " +productDetails.toString());
		Product product = productRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Product", "id", id));
		product.setName(productDetails.getName());
		product.setCurrentPrice(productDetails.getCurrentPrice());
		Product updatedProduct = productRepo.save(product);
		return updatedProduct;
	}
	
	@PostMapping("/products")
	public Product createProduct(@Valid @RequestBody Product product) {
		return productRepo.save(product);
	}

}
