//Esau Hervert
//ITSE 2417
//Quiz 1 Extra Credit
//References/Option: None

//This is for the scanner.
import java.util.Scanner;

//PrimeFactNormFormEH.Java

public class PrimeFactNormFormEH {
	
	public static void main(String[] arg){
		
		//Ask the user for the number.
		System.out.print("Enter number to factor: ");
		
		//Scanner that will take the user's integer.
		Scanner NS = new Scanner(System.in);
		int Number = NS.nextInt();
		
		//Displaying the results.
		System.out.print("The number " + Number + " factored into it's primes is: ");
		
		//Factoring out the number.
		for (int i = 2; i <= Number; i++){
			int counter = 0;
			while (Number % i == 0){
				Number /= i;
				counter += 1;
			}
			
			//Here are the factors.
			if (counter != 0){
				System.out.print("(" + i);
				
				//If the power is greater than 1.
				if (counter > 1){
					System.out.print("^" + counter);
				}
				System.out.print(")");
			}
		
		}
		
		//Closing the scanner.
		NS.close();
	}

}
