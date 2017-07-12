package com.tek.interview.question.ooad;

import java.util.HashMap;
import java.util.Map;

import com.tek.interview.question.ooad.util.Utils;

/* ****************************************************************************************
 
Please remove all bugs from the code below to get the following output:

<pre>

*******Order 1*******
1 book: 13.74
1 music CD: 16.49
1 chocolate bar: 0.94
Sales Tax: 2.84
Total: 28.33
*******Order 2*******
1 imported box of chocolate: 11.5
1 imported bottle of perfume: 54.62
Sales Tax: 8.62
Total: 57.5
*******Order 3*******
1 Imported bottle of perfume: 32.19
1 bottle of perfume: 20.89
1 packet of headache pills: 10.73
1 box of imported chocolates: 12.94
Sales Tax: 8.77
Total: 67.98
Sum of orders: 153.81
 
</pre>
 
******************************************************************************************** */



public class OrderManager {

	/**
	 * receives a collection of orders. For each order, iterates on the order lines and calculate the total price which
	 * is the item's price * quantity * taxes.
	 * 
	 * For each order, print the total Sales Tax paid and Total price without taxes for this order
	 */
	public void orderSum(Map<String, Order> o) {

		double grandTotal = 0;

		// Iterate through the orders
		for (Map.Entry<String, Order> entry : o.entrySet()) {

			Order order = entry.getValue();

			grandTotal += order.printOrderAndGetTotal();
		}

		System.out.println("Sum of orders: " + Utils.rounding(grandTotal));
	}

	
	
	
	
	public static void main(String[] args) throws Exception {

		Map<String, Order> o = new HashMap<String, Order>();

		Order c1 = new Order("Order 1");
		Order c2 = new Order("Order 2");
		Order c3 = new Order("Order 3");
		
		double grandTotal = 0;

		c1.add(new LineOrder(new Item("book", (float) 12.49), 2));
		c1.add(new LineOrder(new Item("music CD", (float) 14.99), 1));
		c1.add(new LineOrder(new Item("chocolate bar", (float) 0.85), 1));

		o.put("Order 1", c1);

		// Reuse cart for an other order
//		c.clear();

		c2.add(new LineOrder(new Item("imported box of chocolate", 10), 1));
		c2.add(new LineOrder(new Item("imported bottle of perfume", (float) 47.50), 1));

		o.put("Order 2", c2);

		// Reuse cart for an other order
//		c.clear();

		c3.add(new LineOrder(new Item("Imported bottle of perfume", (float) 27.99), 1));
		c3.add(new LineOrder(new Item("bottle of perfume", (float) 18.99), 1));
		c3.add(new LineOrder(new Item("packet of headache pills", (float) 9.75), 1));
		//fixed the spelling of imported
		c3.add(new LineOrder(new Item("box of imported chocolates", (float) 11.25), 1));

		o.put("Order 3", c3);
		
		new OrderManager().orderSum(o);

	}
}
