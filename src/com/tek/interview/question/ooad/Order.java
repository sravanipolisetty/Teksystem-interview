package com.tek.interview.question.ooad;

import java.util.ArrayList;
import java.util.List;

import com.tek.interview.question.ooad.util.Utils;

public class Order {

	private String orderName;

	//initialializing the LineOrders as this is not done anywhere and was resulting in nullPointer exception
	private List<LineOrder> lineOrders = new ArrayList<LineOrder>();
	
	public Order(String name) {
		this.orderName = name;
	}
	public String getOrderName() {
		return orderName;
	}

	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}

	public List<LineOrder> getLineOrders() {
		return lineOrders;
	}

	public void setLineOrders(List<LineOrder> lineOrders) {
		lineOrders = lineOrders;
	}


	public void add(LineOrder o) throws Exception {
		if (o == null) {
			System.err.println("ERROR - Order is NULL");
			throw new IllegalArgumentException("Order is NULL");
		}
		lineOrders.add(o);
	}

	

	public void clear() {
		this.lineOrders.clear();
	}
	

	public double printOrderAndGetTotal(){
		
		// Iterate through the items in the order
		System.out.println("*******" + getOrderName() + "*******");
		double totalTax =0;
		double total = 0;
		for (LineOrder lineOrder : lineOrders) {
			
		
			// Calculate the taxes
			double tax = lineOrder.getItem().getTaxValue(lineOrder.getQuantity()); // Extra 5% tax on

			// Calculate the total price
			double totalprice = (lineOrder.getItem().getPrice() * lineOrder.getQuantity()) + tax;

			lineOrder.getItem().printItem(lineOrder.getQuantity());

			totalTax += tax;
			total += lineOrder.getItem().getPrice() * lineOrder.getQuantity();

		}
		System.out.println("Sales Tax: " + Utils.rounding(totalTax));
		System.out.println("Total: " + Utils.rounding(total));
		return Utils.rounding(total);
	}

	@Override
	public String toString() {
		return "Order [orderName=" + orderName + ", LineOrders=" + lineOrders + ", toString()=" + super.toString()
				+ "]";
	}
	
	
}
