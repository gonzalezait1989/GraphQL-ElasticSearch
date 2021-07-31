package com.aitor.elasticsearch.graphql.productsearchapp;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product;
import com.aitor.elasticsearch.graphql.productsearchapp.model.Product.Category;
import com.aitor.elasticsearch.graphql.productsearchapp.service.ProductService;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductElasticTests {

    @Autowired
    private ProductService productService;

    @Test
    public void testSave() {

        Product product = new Product("1", "Freezer", "123456", Category.HOME_APPLIANCE, "LG");
        Product testProduct = productService.save(product);

        assertNotNull(product.getId());
        assertEquals(product.getName(), testProduct.getName());
        assertEquals(product.getSku(), testProduct.getSku());
        assertEquals(product.getCategory(), testProduct.getCategory());
        assertEquals(product.getManufacturer(), testProduct.getManufacturer());
    }

    @Test
    public void testFindFuzzy() {

        Product product = new Product("1", "Freezer", "123456", Category.HOME_APPLIANCE, "LG");
         productService.save(product);

         List<Product> testProducts = productService.getByCustomQuery("LG Freezar");

         assertNotNull(testProducts);
         assertEquals(testProducts.size(), 1);
         assertNotNull(testProducts.get(0).getId());
         assertEquals(product.getName(), testProducts.get(0).getName());
         assertEquals(product.getSku(), testProducts.get(0).getSku());
         assertEquals(product.getCategory(), testProducts.get(0).getCategory());
         assertEquals(product.getManufacturer(), testProducts.get(0).getManufacturer());
    }
}