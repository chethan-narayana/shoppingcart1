package com.shoppingcart.action;

import com.shoppingcart.purchase.Order;
import com.sun.org.apache.xpath.internal.operations.Or;

import java.math.BigInteger;

public class Purchase {
    public static void main(String[] args) {

        Order order = new Order();
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(344556666));
      // order.removeProduct(BigInteger.valueOf(122222222));
        //order.removeProduct(BigInteger.valueOf(122222222));
        order.checkOut();
        System.out.println("Size of bag " + order.getShoppingBag().size());

    }
}
