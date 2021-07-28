package com.shoppingcart.core;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

 enum ProductName {
    APPLE, BANANNA, BRINJAL, LAYS
}

public class ProductCatalogue {


    private static ProductCatalogue productCatalogue = null;
    Map<BigInteger, Product> productCatalogueData;

    private ProductCatalogue() {
        productCatalogueData = new HashMap<>();
        productCatalogueData.put(BigInteger.valueOf(122222222), new Product(ProductName.APPLE.name(), BigInteger.valueOf(122222222), 105.65));
        productCatalogueData.put(BigInteger.valueOf(344556666), new Product(ProductName.BANANNA.name(), BigInteger.valueOf(344556666), 55.00));
        productCatalogueData.put(BigInteger.valueOf(234566666), new Product(ProductName.BRINJAL.name(), BigInteger.valueOf(234566666), 25.65));
        productCatalogueData.put(BigInteger.valueOf(453434343), new Product(ProductName.LAYS.name(), BigInteger.valueOf(453434343), 20.00));
    }

    public static ProductCatalogue getInstance() {
        if (productCatalogue == null) {
            productCatalogue = new ProductCatalogue();
        }
        return productCatalogue;
    }

    public Map<BigInteger, Product> getProductCatalogue() {
        return this.productCatalogueData;
    }
}
