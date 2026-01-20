/* 
 * Zachary Sheridan
 * Sheridan Calculate Interest
 * This program is designed to take in input from a user, from a dialog box, for a balance and a yearly interest rate. A monthly interest rate is then calculated and displayed.
 * 9/3/2023
 */
import java.text.DecimalFormat;

import javax.swing.JOptionPane; // Needed for Dialog Box

public class SheridanCalculateInterestDialog 
{

	public static void main(String[] args) 
	{
		//Declare Variables (I didn't do this in the console version but here it makes it easier to see)
		String input;
		double balance;
		double interestRate;
		double interest;
		
		// Prompt user to enter current balance
		input = JOptionPane.showInputDialog("Please enter your current balance:");
		
		// Covert the string input to a double
		balance = Double.parseDouble(input);
		
		//Prompt user to input yearly interest rate
		input = JOptionPane.showInputDialog("Please enter your Annual Interest Rate:");
		
		//Convert the string input to a double
		interestRate = Double.parseDouble(input);
		
		//Calculate Monthly Interest Rate
		interest = balance * (interestRate/1200);
		
		//Format Decimal (you didn't require this, I just wanted to do it because it looks so much better)
		DecimalFormat df = new DecimalFormat("#####.##");
		String formatted = df.format(interest);
		
		//Output results
		JOptionPane.showMessageDialog(null, "Your Monthly Interest is: " +formatted);
	}

}
