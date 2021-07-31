package com.aitor.elasticsearch.graphql.productsearchapp;

import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product.Category;
import com.aitor.elasticsearch.graphql.productsearchapp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductsearchappApplication implements CommandLineRunner {

	@Autowired
	private ProductService productService;
	
	public static void main(String[] args) {
		SpringApplication.run(ProductsearchappApplication.class, args);
	}

	@Override
    public void run(String... args) throws Exception {
        productService.save(new Product("1", "Freezer", "123456", Category.HOME_APPLIANCE, "LG"));
        productService.save(new Product("2", "Metal Gear Solid", "654321", Category.GAMES, "Konami"));
        productService.save(new Product("3", "Super TV 42 inch", "321456", Category.TV, "Samsung"));
		productService.save(new Product("4", "Programable VCR", "324156", Category.TV, "Sanyo"));
		productService.save(new Product("5", "Final Fantasy VII", "231465", Category.GAMES, "Squaresoft"));
	}


}
