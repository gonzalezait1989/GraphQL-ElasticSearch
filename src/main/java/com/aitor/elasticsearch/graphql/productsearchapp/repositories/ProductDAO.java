package com.aitor.elasticsearch.graphql.productsearchapp.repositories;

import java.util.List;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;
import org.springframework.data.elasticsearch.annotations.Query;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * The products DAO to perform CRUD operations.
 */
@Repository
public interface ProductDAO extends ElasticsearchRepository<Product, String> {
    
    /**
     * Allows to get a List of products using a Fuzzy search.
     * @param freeText the freeText to look up on the values.
     * @return a List of Products.
     */
    @Query("{\"multi_match\": {\"query\": \"?0\", \"fields\": [\"id\", \"name\", \"sku\", \"category\", \"manufacturer\"], \"fuzziness\": \"AUTO\"}}")
    List<Product> getByCustomQuery(String freeText);
}
