package com.mtoaima.productapp.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.mtoaima.productapp.DTO.Voucher;
import com.mtoaima.productapp.model.Product;
import com.mtoaima.productapp.repos.ProductRepository;

@RestController
@RequestMapping("/productsapi")
public class ProductRestController {
	
	@Autowired
	ProductRepository repo;
	
	@Autowired
	RestTemplate restTemplate;
	
	@Value("${voucherService.url}")
	private String voucherServiceURL;
	
	@PostMapping("/products")
	public Product createProduct(@RequestBody Product product) {
		Voucher voucher  = restTemplate.getForObject(voucherServiceURL + product.getVoucherCode(),
				Voucher.class);
		product.setPrice(product.getPrice().subtract(voucher.getDiscount()));
		return repo.save(product);
	}
	
	@GetMapping("/products/{id}")
	public Product getProductBYId(@PathVariable("id") Long id) {
		return repo.findById(id).get();
	}
	
	@GetMapping("/products")
	public List<Product> getProducts() {
		return repo.findAll();
	}

}
