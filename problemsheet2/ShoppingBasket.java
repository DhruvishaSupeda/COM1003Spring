package uk.ac.sheffield.com1003.problemsheet2;

/** ShoppingBasket.java
*
* Outputs the total price of all the items in the basket
* Outputs the object names and prices
* Checks if any two items in the basket are the same
*
*/
public class ShoppingBasket {
	
	/**
	 * Uses the toString() method to output the contents if the basket array
	 * @param shopping shopping basket currently initialised
	 */
	public static void outputObject (Item[] shopping) {
		//Outputs the instance variables using the toString() method
		for (int i=0; i<shopping.length; i++) {
			System.out.println(shopping[i].toString());
		}
	}
	
	/**
	 * Checks the array to output any items that are the same
	 * @param shopping shopping basket currently initialised
	 */
	public static void checkSame(Item[] shopping) {
		//Going through the array one item at a time
		for (int i=0; i<shopping.length; i++) {
			//Going through the array after the current item at i
			for (int j=i+1; j<shopping.length; j++) {
				//Checks if the two items are equal using the equals method
				if (shopping[j].equals(shopping[i])) {
					System.out.println(shopping[i].getName() + " is equal to " + shopping[i].getName());
				}
			}
		}
	}
	
	/**
	 * Outputs the total price of everything in the basket
	 * @param shopping shopping basket currently initialised
	 */
	public static void outputTotal(Item[] shopping) {
		Basket basketObject = new Basket(shopping);
		System.out.print("The total price is: ukp");
		System.out.println(basketObject.totalPrice(shopping));
	}
	
	public static void main(String[] args) {
		Item[] shopping = { 
				 new Item("Baked Beans",0.3),
				 new ItemByWeight("Bananas",0.4,0.7),
				 new Item("Baked Beans",0.3)
		};
		
		outputObject(shopping);
		outputTotal(shopping);
		checkSame(shopping);
	}	

}