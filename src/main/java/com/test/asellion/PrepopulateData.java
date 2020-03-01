package com.test.asellion;

import java.math.BigDecimal;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.asellion.entity.Product;
import com.test.asellion.repository.ProductRepository;

@Component
public class PrepopulateData {
	
	@Autowired
	private ProductRepository productRepo;
	
	
	@PostConstruct
	public void init() {
		String[] nameArr = new String[] {"Product A","Product B","Product C","Product D"};
		BigDecimal[] priceArr = new BigDecimal[] {BigDecimal.valueOf(10.50), BigDecimal.valueOf(21.30), BigDecimal.valueOf(11.00), BigDecimal.valueOf(100.70)};
		for (int i = 0; i < priceArr.length; i++) {
			Product product = new Product();
			product.setCurrentPrice(priceArr[i]);
			product.setName(nameArr[i]);
			productRepo.saveAndFlush(product);
		}
	}

}
