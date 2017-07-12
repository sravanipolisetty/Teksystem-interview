package com.tek.interview.question.ooad;

import com.tek.interview.question.ooad.util.Constants;
import com.tek.interview.question.ooad.util.Utils;

/*
 * represents an item, contains a price and a description.
 *
 */

public class Item {

	private String description;
	private float price;

	public Item(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

	public void printItem(int qty){
		System.out.println(getDescription() + ": " + Utils.rounding((getPrice() * qty ) + getTaxValue(qty)));
	}
	public String getDescription() {
		return description;
	}

	public float getPrice() {
		return price;
	}
	
	public double getTaxValue(int qty){
		if (getDescription().toLowerCase().contains(Constants.IMPORTED_TEXT)) {
			return Utils.rounding(getPrice() * qty * Constants.IMPORTED_ITEM_TAX); 
			// imported items
		} else {
			return Utils.rounding(getPrice() * qty * Constants.DOMESTIC_ITEM_TAX);
		}
	}
}

