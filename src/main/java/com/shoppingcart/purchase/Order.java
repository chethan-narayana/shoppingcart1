package com.shoppingcart.purchase;

import com.shoppingcart.core.Product;
import com.shoppingcart.core.ProductCatalogue;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {
    private Map<Product, Integer> shoppingBag = new HashMap<>();
    private Map<BigInteger, Product> productCatalogueMaster = ProductCatalogue.getInstance().getProductCatalogue();

    public boolean addProduct(BigInteger barCode) {

        if (productCatalogueMaster.containsKey(barCode)) {
            Product product = productCatalogueMaster.get(barCode);
            shoppingBag.merge(product, 1, (currentCount, value) -> currentCount + value);
            return true;
        }

        return false;
    }

    public boolean removeProduct(BigInteger barCode) {
        Product product = productCatalogueMaster.get(barCode);

        if (!shoppingBag.containsKey(product)) {
            return false;
        }


        shoppingBag.computeIfPresent(product, (ignoreKey, currentValue) -> currentValue - 1);
        shoppingBag.remove(product, 0);
        return true;
    }

    public void checkOut() {
        System.out.println("Order Summary");
        for (Product product : shoppingBag.keySet()) {
            System.out.println("Product Name : " + product.getName() + " " + shoppingBag.get(product) + "X" + product.getPrice() + " = " + (product.getPrice() * shoppingBag.get(product)) + " SGD");
        }
        shoppingBag.clear();
    }

    public Map<Product, Integer> getShoppingBag() {
        return shoppingBag;
    }
}

