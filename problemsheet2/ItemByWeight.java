package uk.ac.sheffield.com1003.problemsheet2;

/**
 * ItemByWeight.java
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
		return weight * super.getPrice();
	}

	public String toString() {
		return (getName() + " (" + weight + "kg @ " + super.getPrice() + "ukp/kg) = ukp" + getPrice());
	}

	/**
	 * Checks if two objects are equal using the equals method from the superclass
	 * and checking the weights
	 */
	public boolean equals(Object otherObject) {
		// Uses the superclass equals method
		if (!super.equals(otherObject))
			return false;
		else {
			// Checks the weight of the objects if name and price are the same
			ItemByWeight other = (ItemByWeight) otherObject;
			return weight == other.weight;
		}
	}

	// instance field
	private double weight;
}
