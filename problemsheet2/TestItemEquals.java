package uk.ac.sheffield.com1003.problemsheet2;

public class TestItemEquals{
	public static void main(String[] args) {
		//Making three objects to do the tests
		Item item1 = new Item("baked beans",0.3);
		Item item2 = new ItemByWeight("bananas",0.4,0.7);
		Item item3 = new Item("baked beans",0.3);
		
		//Tests the first and second objects to see if they are equal
		boolean passCase = item1.equals(item2);
		System.out.println("Baked Beans and Bananas: " + passCase);
		
		//Compares the second object against himself to see if it returns true
		passCase = item2.equals(item2);
		System.out.println("Bananas and Bananas: " + passCase);
		
		//Compares the first and third objects to see if they are equal
		passCase = item3.equals(item1);
		System.out.println("Baked Beans and Baked Beans: " + passCase);
		
	}
}