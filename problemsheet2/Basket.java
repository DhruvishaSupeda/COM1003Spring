package uk.ac.sheffield.com1003.problemsheet2;

/**
 * Basket.java
 *
 * Model of a shopping basket containing items of shopping
 *
 */

public class Basket {
	public Basket(Item[] it) {
		items = it;
	}

	/**
	 * Outputs the total price of everything in the array of items
	 * 
	 * @param shopping
	 *            shopping basket currently initialised
	 * @return total price of everything in the array
	 */
	public double totalPrice(Item[] shopping) {
		double tot = 0.0;
		// you need to write some code here that calculates
		// the total price of items stored in the Basket

		// Goes through the array one item at a time and adds up the costs
		for (int i = 0; i < shopping.length; i++) {
			tot = tot + shopping[i].getPrice();
		}

		// Rounds the total to 2dp
		tot = Math.round(tot * 100);
		tot = tot / 100;
		return tot;
	}

	private Item[] items;
}
