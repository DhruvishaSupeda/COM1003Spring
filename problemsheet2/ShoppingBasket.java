package uk.ac.sheffield.com1003.problemsheet2;

/** ShoppingBasket.java
*
* Subclass of Item, where price is specified by unit weight
*
*/
public class ShoppingBasket {
	public static void outputObject (Item[] shopping) {
		for (int i=0; i<shopping.length; i++) {
			System.out.println(shopping[i].getName());
			System.out.println(shopping[i].getPrice());
		}
	}
		
	public static void outputTotal(Item[] shopping) {
		Basket basketObject = new Basket(shopping);
		System.out.print("The total price is: ");
		System.out.println(basketObject.totalPrice(shopping));
	}
	
	public static void main(String[] args) {
		Item[] shopping = { 
				 new Item("baked beans",0.3),
				 new ItemByWeight("bananas",0.4,0.7)
		};
		outputObject(shopping);
		outputTotal(shopping);
	}	

}