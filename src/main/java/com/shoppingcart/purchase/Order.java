package com.shoppingcart.purchase;

import com.shoppingcart.core.Product;
import com.shoppingcart.core.ProductCatalogue;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Order {

    private Map<Product, Integer> shoppingBag;
    private Map<BigInteger, Product> productCatalogueMaster;

    public Order() {
        this.shoppingBag = new HashMap<>();
        productCatalogueMaster = ProductCatalogue.getInstance().getProductCatalogue();
    }

    public boolean addProduct(BigInteger barCode) {

        Product product = productCatalogueMaster.get(barCode);
        //If barcode is invalid or Barcode doesn't exist
        if (Objects.isNull(product)) {
            return false;
        }

        if (shoppingBag.containsKey(product)) {
            int quantity = shoppingBag.get(product);
            shoppingBag.put(product, ++quantity);
        } else {
            shoppingBag.put(product, 1);
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
            System.out.println("Product Name : " + product.getName() + " " + shoppingBag.get(product) + "X" + product.getPrice() + " = " + (product.getPrice() * shoppingBag.get(product)) + " SGD");
        }
    }

    public int size()
    {
        return shoppingBag.keySet().size();
    }
}

