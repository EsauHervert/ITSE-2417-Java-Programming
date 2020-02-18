//SqrtException.java
import java.util.Scanner;

public class SqrtException 										//1
{
	public static void main(String[] args) throws ArithmeticException
	{
		
		Scanner in = new Scanner(System.in);
		double num, result;
		
		System.out.print("Enter a number: ");
		num = in.nextDouble();
		try														//2
			{
			if (num < 0)
				throw new ArithmeticException();				//3
			result = Math.sqrt(num);
			System.out.println("Result is: " + result);			//4
		}
		catch(ArithmeticException e)							//5
		{
			System.out.println("Can't take square root of negative number");
		}
	}
	
	
	
}
