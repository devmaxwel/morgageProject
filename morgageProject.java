import java.text.NumberFormat;
import java.util.Scanner;

public class morgageProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Morgage Calculator
		
		//Constants
		Scanner scanner = new Scanner(System.in);		
		final byte Months_Per_Year = 12;
		final byte Percent = 100;
		
		int principal = 0;
		float monthlyRate = 0;
		int numberOfPayments = 0;
	
		//Getting User inputs
		//Validating Principal
		while(true) {
		
			System.out.print("Enter Principal: ");
			principal = scanner.nextInt();
			if (principal >= 1000 && principal <= 1000_000)
				break;
			System.out.println("Please Enter a value that is betwwen 1,000 & 1,000,000");
		}
		
		//Validating Annual Rate
	   while(true) {
	   System.out.print("Enter Annual Rate: ");
	   float annualRate = scanner.nextFloat();
	   
	   if ( annualRate >= 0 && annualRate <= 30) {
		   monthlyRate = annualRate / Percent / Months_Per_Year;  //Converting Annual rate to monthly rate
		   break;
	   }
	   System.out.println("Please Enter a value that is between 1 && 30");
	  
		}
		
		
		//Validating Period 
	   while(true) {
	   System.out.print("Enter period(in Years): ");
	   int  period = scanner.nextInt();
	   if(period >= 1 && period <= 20) {
		    numberOfPayments = period * Months_Per_Year;//getting the number of months in the number of years to get specific periods of payments. 
		   break;
	   }
	 System.out.println("Please Enter A Value that is between 1 and 20");
		}
	   
	   //Calculations
	   double Morgage = principal * ( monthlyRate * Math.pow( 1 + monthlyRate, numberOfPayments))/(Math.pow( 1 + monthlyRate, numberOfPayments)-1);
	   
	   NumberFormat Morgage_To_Dollars = NumberFormat.getCurrencyInstance();
	   String AnnualMorgage = Morgage_To_Dollars.format(Morgage);
	   
	   
	   scanner.close();
	   System.out.println("The Morgage is: " + AnnualMorgage);
	   	

	}

}
