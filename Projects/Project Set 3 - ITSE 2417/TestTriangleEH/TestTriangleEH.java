//Esau Hervert
//ITSE 2417
//Project 3 - Problem 1
//References/Option: Liang Introduction to Java.

import java.util.Scanner; // For the scanner.

public class TestTriangleEH {
	public static void main(String[] args) {
	
		//*********************************************************************************************************************************	
		//Initialize the values that we will get from the user.
		String c = "White";
		boolean fill = false;
		double s1 = 1, s2 = 1, s3 = 1;
		//*********************************************************************************************************************************	

		//*********************************************************************************************************************************	
		// Get the information from the user.
		
		//Create Scanner.
		Scanner sc = new Scanner(System.in);

		
		//Color.
		System.out.print("Enter the color of the triangle: ");
		c = sc.nextLine();
		
		//Fill.
		System.out.print("Is the triangle filled? (true/false): ");
		fill = sc.nextBoolean();

		//Side1.
		System.out.print("Length of side 1: ");
		s1 = sc.nextDouble();
		
		//Side2.
		System.out.print("Length of side 2: ");
		s2 = sc.nextDouble();
		
		//Side3.
		System.out.print("Length of side 3: ");
		s3 = sc.nextDouble();
		
		//Close Scanner.
		sc.close();
		//*********************************************************************************************************************************	

		//*********************************************************************************************************************************	
		//Create the Triangle with the parameters.
		Triangle T = new Triangle(s1, s2, s3);
		T.setColor(c);
		T.setFilled(fill);
		//*********************************************************************************************************************************	

		System.out.println();
		
		//*********************************************************************************************************************************	
		//Display the information to the user.
		
		System.out.println("The following Triangle was created.");
		System.out.println(T.toString());
		System.out.println("The Area is: " + T.getArea());
		System.out.println("The Perimeter is: " + T.getPerimeter());
		//*********************************************************************************************************************************	
	
	}
}
