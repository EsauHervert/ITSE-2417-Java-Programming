//Esau Hervert
//ITSE 2417
//Program 2 - Problem 2
//References/Option: None

import java.util.Scanner;

public class VowelsInWordsEH {
	public static void main(String[] args){
		
		//Take in the word.
		System.out.print("Enter a word: ");
		
		//***********************************************************************************
		//Initialize the word to Hello.
		String word = "Hello";
		
		//The boolean values that will flag wheter the word has the vowels and is in order.
		boolean flagA = false, flagE = false, flagI = false, flagO = false, flagU = false;
		boolean flag = false;
		
		//Will be used to determine order of vowels.
		int A = 0, E = 0, I = 0, O = 0, U = 0;
		//***********************************************************************************
		
		//***********************************************************************************

		//Get the word from the user.
		Scanner w = new Scanner(System.in);
		word = w.nextLine();
		
		//Convert to upper case.
		word = word.toUpperCase();
		
		
		//***********************************************************************************
		//This section will check to see if the word has the vowels.
		for (int i = 0; i < word.length(); i++){
			
			char L = word.charAt(i);
			
			switch (L){
			case 'A':{
				flagA = true;
				A = i;
				break;
			}
			case 'E':{
				flagE = true;
				E = i;
				break;
			}
			case 'I':{
				flagI = true;
				I = i;
				break;
			}
			case 'O':{
				flagO = true;
				O = i;
				break;
			}
			case 'U':{
				flagU = true;
				U = i;
				break;
			}
			default: {
				//Nothing.
			}
			}
		}
		//***********************************************************************************
		
		//***********************************************************************************
		//This section will check to see if the letters are in order.
		if (flagA && flagE && flagI && flagO && flagU){
			if (A < E && A < I && A < O && A < U){
				if (E < I && E < O && E < U){
					if (I < O && I < U){
						if (O < U)
							flag = true;
					}
				}
			}
		}
		//***********************************************************************************
		
		//***********************************************************************************
		//Displays the word back to the user.
		System.out.print(word + " - ");
		
		if (flagA && flagE && flagI && flagO && flagU && !flag){ 	// All but not in order.
			System.out.println("ALL, NOT IN ORDER");
		}
		else if (flag){												// All in order.
			System.out.println("ALL, IN ORDER");
		}
		else{														//Missing letters.
			System.out.print("DOES NOT CONTAIN ");
			if (!flagA){
				System.out.print("A ");
			}
			if (!flagE){
				System.out.print("E ");
			}
			if (!flagI){
				System.out.print("I ");
			}
			if (!flagO){
				System.out.print("O ");
			}
			if (!flagU){
				System.out.print("U ");
			}
		}

		w.close();
	}

}