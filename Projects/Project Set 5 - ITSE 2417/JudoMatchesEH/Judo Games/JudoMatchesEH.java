// Esau Hervert
// ITSE 2417
// Project 5, Program 1.
// Options/References: None.

import java.io.File; // To read the file.
import java.io.IOException; // In case there is an error.
import java.util.Scanner; // To scan things.

public class JudoMatchesEH {
	
	public static void main(String[] args)
	{
		String dir; // Holds the address.
		int max = 0; // maximum number of games.
		
		//Taking in the location of the file.
		System.out.print("\nEnter the file directory: ");
		
		Scanner d = new Scanner(System.in);
		dir = d.nextLine();
		
		//Close the input scanner.
		d.close();

		//This change will allow java to actually find the correct location since having "\" causes issues.
		dir.replace("\\", "/");
		
		//This will make sure that the file is found. If not, it will lead to a IOException.
		try{
			Scanner input = new Scanner(new File(dir));
			
			max = Character.getNumericValue(input.nextLine().charAt(0)); // Number of Games.
			
			System.out.println();
	
			// Displays the games by reading every two lines.
			for (int i = 0; i < max; i++)
			{
				Game G1 = new Game(input.nextLine(), input.nextLine(), i);
				
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

class Game{
	
	// All the variables that are going to be initialized.
	private int match;
	private int IB, WB, YB, PB;
	private int IW, WW, YW, PW;
	private int Bone = 0, Btwo = 0, Bthree = 0, Bfour = 0;
	private int Wone, Wtwo, Wthree, Wfour;
	private boolean B1 = true, B2 = true, B3 = true, B4 = true;
	private boolean W1 = true, W2 = true, W3 = true, W4 = true;
	
	// The constructor and its parameters.
	public Game(String S1, String S2, int m)
	{
		match = m + 1; // Index the game.
		
		//*****************************************************************************************
		// These loops will find the white spaces and use that to find our inputs.
		
		// Blue.
		for (int i = 0; i < S1.length(); i++)													 
		{																						 
			if (Character.isWhitespace(S1.charAt(i)) && B1)										
				{																				 
				Bone = i;
				B1 = false;
				}
			else if (Character.isWhitespace(S1.charAt(i)) && B2)
				{
				Btwo = i;
				B2 = false;
				}
			else if (Character.isWhitespace(S1.charAt(i)) && B3)
				{
				Bthree = i;
				B3 = false;
				}
			else if (Character.isWhitespace(S1.charAt(i)) && B4)
				{
				Bfour = i;
				B4 = false;
				}
			} 
		
		//White.
		for (int i = 0; i < S2.length(); i++)
			{
				if (Character.isWhitespace(S2.charAt(i)) && W1)
					{
					Wone = i;
					W1 = false;
					}
				else if (Character.isWhitespace(S2.charAt(i)) && W2)
					{
					Wtwo = i;
					W2 = false;
					}
				else if (Character.isWhitespace(S2.charAt(i)) && W3)
					{
					Wthree = i;
					W3 = false;
					}
				else if (Character.isWhitespace(S2.charAt(i)) && W4)
					{
					Wfour = i;
					W4 = false;
					}
			}
		//*****************************************************************************************

		//*****************************************************************************************
		// Assign a value to the individual fields.
		IB = Character.getNumericValue(S1.charAt(Bone + 1));
		WB = Character.getNumericValue(S1.charAt(Btwo + 1));
		YB = Character.getNumericValue(S1.charAt(Bthree + 1));
		if (S1.charAt(Bfour + 1) == '-')
			PB = -1;
		else
			PB = Character.getNumericValue(S1.charAt(Bfour + 1));
			
		IW = Character.getNumericValue(S2.charAt(Wone + 1));
		WW = Character.getNumericValue(S2.charAt(Wtwo + 1));
		YW = Character.getNumericValue(S2.charAt(Wthree + 1));
		if (S2.charAt(Bfour + 1) == '-')
			PW = -1;
		else
			PW = Character.getNumericValue(S2.charAt(Wfour + 1));
		//*****************************************************************************************

		//*****************************************************************************************
		// For the special cases where a certain amount of something will trigger something else. 
		if (WB == 2)
		{
			IB = 1;
			WB = 0;
		}
		
		if (WW == 2)
		{
			IW = 1;
			WW = 0;
		}
		
		if (PB == -1 || PB == 4)
		{
			IW = 1;
		}
		
		if (PW == -1 || PW == 4)
		{
			IB = 1;
		}
		//*****************************************************************************************
		
	}
	
	//*****************************************************************************************
	// Determines the winner of the game.
	public void Winner(int IB, int WB, int YB, int PB, int IW, int WW, int YW, int PW)
	{
		if (PB == -1 || PB == 4)
			System.out.println("White winner by Ippon");
		if (PW == -1 || PW == 4)
			System.out.println("Blue winner by Ippon");
		else if (IB == 1)
			System.out.println("Blue winner by Ippon");
		else if (IW == 1)
			System.out.println("White winner by Ippon");
		else if (WB > WW)
			System.out.println("Blue winner by Waza-ari");
		else if (WW > WB)
			System.out.println("White winner by Waza-ari");
		else if (WB == WW)
		{
			if (YB > YW)
				System.out.println("Blue winner by Yuko");
			else if (YW > YB)
				System.out.println("White winner by Yuko");
		}
		else
			System.out.println("error");
	}
	//*****************************************************************************************

	//*****************************************************************************************
	//Displays the information about the game.
	public void getGame()
	{
		//Blue.
		System.out.println("Match " + match);
		System.out.println("       I W Y P");
		System.out.print("Blue : " + IB + " " + WB + " " + YB);
		if (PB == 0)
			System.out.println(" " + PB);
		else if (PB == -1)
			System.out.println(" H");
		else
			System.out.println(" S" + PB);
		
		// White.
		System.out.print("White: " + IW + " " + WW + " " + YW);
		if (PW == 0)
			System.out.println(" " + PW);
		else if (PW == -1)
			System.out.println(" H");
		else
			System.out.println(" S" + PW);
		System.out.println("===============");
		Winner(IB, WB, YB, PB, IW, WW, YW, PW);
	}
	//*****************************************************************************************

}