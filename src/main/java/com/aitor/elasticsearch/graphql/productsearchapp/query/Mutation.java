package com.aitor.elasticsearch.graphql.productsearchapp.query;

import com.aitor.elasticsearch.graphql.productsearchapp.exceptions.InvalidProductDataException;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product.Category;
import com.aitor.elasticsearch.graphql.productsearchapp.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;

/**
 * Mutations class that allows to add products.
 */
@Component
@AllArgsConstructor
public class Mutation implements GraphQLMutationResolver {

    @Autowired
    private ProductService productService;

    /**
     * Allows to add a product.
     * 
     * @param id           the ID of the product.
     * @param name         the name of the product.
     * @param sku          the sku of the product.
     * @param category     the category of the product.
     * @param manufacturer the manufacturer of the product.
     * @throws InvalidProductDataException
     * @return the created product.
     */
    public Product addProduct(String id, String name, String sku, String category, String manufacturer) throws InvalidProductDataException {
        try {
            Product p = new Product(id, name, sku, Category.valueOf(category.toUpperCase()), manufacturer);
            return productService.save(p);
        } catch (Exception ex) {
            throw new InvalidProductDataException(ex.getMessage());
        }
    }
}
