package uk.ac.sheffield.com1003.problemsheet2;

public class TestItemEquals{
	public static void main(String[] args) {
		//shopping.equals(shopping2);
		Item item1 = new Item("baked beans",0.3);
		Item item2 = new ItemByWeight("bananas",0.4,0.7);
		Item item3 = new Item("baked beans",0.3);
		
		boolean passCase = item1.equals(item2);
		System.out.println("1vs2: " + passCase);
		
		passCase = item2.equals(item2);
		System.out.println("2vs2: " + passCase);
		
		passCase = item3.equals(item1);
		System.out.println("3vs1: " + passCase);
		
	}
}