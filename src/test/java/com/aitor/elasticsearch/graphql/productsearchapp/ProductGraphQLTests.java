package com.aitor.elasticsearch.graphql.productsearchapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.Collections;
import java.util.List;

import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product.Category;
import com.aitor.elasticsearch.graphql.productsearchapp.service.ProductService;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTestTemplate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ExtendWith(MockitoExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductGraphQLTests {

    @Mock
    private ProductService productService;

    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @Test
    public void fuzzySearchProducts() throws IOException {
        Product testProduct = new Product("1", "Freezer", "123456", Category.HOME_APPLIANCE, "LG");
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/find-products-fuzzy-search.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        List<Product> products = response.getList("$.data.productFuzzySearch", Product.class);
        assertNotNull(products);
        assertEquals(products.size(), 1);
        assertEquals(testProduct, products.get(0));
    }

    @Test
    public void addProducts() throws IOException {
        Product testProduct = new Product("1", "Freezer", "123456", Category.HOME_APPLIANCE, "LG");
        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/add-product.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());
        Product product = response.get("$.data.addProduct", Product.class);
        assertNotNull(product);
        assertEquals(testProduct, product);
    }
}
