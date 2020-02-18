// Esau Hervert
// ITSE 2417
// Project 5, Program 2.
// Options/References: None.

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class WrestlingEH {
	public static void main(String[] args) {
		
		String dir; // Holds the address.
		int max = 0; // maximum number of games.
		
		// Taking in the location of the file.
		System.out.print("\nFile name: ");
		
		Scanner d = new Scanner(System.in);
		dir = d.nextLine();
		
		// Close the input scanner.
		d.close();

		// This change will allow java to actually find the correct location since having "\" causes issues.
		dir.replace("\\", "/");
		
		// This will make sure that the file is found. If not, it will lead to a IOException.
		try{
			Scanner input = new Scanner(new File(dir));
			
			max = Character.getNumericValue(input.nextLine().charAt(0)); // Number of Games.
			
			System.out.println();
	
			// Displays the games by reading every two lines.
			for (int i = 0; i < max; i++)
			{
				Wresling G1 = new Wresling(input.nextLine(), input.nextLine(), i);
				
				G1.getGame();
				
				System.out.println();
			}
	
			input.close(); // Close the scanner.
		}
		catch (IOException e)
		{
			System.out.println("File is not Found."); // In case of error.
		}
	}
}

class Wresling {
	
	// All the values that will be used for the game.
	private int match = 0;
	private int R11 = 0, R12 = 0, R21 = 0, R22 = 0, RC = 0, RL = 0;
	private int B11 = 0, B12 = 0, B21 = 0, B22 = 0, BC = 0, BL = 0;

	public Wresling(String Red, String Blue, int m) {
		match = m + 1;
		
		//*****************************************************************************************
		// Red Player:
		int i = 6;
		R11 = Character.getNumericValue(Red.charAt(i));
		
		if (Character.isWhitespace(Red.charAt(i + 1)) && !Character.isWhitespace(Red.charAt(i + 2)))
		{
			R12 = Character.getNumericValue(Red.charAt(i + 2));
			i += 2;
		}
		
		i += 3;
		
		R21 = Character.getNumericValue(Red.charAt(i));

		if (Character.isWhitespace(Red.charAt(i + 1)) && !Character.isWhitespace(Red.charAt(i + 2)))
		{
			R22 = Character.getNumericValue(Red.charAt(i + 2));
			i += 2; 
		}
		
		i += 3;

		RC = Character.getNumericValue(Red.charAt(i));
		
		i += 3;
		
		if (Red.charAt(i) == 'X')
			RL = 1;
		//*****************************************************************************************

		//*****************************************************************************************
		// Blue Player:
		i = 6;
		B11 = Character.getNumericValue(Blue.charAt(i));
				
		if (Character.isWhitespace(Blue.charAt(i + 1)) && !Character.isWhitespace(Blue.charAt(i + 2)))
		{
			B12 = Character.getNumericValue(Blue.charAt(i + 2));
			i += 2;
		}
				
		i += 3;
				
		B21 = Character.getNumericValue(Blue.charAt(i));

		if (Character.isWhitespace(Blue.charAt(i + 1)) && !Character.isWhitespace(Blue.charAt(i + 2)))
		{
			B22 = Character.getNumericValue(Blue.charAt(i + 2));
			i += 2; 
		}
				
		i += 3;

		BC = Character.getNumericValue(Blue.charAt(i));
				
		i += 3;
				
		if (Blue.charAt(i) == 'X')
			BL = 1;
		//*****************************************************************************************
		}
	
	public void winner(int R11, int R12, int R21, int R22, int RC, int RL, int B11, int B12, int B21, int B22, int BC, int BL)
	{
		//*****************************************************************************************
		// Values in the game
		int TR = R11 + R12 + R21 + R22;
		int R1 = R11 + R12;
		int R2 = R21 + R22;
		
		int TB = B11 + B12 + B21 + B22;
		int B1 = B11 + B12;
		int B2 = B21 + B22;
		//*****************************************************************************************
		
		//*****************************************************************************************
		// Finding the highest value.
		int[] Red = {R11, R12, R21, R22};
		int[] Blue = {B11, B12, B21, B22};
		
		int HR = 0, HB = 0;
		
		for (int i = 0; i < 4; i++) // For loop that finds the highest values.
		{
			if (Red[i] > HR)
				HR = Red[i];
			if (Blue[i] > HB)
				HB = Blue[i];
		}
		//*****************************************************************************************

		//*****************************************************************************************
		// Conditions for the game.
		if (R1 == 10 || R2 == 10){
			if (TB == 0)
			{
				System.out.println("Red Winner- Technical Points: " + TR + "-" + TB);
				System.out.println("             Classification Points: ST 4:0");
			}
			else
			{
				System.out.println("Red Winner- Technical Points: " + TR + "-" + TB);
				System.out.println("             Classification Points: SP 4:1");
			}
		}
		else if (B1 == 10 || B2 == 10){
			if (TR == 0)
			{
				System.out.println("Blue Winner- Technical Points: " + TB + "-" + TR);
				System.out.println("             Classification Points: ST 4:0");
			}
			else
			{
				System.out.println("Blue Winner- Technical Points: " + TB + "-" + TR);
				System.out.println("             Classification Points: SP 4:1");
			}
		}
		else if (TR > TB && TB == 0)
		{
			System.out.println("Red Winner- Technical Points: " + TR + "-" + TB);
			System.out.println("             Classification Points: PO 3:0");
		}
		else if (TB > TR && TR == 0)
		{
			System.out.println("Blue Winner- Technical Points: " + TB + "-" + TR);
			System.out.println("             Classification Points: PO 3:0");
		}
		else if ( TR > TB && TR != 0)
		{
			System.out.println("Red Winner- Technical Points: " + TR + "-" + TB);
			System.out.println("             Classification Points: PP 3:1");
		}
		else if (TB > TR && TR != 0)
		{
			System.out.println("Blue Winner- Technical Points: " + TB + "-" + TR);
			System.out.println("             Classification Points: PP 3:1");
		}
		else if (TB == TR)
		{
			if (HB > HR)
			{
				System.out.println("Blue Winner- Technical Points: " + TB + "-" + TR);
				System.out.println("             Classification Points: PP 3:1");
			}
			else if (HR > HB)
			{
				System.out.println("Red Winner- Technical Points: " + TR + "-" + TB);
				System.out.println("             Classification Points: PP 3:1");
			}
			else if (HR == HB)
			{
				if (BL == 1)
				{
					System.out.println("Blue Winner- Technical Points: " + TB + "-" + TR);
					System.out.println("             Classification Points: PP 3:1");
				}
				else if (RL == 1)
				{
					System.out.println("Red Winner- Technical Points: " + TB + "-" + TR);
					System.out.println("             Classification Points: PP 3:1");
				}
			}
		}
	}
	
	// Display the game information.
	public void getGame() {

		System.out.println("Match " + match);
		winner(R11, R12, R21, R22, RC, RL, B11, B12, B21, B22, BC, BL);

	}
}