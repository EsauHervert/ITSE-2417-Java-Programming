import java.lang.Math; //Math.pow().

public class Triangle extends GeometricObject {
	
	//Sides of my triangle.
	private double side1 = 1;
	private double side2 = 1;
	private double side3 = 1;
	
	//The no-arg constructor for the triangle object.
	public Triangle() {
	}
	
	//The triangle object with the three sides.
	public Triangle(double side1, double side2, double side3) {
		this.side1 = side1;
		this.side2 = side2;
		this.side3 = side3;
	}
	
	//***************************************************************************************************************************************
	//Accessor Methods.
	
	// Get side1.
	public double getSide1() {
		return side1;
	}
	
	//Set side1.
	public void setSide1(double side1) {
		this.side1 = side1;
	}
	
	// Get side2.
	public double getSide2() {
		return side2;
	}
	
	//Set side2.
	public void setSide2(double side2) {
		this.side2 = side2;
	}
	// Get side3.
	public double getSide3() {
		return side3;
	}
	
	//Set side3.
	public void setSide3(double side3) {
		this.side3 = side3;
	}
	//***************************************************************************************************************************************

	//***************************************************************************************************************************************
	//Method to get the Area.
	public double getArea() {
		double s = (side1 + side2 + side3) / 2;
		double Inside = s * (s - side1) * (s - side2) * (s - side3);
		double Area = Math.pow(Inside, .5);
		
		return Area;
	}
	//***************************************************************************************************************************************

	//***************************************************************************************************************************************
	//Method to get Perimeter.
	public double getPerimeter() {
		return (side1 + side2 + side3);
	}
	//***************************************************************************************************************************************
	
	//***************************************************************************************************************************************
	//Method to get information on the object.
	//Note that I added more to this method so that it would display more information.
	public String toString() {
		return "Triangle: side 1 = " + side1 + ", side 2 = " + side2 +
				", side 3 = " + side3;
	}
	//***************************************************************************************************************************************


}
