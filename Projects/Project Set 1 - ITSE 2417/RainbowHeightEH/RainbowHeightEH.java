// Author: Esau Hervert
// Course: ITSE 2417
// Project 1 Problem 1
// References/Option: None

package ITSE2417;

//These are the Libraries that will be used.

//This Library allows for a scanner to be made allowing user input.
import java.util.Scanner;
//This Library is where the tan(x) method is at.
import java.lang.Math;

public class RainbowHeightEH {
	public static void main(String[] args) {

		//This is where all the variables and constants will be initialized.
		final double Pi = 3.14159265359;
		double theta = 42.333333, radians = 0, Height = 0, PersonHeight = 0, InchesDecimal = 0;
		radians = theta * (Pi / 180);
		String Person = "Student";
		
		//This is where the purpose of the program is displayed.
		System.out.println("This program will calculate the apparent height of a Rainbow given the " +"\nfollowing parameters:");
		System.out.println("	the height of the observer (feet)," + "\n	the distance from the Rainbow (feet).");

		//This is where the name of the user is asked and inputted.
		System.out.print("\nPlease enter your name.\nName: ");
		Scanner input0 = new Scanner(System.in);
		String Person0 = input0.nextLine();

		//The name is stored here.
		Person = Person0;

		//This is where the height of the user is asked.
		System.out.println("\nEnter your Height x'y\" to feet: x [Enter], inches: y [Enter].");

		//This is where we take in the height of the user.
		System.out.print("Feet: ");
		Scanner input1 = new Scanner(System.in);
		double Feet = input1.nextDouble();

		System.out.print("Inches: ");
		Scanner input2 = new Scanner(System.in);
		double Inches = input2.nextDouble();

		//This is where the inches will be converted to a decimal value.
		InchesDecimal = Inches / 12;

		//The height of the person is calculated here.
		PersonHeight = Feet + InchesDecimal;

		//This is where the height is outputted.
		System.out.print(Person + "'s height is ");
		System.out.printf("%.1f",Feet);
		System.out.print(" feet ");
		System.out.printf("%.1f",Inches);
		System.out.print(" inches.");

		//This is where the distance from the Rainbow is taken in.
		System.out.print("\n\nPlease enter your distance from the Rainbow: ");
		Scanner input3 = new Scanner(System.in);
		double Distance = input3.nextDouble();

		//The information is displayed to the user.
		System.out.print(Person + "'s Distance from the Rainbow is: ");
		System.out.printf("%.4f",Distance);

		//The height of the Rainbow is calculated here.
		Height = (Distance * Math.tan(radians)) + PersonHeight;
		System.out.print("\n\nThe Height of the Rainbow is: ");
		System.out.printf("%.4f",Height);
		
		//This terminates the program.
		System.out.print("\n\nEnter any numeric value to end this program: ");
		Scanner inputn = new Scanner(System.in);
		double e = inputn.nextDouble();
	}
}