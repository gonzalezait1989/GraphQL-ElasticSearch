package com.aitor.elasticsearch.graphql.productsearchapp.service.impl;

import java.util.List;

import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;
import com.aitor.elasticsearch.graphql.productsearchapp.repositories.ProductDAO;
import com.aitor.elasticsearch.graphql.productsearchapp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
    
    @Autowired
    private ProductDAO productDao;

    @Override
    public List<Product> getByCustomQuery(String query) {
        return productDao.getByCustomQuery(query);
    }

    @Override
    public Product save(Product product) {
        return productDao.save(product);
    }
    
}
