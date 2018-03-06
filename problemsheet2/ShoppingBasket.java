package uk.ac.sheffield.com1003.problemsheet2;

public class ShoppingBasket {

	public static void main(String[] args) {
		Item[] shopping = { 
			new Item("baked beans",0.3),
			new ItemByWeight("bananas",0.4,0.7),
			new ItemByWeight("bananas",0.4,0.7)
		};
		
		//Make new object to run the totalPrice method for shopping
		Basket basketObject = new Basket(shopping);
		System.out.print("The total price is: ukp");
		System.out.println(basketObject.totalPrice(shopping));
		
		//Outputs the instance variables using the toString() method
		for (int i=0; i<shopping.length; i++) {
			System.out.println(shopping[i].toString());
			//Checks if two objects are equal
		}
		//For every object in the list
		for (int i=0; i<shopping.length; i++) {
			for (int j=i+1; j<shopping.length; j++) {
			//Item other = (Item)shopping[i];
			//Item other2 = (Item)shopping[j];
				if (shopping[j].equals(shopping[i])) {
					System.out.println(shopping[i].getName() + " is equal to " + shopping[i].getName());
				}
			}
		}
		
	}
}