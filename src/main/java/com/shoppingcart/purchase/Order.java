package com.shoppingcart.purchase;

import com.shoppingcart.core.Product;
import com.shoppingcart.core.ProductCatalogue;

import java.math.BigInteger;
import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {

    private Map<Product, Integer> shoppingBag = null;

    public Order() {
        this.shoppingBag = new HashMap<>();
    }

    public boolean addProduct(BigInteger barCode) {

        Map<BigInteger, Product> productCatalogueMaster = ProductCatalogue.getInstance().getProductCatalogue();
        if (Objects.isNull(barCode) || productCatalogueMaster.get(barCode) == null) {
            return false;
        }
        Product product = productCatalogueMaster.get(barCode);
        if (shoppingBag.containsKey(product)) {
            int quantity = shoppingBag.get(product);
            shoppingBag.put(productCatalogueMaster.get(barCode), ++quantity);
        } else {
            shoppingBag.put(productCatalogueMaster.get(barCode), 1);
        }
        return true;
    }

    public boolean removeProduct(BigInteger barCode) {
        for (Product product : shoppingBag.keySet()) {
            if (product.getBarCode().equals(barCode)) {
                int value = shoppingBag.get(product);
                if (value > 1) shoppingBag.put(product, --value);
                else shoppingBag.remove(product);
                return true;
            }

        }
        return false;
    }

    public void checkOut() {
        System.out.println("Order Summary");
        for (Product product : shoppingBag.keySet()) {
            System.out.println("Product Name : " + product.getName() + " " + shoppingBag.get(product) + "X" + product.getPrice() + " = " + (product.getPrice() * shoppingBag.get(product)));
        }
    }
}

