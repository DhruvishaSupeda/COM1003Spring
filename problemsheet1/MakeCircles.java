package uk.ac.sheffield.com1003.problemsheet1;
import uk.ac.sheffield.com1003.*;

/**
 * @author Dhruvisha Supeda 
 */
public class MakeCircles{
	
	/**
	 * Finds the area and circumference of both circles
	 * Prints the area and circumference onto the console
	 * @param firstCircle	The object for the first circle
	 * @param secondCircle	The object for the second circle
	 */
	public static void outputValues(Circle firstCircle, Circle secondCircle) {
		double area, circumference;
		area = firstCircle.getArea();
		System.out.println("The area of firstCircle is " + area);
		circumference = firstCircle.getCircumference();
		System.out.println("The circumference of firstCircle is " + circumference);
		area = secondCircle.getArea();
		System.out.println("The area of secondCircle is " + area);
		circumference = secondCircle.getCircumference();
		System.out.println("The circumference of secondCircle is " + circumference);
	}
	
	/**
	 * Main method
	 * Instantiates the circle objects and the canvas
	 * Outputs the values of the area and circumference using outputValues method before and after modifications
	 * Modifies the radii of both circles
	 * Draws the modified circles on the canvas
	 * @param args
	 */
	public static void main(String[] args) {
		//Constants to store the canvas width and height
		final int CANVAS_WIDTH = 300;
		final int CANVAS_HEIGHT = 300;
		
		//Instantiating the two circle objects
		Circle firstCircle = new Circle(20,20,20);
		Circle secondCircle = new Circle(40,40,40);
		
		//Initialising the canvas
		EasyGraphics g = new EasyGraphics(CANVAS_WIDTH,CANVAS_HEIGHT);
		
		//Outputs the values of the area and circumference of both circles
		System.out.println("Values for initial circles:");
		outputValues(firstCircle, secondCircle);
		
		//Sets new radii for both circles
		firstCircle.setRadius(60);
		secondCircle.setRadius(100);

		//Outputs the new values of the area and circumference of both circles
		System.out.println();
		System.out.println("Values for edited circles:");
		outputValues(firstCircle, secondCircle);		
		
		//Draws both new circles on the canvas
		int newRadius = (int)firstCircle.getRadius();
		g.setColor(204, 153, 255);
		g.drawEllipse(20,20,newRadius*2,newRadius*2);
		newRadius = (int)secondCircle.getRadius();
		g.setColor(0,0,0);
		g.drawEllipse(60,60,newRadius*2,newRadius*2);
	}
	
	
}