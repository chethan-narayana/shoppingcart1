package com.shoppingcart.purchase;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;

public class OrderTest {

    private Order order;
    @Before
    public void init()
    {
        order = new Order();
    }
    @Test
    public void testAddProduct()
    {
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(344556666));
        Assert.assertEquals(2, order.size());
    }

    @Test
    public void testRemoveProduct()
    {
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(344556666));
        order.removeProduct(BigInteger.valueOf(344556666));
        Assert.assertEquals(1, order.size());
    }
}
