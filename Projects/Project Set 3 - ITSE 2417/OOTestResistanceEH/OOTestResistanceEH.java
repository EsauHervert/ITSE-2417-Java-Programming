//Esau Hervert
//ITSE 2417
//Project 3 - Problem 2
//References/Option: http://stackoverflow.com/questions/4025780/displaying-%C2%B1-symbol-in-java
//This was used for the ± sign.

import java.util.Scanner; // For the scanner.

public class OOTestResistanceEH {

	public static void main(String[] args) {
		
		//***************************************************************************************************************************************
		//Initialize the inputs.
		String C1 = " ", C2 = " ", C3 = " ", C4 = " ";
		//***************************************************************************************************************************************
		
		//***************************************************************************************************************************************
		//Create a scanner.
		Scanner scan = new Scanner(System.in);
		//***************************************************************************************************************************************
		
		//***************************************************************************************************************************************
		//Ask the user for the colors.
		System.out.println("This Program will calculate the Resistance of a Resistor.");
		
		System.out.print("\nEnter the first color: ");
		C1 = scan.nextLine();
		
		System.out.print("Enter the second color: ");
		C2 = scan.nextLine();

		System.out.print("Enter the third color: ");
		C3 = scan.nextLine();
		
		System.out.print("Enter the fourth color."
				+ "\nIf there is no fourth color, enter \"None\": ");
		C4 = scan.nextLine();
		//***************************************************************************************************************************************

		System.out.println();
		
		//***************************************************************************************************************************************
		//Create the Resistor.
		Resistor T = new Resistor();
		
		//Set the colors.
		T.setColor1(C1);
		T.setColor2(C2);
		T.setColor3(C3);
		if (C4 != "None")
		{
			T.setColor4(C4);
		}
		//***************************************************************************************************************************************

		//***************************************************************************************************************************************
		//Print out the Properties.
		System.out.println("The Resistance is: " + T.getResistance() + " Ohms.");
		System.out.println(T.getInformation());
		//***************************************************************************************************************************************

		//Close the scanner.
		scan.close();
	}
}
