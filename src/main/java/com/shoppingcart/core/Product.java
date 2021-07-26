package com.shoppingcart.core;

import java.math.BigInteger;
import java.util.Objects;

public class Product {

    private String name;
    private BigInteger barCode;
    private double price;

    public Product(String name, BigInteger barCode, double price) {
        this.name = name;
        this.barCode = barCode;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigInteger getBarCode() {
        return barCode;
    }

    public void setBarCode(BigInteger barCode) {
        this.barCode = barCode;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return getBarCode().equals(product.getBarCode());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBarCode());
    }
}
