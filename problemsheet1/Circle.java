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
	
	final double PI = 3.142;
	
	public double getArea(){
		double area = (radius)*(radius)*PI;
		return area;
	}
	public double getCircumference(){
		double circumference = 2*(radius)*PI;
		return circumference;
	}
	public double getRadius(){
		return radius;
	}
	public void setPosition( double newX, double newY ){
		xPosition = (int)newX;
		yPosition = (int)newY;
	}	
	public void setRadius( double newRadius ){
		radius = newRadius;
	}
	
	
	
	// instance variables
	private double radius;
	private int xPosition;
	private int yPosition;
}
