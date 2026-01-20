/* 
 * Zachary Sheridan
 * Sheridan Calculate Interest
 * This program is designed to take in input from a user, from a console, for a balance and a yearly interest rate. A monthly interest rate is then calculated and displayed.
 * 9/3/2023
 */
import java.util.Scanner;

public class SheridanCalculateInterestConsole 
{
	
	public static void main(String[] args) 
	{
		
		try (Scanner sc = new Scanner(System.in)) 
		{
			//Take input for current balance
			System.out.print("Please enter your current balance:");
			double balance = sc.nextDouble();
			
			//Take input for current interest rate
			System.out.print("Please enter your Annual Interest Rate:");
			double interestRate = sc.nextDouble();
			
			//Calculation
			double interest = balance * (interestRate / 1200);
			
			//Display
			System.out.printf("Your Monthly Interest is : %.2f\n ", interest);
		}
	}
}