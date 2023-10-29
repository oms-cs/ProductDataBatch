package com.ecom.airy.batch.processor;

import com.ecom.airy.batch.model.Product;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ParseException;

public class ProductItemProcessor implements ItemProcessor<Product, Product> {

    private static final Logger logger = LoggerFactory.getLogger(ProductItemProcessor.class);

    @Override
    public Product process(Product product) throws Exception {
        int productRating;
        int overallRating;
        try {
            productRating = Integer.parseInt(product.getProductRating());
        }catch (NumberFormatException e){
            productRating = 0;
        }

        try {
            overallRating = Integer.parseInt(product.getOverallRating());
        }catch (NumberFormatException e){
            overallRating = 0;
        }
        product.setProductRating(String.valueOf(productRating));
        product.setOverallRating(String.valueOf(overallRating));

        return product;
    }
}
