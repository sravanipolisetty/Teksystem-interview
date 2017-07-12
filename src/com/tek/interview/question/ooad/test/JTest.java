package com.tek.interview.question.ooad.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.tek.interview.question.ooad.Item;
import com.tek.interview.question.ooad.LineOrder;
import com.tek.interview.question.ooad.Order;

public class JTest {

	@Test
    public void testTax() {
        Item item = new Item("imported perfume", 10.0f); 

        assertEquals(1.5, item.getTaxValue(1),0);

    }
	
	@Test
    public void testNormalTax() {
        Item item = new Item("books", 10.0f); 

        assertEquals(1, item.getTaxValue(1),0);

    }

	@Test(expected = Exception.class)
    public void testNullItem() throws Exception {
        System.out.println("Null Test");
		new LineOrder(null, 1);

    }

	@Test
    public void testOrderTotal() throws Exception {
		System.out.println("Valid Test");
		Order c1 = new Order("Order 1");
		
		double grandTotal = 0;

		c1.add(new LineOrder(new Item("book", (float) 12.49), 2));
		c1.add(new LineOrder(new Item("music CD", (float) 14.99), 1));
		c1.add(new LineOrder(new Item("chocolate bar", (float) 0.85), 1));


        assertEquals(40.82, c1.printOrderAndGetTotal(),0);

    }


}
