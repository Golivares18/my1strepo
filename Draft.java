/*
 * Gregorio Olivares
 * Object Oriented Programming - cpsc24500 - Section 3
 * 2024-02-11
 * The purpose of this code is to calculate the income tax based off a user income
*/


//Packages and imports
package m;
import java.util.*;
import java.lang.*;


public class Draft {
	
	// Instance variables
	String firstName;
	String lastName;
	double i;
	int income;
	int incomeTaxed;
	double t;

	// Main
	public static void main(String[] args) {
		// Calling public from static
		new Draft().getInfo();
	}
	
	
	// method to gather user info
	public void getInfo() {
		// Name
		Scanner scan = new Scanner(System.in);
		System.out.print("Enter your first and last name here: ");
		firstName = scan.next();
		lastName = scan.next();
		
		
		// Income
		System.out.print("Please enter your current income: ");
		i = Math.round(scan.nextDouble());
		
		income = (int)i;
		// 
		if (income<0) {
			System.out.print("Invalid input, income should be zero or more.");
			System.exit(0);
		} else {
			tax(income);
			printResults();
		}
	}
	
	public void tax(int i) {
		// Taxes for 10%, 20%, and 40% & variables to hold values for leftover
		double x = 0.10;
		double y = 0.20;
		double z = 0.40;
		double leftOver;
		double a;
		double b;
		double c;
		
		if (i<=4000) {
			t = 0;
		} else {
			// Computes if 10% will be taxed
			if (i>=4000 && i<=5500) {
				leftOver = i-4000;
				t = leftOver * x;
			} else {
			// Computes if 10% and 20% will be taxed
			// value is 29500 because it adds the initial 1500 for 10% and 28000 for 20%
				if (i>=4000 && i<=29500) {
				leftOver = i-4000;
				leftOver = leftOver-1500;
				a = 1500*x;
				b = leftOver*y;
				t = a + b;
			} else {
				// Computes if 10%,20%,and 40% will be taxed
			} 
				if (i>=4000 && i>29500) {
					leftOver = i-4000;
					leftOver = leftOver-(1500+28000);
					a = 1500*x;
					b = 28000*y;
					c = leftOver*z;
					t = a+b+c;
				}
				
			}
	}
		// convert double to int for final
		incomeTaxed = (int)t;
	}
	
	// Print Name, Income, and Income Tax
	public void printResults() {
		System.out.println(" ");
		System.out.println("Below are your results: ");
		System.out.println("Name: " + firstName + " " + lastName);
		System.out.println("Income: J$" + income);
		System.out.println("Income Tax: J$" + incomeTaxed);
	}
	

}
