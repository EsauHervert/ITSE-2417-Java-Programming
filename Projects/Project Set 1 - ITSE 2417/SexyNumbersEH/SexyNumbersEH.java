// Author: Esau Hervert
// Course: ITSE 2417
// Project 1 Problem 2
// References/Option: None

package ITSE2417;

//This Library allows for a scanner to be made allowing user input.
import java.util.Scanner;

class SexyNumbersEH {
	public static void main(String[] args) {

		//This flag will remain true only if the difference in the values is six and they are both prime.
		boolean flag = true;

		//Let the user know the purpose of the program.
		System.out.println("This Program will take in two values between 1 and 3000 and see if they are sexy.\n");
		
		//Taking in the first number.
		System.out.print("The first number is: ");
		Scanner input0 = new Scanner(System.in);
		int number1 = input0.nextInt();
		//Verification for the first number.
		while (number1 < 1 || number1 > 3000)
		{
			System.out.println("That is not a valid value.");
			System.out.print("\nThe first number is: ");
			number1 = input0.nextInt();
		}

		//Taking in the second number.
		System.out.print("The second number is: ");
		Scanner input1 = new Scanner(System.in);
		int number2 = input1.nextInt();

		//Verification for the second number.
		while (number2 < 1 || number2 > 3000)
		{
			System.out.println("That is not a valid value.");
			System.out.print("\nThe second number is: ");
			number2 = input0.nextInt();
		}

		//Display the information back to the user.
		System.out.println("\nThe numbers are:\nNumber 1: " + number1 + "\nNumber 2: " + number2);

		//Note that 1 is not prime.
		if (number1 == 1 || number2 == 1)
		{
			flag = false;
		}

		//******Test if their difference is 6.
		if (Math.abs(number1 - number2) == 6)
		{
			//******Test to see if the numbers are prime.
			for(int i = 2; i < number1; i++)
			{
				if (number1 % i == 0)
					{
						flag = false;
						i = number1;
					}
			}

			for(int j = 2; j < number1; j++)
			{
				if (number2 % j == 0)
				{
					flag = false;
					j = number1;
				}
			}
			//*********************************************
		}
		else
		{
			flag = false;
		}

		//Display to the user if their numbers were sexy or not.
		if (flag)
		{
			System.out.println("\nThese numbers are sexy primes ;-).");
		}
		else
		{
			System.out.println("\nThese numbers are not sexy primes :(.");
		}

		//This terminates the program.
		System.out.print("\n\nEnter any numeric value to end this program: ");
		Scanner inputn = new Scanner(System.in);
		double e = inputn.nextDouble();

	}
}