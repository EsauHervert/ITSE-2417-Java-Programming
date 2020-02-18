//Esau Hervert
//ITSE 2417
//Program 2 - Problem 1
//References/Option: None

import java.util.Scanner; //Use to take inputs.
import java.lang.Math; //Math.pow().

public class HeptScoreEH {

	public static void main(String[] args){
		//These are the values that the user will input.
		double R100 = 0, HJ = 0, SP = 0, R200 = 0, LJ = 0, JT = 0, R800 = 0;
		double SR100 = 0, SHJ = 0, SSP = 0, SR200 = 0, SLJ = 0, SJT = 0, SR800 = 0;
		double Total = 0;
		String Name = "Paul";
		
		//Purpose of the program.
		System.out.println("This Program will calculate your score for the Heptaton.");
		
		//Ask for the user's name.
		System.out.print("Name: ");
		Scanner name1 = new Scanner(System.in);
		Name = name1.nextLine();
		
		System.out.println();
				
		//*******************************************************************************
		//Taking the user's information.
		
		System.out.println("Please enter the values for the following events:");

		//The values for a, b, and c were given.
		//100 Meter.
		System.out.print("100 Meter Hurdle: ");
		R100 = Scanner();
		SR100 = Math.floor(RunningScore(R100, 9.23076, 26.7, 1.835));
		
		//High Jump.
		System.out.print("High Jump: ");
		HJ = Scanner();
		SHJ = Math.floor(OtherScore(HJ*100, 1.84523, 75, 1.348));
		
		//Shot Put.
		System.out.print("Shot Put: ");
		SP = Scanner();
		SSP = Math.floor(OtherScore(SP, 56.0211, 1.5, 1.05));
		
		//200 Meter.
		System.out.print("200 Meter Hurdle: ");
		R200 = Scanner();
		SR200 = Math.floor(RunningScore(R200, 4.99087, 42.5, 1.81));
		
		//Long Jump
		System.out.print("Long Jump: ");
		LJ = Scanner();
		SLJ = Math.floor(OtherScore(LJ*100, 0.188807, 210, 1.41));
		
		//Javelin Throw.
		System.out.print("Javelin Throw: ");
		JT = Scanner();
		SJT = Math.floor(OtherScore(JT, 15.9803, 3.8, 1.04));
		
		//800 Meter.
		System.out.print("800 Meter Hurdle: ");
		R800 = Scanner();
		SR800 = Math.floor(RunningScore(R800, 0.11193, 254, 1.88));
		//*******************************************************************************
		
		//Calculating the total score.
		Total = SR100 +  SHJ + SSP + SR200 + SLJ+ SJT + SR800;
		
		System.out.println(Name + " Total Score is: " + Total + ".");
		
		name1.close();
	}
	
	//This Method will allow to take in the user's inputs.
		public static double Scanner(){
			
			//Creating the scanner.
			Scanner NS = new Scanner(System.in);
			double Number = NS.nextDouble();
			
			//Returning the value.
			return Number;
		}
		
	//THis Method calculates the value of the running events.
		public static double RunningScore(double Value, double a, double b, double c){
			
			//Calculating the score for the particular event.
			double score = 0;
			score = a * Math.pow((b - Value),c);
			
			return score;
		}
		
	//THis Method calculates the value of the non - running events.
		public static double OtherScore(double Value, double a, double b, double c){
			
			//Calculating the score for the particular event.
			double score = 0;
			score = a * Math.pow((Value - b),c);
			
			return score;
		}
}
