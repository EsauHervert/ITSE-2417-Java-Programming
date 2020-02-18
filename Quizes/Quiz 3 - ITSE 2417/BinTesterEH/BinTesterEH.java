// Esau Hervert
// ITSE 2417
// Quiz 3
// Extra Credit
// References: https://www.youtube.com/watch?v=-if77wPQKhg - Binary Files.

// import java.io.BufferedWriter; // Part of the error.
// import java.io.File; // Part of the error.
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
// import java.io.FileWriter; // Part of the error.
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

public class BinTesterEH {

	public static void main(String[] args) {
		String FileName = "data.bin"; // Where the name of the file will be stored.
	// 	String OutPutname = ""; // Part of the error.
		String Ans = "W"; // Where the answer will be put.
	//	String Ans2 = "R"; // Where the answer will be put. // Part of the error.

		// Variables that will be used.
		double D = 0;
		double hold = 0;
		double Sum = 0;
		double counter = 0;
				
			// In case of errors.
			try {
				
				// Create the binary file.
				FileOutputStream OutFile = new FileOutputStream(FileName);
				
				ObjectOutputStream Out = new ObjectOutputStream(OutFile);
				
				do {
					// Write to the file.
					System.out.print("Enter a double value: ");
					Scanner Scan = new Scanner(System.in); // To scan the line for the name.
					D = Scan.nextDouble();
					counter++;
					
					Out.writeDouble(D);
					
					System.out.println();
									
					// Ask the user if they would like to write to the file or read information.
					System.out.println("Would you like to write to the file or would you like to read the information?");
					System.out.print("Enter W for Write or R for Read: ");
									
					Scanner Scan2 = new Scanner(System.in); // To scan the line for the answer.
					Ans = Scan2.nextLine();
	
					System.out.println();

					if (Ans.charAt(0) == 'R')
					{
						Scan.close(); // Close the scanner.
						Scan2.close(); // Close the scanner.
						Out.close(); // Close the binary file.
					}
				} while (Ans.charAt(0) == 'W');

			// Errors if any.	
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println("Done Writting"); // Let the user know that the program wrote the values.
		System.out.println();
		
		FileInputStream InFile;
		try {
			
			InFile = new FileInputStream(FileName);
			
			ObjectInputStream In = new ObjectInputStream(InFile);
			
			// Does not work correctly.
		/*	System.out.println("Would you like to read the doubles or put them in a file?");
			System.out.print("Enter F for File or R for Read: ");
			
			// Does not work correctly.
			Scanner Scan3 = new Scanner(System.in); // To scan the line for the name.
			Ans2 = Scan3.nextLine(); */

			if (Ans.charAt(0) == 'R')
			{
				System.out.println("Here are the double values: ");
				
				// Loop to display the values.
				for (int i = 0; i < counter; i++)
				{
					hold = In.readDouble();
					System.out.println(hold);
					Sum += hold;
				}
			}
			
		/*	else if (Ans.charAt(0) == 'F')
			{
				System.out.println("Enter the name of the file followed by a .txt: ");
				
				Scanner Scan4 = new Scanner(System.in); // To scan the line for the Output File.
				OutPutname = Scan4.nextLine();
				
				Scan4.close(); // Close the scanner.
				
	             File file = new File(OutPutname);

	 			FileWriter fw = new FileWriter(file.getAbsoluteFile());
				BufferedWriter bw = new BufferedWriter(fw);

				for (int i = 0; i < counter; i++)
				{
					hold = In.readDouble();
					bw.write(String.valueOf(hold));
					Sum += hold;
				}
				
				bw.close();
			} */

			System.out.println();

			// Average and number of doubles.
			System.out.println("Number of doubles: " + (int) counter);
			System.out.println("Average: " + (Sum / counter));
			
			//Scan3.close(); // Close the scanner.
			In.close(); // Close the binary file.

			// Errors if any.	
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
