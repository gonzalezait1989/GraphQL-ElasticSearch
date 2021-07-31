package com.aitor.elasticsearch.graphql.productsearchapp.service;

import java.util.List;

import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;

import org.springframework.stereotype.Service;

/**
 * Service class to perform operations over Products.
 */
@Service
public interface ProductService {

     /**
     * Allows to get a List of products using a Fuzzy search.
     * @param freeText the freeText to look up on the values.
     * @return a List of Products.
     */
    List<Product> getByCustomQuery(String query);

    /**
     * Allows to persist a Product.
     * @param product the Product to persist.
     * @return the persisted Product.
     */
    Product save(Product p);
    
}
