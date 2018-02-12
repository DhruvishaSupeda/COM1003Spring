/*
 * Circle.java  	1.1 30/01/2018
 * 
 * This is a template for problem sheet 1
 *
 * Copyright (c) University of Sheffield 2018
 */

/** 
* TryArrayList.java
* 
* 
* @version 1.1 30/01/2018
* 
* @author Richard Clayton
*/

package uk.ac.sheffield.com1003.problemsheet1;

public class Circle {
	// constructor
	public Circle( double r, int x, int y ){
		radius = r;
		xPosition = x;
		yPosition = y;
	}
	
	// methods -- you should remove the comments, and complete the method bodies
	
	//Constant used for the value of Pi when working out the area and circumference
	final double PI = 3.142;
	
	/**
	 * Calculates and returns the area of the circle it is called for
	 * @return the area of the object
	 */
	public double getArea(){
		double area = (Math.pow(radius, 2))*PI;
		return area;
	}
	
	/**
	 * Calculates and returns the circumference of the circle it is called for 
	 * @return the circumference of the circle
	 */
	public double getCircumference(){
		double circumference = 2*(radius)*PI;
		return circumference;
	}
	
	/**
	 * Returns the radius of the circle
	 * @return the radius of the circle
	 */
	public double getRadius(){
		return radius;
	}
	
	/**
	 * Sets the x and y coordinates of the circle
	 * @param newX	The new x value to be given to the circle
	 * @param newY	The new y value to be given to the circle
	 */
	public void setPosition( double newX, double newY ){
		xPosition = (int)newX;
		yPosition = (int)newY;
	}	
	
	/**
	 * Sets a new radius for the circle
	 * @param newRadius	The new radius to be given to the circle
	 */
	public void setRadius( double newRadius ){
		radius = newRadius;
	}
	
	// instance variables
	private double radius;
	private int xPosition;
	private int yPosition;
}
