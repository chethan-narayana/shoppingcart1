package com.shoppingcart.purchase;

import com.shoppingcart.core.Product;
import com.shoppingcart.core.ProductCatalogue;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Map;

import static org.junit.Assert.*;

public class OrderTest {

    private Order order;
    private Map<BigInteger, Product> productCatalogueMaster;

    @Before
    public void init() {

        productCatalogueMaster = ProductCatalogue.getInstance().getProductCatalogue();
        order = new Order();
    }

    @Test
    public void testAddAProduct() {
        assertTrue(order.addProduct(BigInteger.valueOf(122222222)));

        Product product = productCatalogueMaster.get(BigInteger.valueOf(122222222));
        int count = order.getShoppingBag().get(product);
        assertEquals(1, count);
    }

    @Test
    public void testAddAnInvalidProduct() {
        assertFalse(order.addProduct(BigInteger.valueOf(125222222)));

        int count = order.getShoppingBag().size();
        assertEquals(0, count);
    }

    @Test
    public void testAddAValidProductTwice() {
        assertTrue(order.addProduct(BigInteger.valueOf(122222222)));
        assertTrue(order.addProduct(BigInteger.valueOf(122222222)));

        Product product = productCatalogueMaster.get(BigInteger.valueOf(122222222));
        int count = order.getShoppingBag().get(product);
        assertEquals(2, count);
    }

    @Test
    public void testRemoveAProductFromShoppingcart() {
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(122222222));

        assertTrue(order.removeProduct(BigInteger.valueOf(122222222)));

        Product product = productCatalogueMaster.get(BigInteger.valueOf(122222222));
        int count = order.getShoppingBag().get(product);
        assertEquals(1, count);
    }

    @Test
    public void testRemoveASingleProductFromShoppingcart() {
        order.addProduct(BigInteger.valueOf(122222222));

        assertTrue(order.removeProduct(BigInteger.valueOf(122222222)));

        Product product = productCatalogueMaster.get(BigInteger.valueOf(122222222));
        assertFalse(order.getShoppingBag().containsKey(product));
    }

    @Test
    public void testRemoveANonExistantProductFromShoppingcart() {

        assertFalse(order.removeProduct(BigInteger.valueOf(122222222)));

        Product product = productCatalogueMaster.get(BigInteger.valueOf(122222222));
        assertFalse(order.getShoppingBag().containsKey(product));
    }

    @Test
    public void testRemoveAProductFromShoppingcartWithMultipleProdcts() {
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(122222222));
        order.addProduct(BigInteger.valueOf(344556666));

        assertTrue(order.removeProduct(BigInteger.valueOf(122222222)));

        Product product = productCatalogueMaster.get(BigInteger.valueOf(122222222));
        int count = order.getShoppingBag().get(product);
        assertEquals(1, count);
    }

    @Test
    public void testRemoveAnInvalidProductFromShoppingcart() {

        assertFalse(order.removeProduct(BigInteger.valueOf(122922222)));
        assertTrue(order.getShoppingBag().isEmpty());
    }
}
