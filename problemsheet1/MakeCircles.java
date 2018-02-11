package uk.ac.sheffield.com1003.problemsheet1;
import sheffield.*;



public class MakeCircles{
	
	public static void areaAndCircumference(Circle firstCircle, Circle secondCircle) {
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
	
	public static void main(String[] args) {
		//Constants to store the canvas width and height
		final int CANVAS_WIDTH = 300;
		final int CANVAS_HEIGHT = 300;
		
		//Instantiating the two circle objects
		Circle firstCircle = new Circle(20,20,20);
		Circle secondCircle = new Circle(40,40,40);
		
		EasyGraphics g = new EasyGraphics(CANVAS_WIDTH,CANVAS_HEIGHT);
		
		System.out.println("Values for initial circles:");
		areaAndCircumference(firstCircle, secondCircle);
		
		firstCircle.setRadius(60);
		secondCircle.setRadius(100);

		System.out.println("Values for edited circles:");
		areaAndCircumference(firstCircle, secondCircle);		
		
		int newRadius = (int)firstCircle.getRadius();
		g.setColor(204, 153, 255);
		g.drawEllipse(20,20,newRadius*2,newRadius*2);
		newRadius = (int)secondCircle.getRadius();
		g.setColor(0,0,0);
		g.drawEllipse(60,60,newRadius*2,newRadius*2);
	}
	
	
}