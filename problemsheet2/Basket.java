package uk.ac.sheffield.com1003.problemsheet2;

/** Basket.java
*
* Model of a shopping basket containing items of shopping
*
*/

public class Basket {
	public Basket(Item[] it) {
		items = it;
		}
	public double totalPrice(Item[] shopping) {
		double tot = 0.0;
		// you need to write some code here that calculates
		// the total price of items stored in the Basket
		
		for (int i=0; i< shopping.length; i++) {
			tot = tot + shopping[i].getPrice();
		}
		
		
		return tot;
		}
		
	private Item[] items;
}
