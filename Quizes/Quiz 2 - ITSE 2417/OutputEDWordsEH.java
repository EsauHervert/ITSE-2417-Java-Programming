//Esau Hervert
//ITSE 2417
//Quiz 2 - Extra Credit.
//References/Option: http://stackoverflow.com/questions/6805028/how-to-replace-backward-slash-to-forward-slash-using-java - Replace / with \.
//https://www.youtube.com/watch?v=FHDNwJmus3k - IOException.
//http://stackoverflow.com/questions/11229986/get-string-character-by-index-java - Individual characters in a string.
//http://stackoverflow.com/questions/2635076/convert-integer-to-equivalent-number-of-blank-spaces - Spacing of the words.


import java.util.Scanner; //To scan the user input and the words.
import java.io.*; //For the exceptions and the file opening.

public class OutputEDWordsEH {
	public static void main(String[] args) throws IOException {
		
		//
		String dir = "";
		String word = "";
		char S = ' ';
		char L = ' ';
		int lg = 0;
		int counter = 0;
		
		
		//Letting the user input the file name.
		System.out.println("This Program will take in a set of words and display those ending with -ED.");
		
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
		
		//Loop for all the words.
		while (input.hasNextLine())
		{
			//Here we will scan the words individually and find out their lengths.
			word = input.nextLine();
			lg = word.length();
			
			//Second to last and last characters of the string.
			S = word.charAt(lg - 2);
			L = word.charAt(lg - 1);
			
			//Here we will check if the last two words are ED
			if (S == 'e' || S == 'E')
				if(L == 'd' || L == 'D')
				{
					System.out.print(word);
					
					for (int i = word.length(); i < 20; i++)
					{
						System.out.print(" ");
					}
					counter++;
					if (counter == 3)
					{
						System.out.println();
						counter = 0;
					}
				}
		}
		
		//Close the file scanner.
		input.close();
		}
		catch (IOException e)
		{
			System.out.println("File is not Found.");
		}
		
	}
}
