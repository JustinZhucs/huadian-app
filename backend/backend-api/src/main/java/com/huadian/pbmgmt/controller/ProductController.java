package com.huadian.pbmgmt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huadian.pbmgmt.dao.DaoException;
import com.huadian.pbmgmt.entities.Product;
import com.huadian.pbmgmt.services.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("products")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	
	@GetMapping(value="/all", produces = MediaType.APPLICATION_JSON_VALUE)
	public String getAllProducts() {
		System.out.println("Controller is called.");
		return "Hello, this is all I have for you.";
	}
	
	@PostMapping(value="/", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public Product submitProduct(@RequestBody Product product) {
		
		System.out.println("submitProduct: product = " + product);
		try {
			return productService.submitProduct(product);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
//		return "Product submitted - " + product;
		
	}
	
//	http://td.com/customers  (GET, POST)
//	http://td.com/customers/101 (GET, PUT, DELETE)
//	http://td.com/customers/101/accounts
//	http://td.com/customers/101/accounts/2310021
//		
//		
//		http://td.com/customers/101/accounts/2310021.html
//		http://td.com/customers/101/accounts/2310021.pdf
//		http://td.com/customers/101/accounts/2310021.txt
//			
//	GET     retrieve (R)
//	POST	create (C)
//	PUT		update (U)
//	DELETE	delete/remove (D)
//	
//	
//	CRUD
		

}
