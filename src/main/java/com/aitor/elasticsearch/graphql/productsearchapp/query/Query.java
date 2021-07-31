package com.aitor.elasticsearch.graphql.productsearchapp.query;

import java.util.List;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;
import com.aitor.elasticsearch.graphql.productsearchapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;

/**
 * Query class that allows to get products.
 */
@Component
@AllArgsConstructor
public class Query implements GraphQLQueryResolver {

    @Autowired
    private ProductService productService;

    /**
     * Gets a list of products using a Fuzzy search query.
     * @param query the query to search.
     * @return a List of Products.
     */
    public List<Product> getProductFuzzySearch(String query) {
        return productService.getByCustomQuery(query);
    }
}