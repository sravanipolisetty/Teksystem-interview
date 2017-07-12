package com.tek.interview.question.ooad;


/*
 * represents an order line which contains the @link Item and the quantity.
 *
 */
public class LineOrder {

	private int quantity;
	private Item item;

	/*
	 * @param item Item of the order
	 * 
	 * @param quantity Quantity of the item
	 */
	public LineOrder(Item item, int quantity) throws Exception {
		if (item == null) {
			System.err.println("ERROR - Item is NULL");
			throw new Exception("Item is NULL");
		}
		assert quantity > 0;
		//fixing the assignment, we need to put 'this' keyword to inform jvm that we are assigning the value to classlevel variable, not the method level variable
		this.item = item;
		this.quantity = quantity;
	}

	public Item getItem() {
		return item;
	}

	public int getQuantity() {
		return quantity;
	}
}
