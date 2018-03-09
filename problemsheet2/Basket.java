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
<<<<<<< HEAD

	/**
	 * Outputs the total price of everything in the array of items
	 * 
	 * @param shopping
	 *            shopping basket currently initialised
=======
	
	/**
	 * Outputs the total price of everything in the array of items
	 * @param shopping shopping basket currently initialised
>>>>>>> 03647f320c9a61776b8853e006fb03273776ac2b
	 * @return total price of everything in the array
	 */
	public double totalPrice(Item[] shopping) {
		double tot = 0.0;
		// you need to write some code here that calculates
		// the total price of items stored in the Basket
<<<<<<< HEAD

		// Goes through the array one item at a time and adds up the costs
		for (int i = 0; i < shopping.length; i++) {
			tot = tot + shopping[i].getPrice();
		}

		// Rounds the total to 2dp
		tot = Math.round(tot * 100);
		tot = tot / 100;
=======
		
		//Goes through the array one item at a time and adds up the costs
		for (int i=0; i< shopping.length; i++) {
			tot = tot + shopping[i].getPrice();
		}
		tot = Math.round(tot*100);
		tot = tot/100;
>>>>>>> 03647f320c9a61776b8853e006fb03273776ac2b
		return tot;
	}

	private Item[] items;
}
