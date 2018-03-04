package uk.ac.sheffield.com1003.problemsheet2;

/** ItemByWeight.java
*
* Subclass of Item, where price is specified by unit weight
*
*/

public class ItemByWeight extends Item {
	public ItemByWeight(String n, double p, double w) {
		super(n, p);
		weight = w;
		}
		
	public double getPrice() {
		return weight*super.getPrice();
		}
		
	public String toString() {
		return (getName() + " (" + weight + "kg @ "
		+ super.getPrice() + "ukp/kg) = ukp"
		+ getPrice());
		}
	
	public boolean equals(Object obj) {
		if (!super.equals(obj)) 
			return false;
		else {
			ItemByWeight other = (ItemByWeight) obj;
			return weight == other.weight;
		}
	}

	
	// instance field
	private double weight;
}

