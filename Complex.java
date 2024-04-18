package m;
import java.text.DecimalFormat;
import java.util.*;

/*
 * Gregorio Olivares
 * This will complete various operations that will print out complex numbers
 * CPSC 24500 - Object Oriented Programming - Section 3
 * 2024-04-19
 */
public class Complex {

	private double realPart;
	private double imaginaryPart;
	
	/**
	 * The main method will ask the user to input 2 sets of values that will be the real and imaginary respectively
	 * It then will print out the numerical complex numbers after adding, subtracting, dividing, multiplying, and the absolute value
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		

        System.out.print("Enter the first complex number: ");
        double real1 = scan.nextDouble();
        double imaginary1 = scan.nextDouble();
        Complex complex1 = new Complex(real1, imaginary1);

        System.out.print("Enter the second complex number: ");
        double real2 = scan.nextDouble();
        double imaginary2 = scan.nextDouble();
        Complex complex2 = new Complex(real2, imaginary2);

        System.out.println("(" + complex1 + ") + (" + complex2 + ") = " + complex1.add(complex2));
        System.out.println("(" + complex1 + ") - (" + complex2 + ") = " + complex1.subtract(complex2));
        System.out.println("(" + complex1 + ") * (" + complex2 + ") = " + complex1.multiply(complex2));
        System.out.println("(" + complex1 + ") / (" + complex2 + ") = " + complex1.divide(complex2));
        System.out.println("|" + complex1 + "| = " + complex1.abs());
		
	}
	
	
	/**
	 * Constructors 
	 * @param a
	 * @param b
	 */
	public Complex(double realPart, double imaginaryPart) {
		this.realPart = realPart;
		this.imaginaryPart = imaginaryPart;
	}
	
	public Complex() {
		this(0,0);
	}
	
	public Complex(double realPart) {
		this(realPart,0);
	}
	
	public Complex(Complex complexNumber) {
		this.realPart = complexNumber.realPart;
		this.imaginaryPart = complexNumber.imaginaryPart;
	}
	
	
	
	/**
	 * getRealPart will return the real part of the complex number
	 * getImaginaryPart will return the imaginary value of the complex number
	 * @return
	 */
	public double getRealPart() {
		return realPart;
	}
	
	public double getImaginaryPart() {
		return imaginaryPart;
	}
	
	
	
	/**
	 * Methods to add, subtract, multiply, divide, and abs
	 * Will perform operations on the complex numbers
	 * @return
	 */
	
	public Complex add(Complex n) {
		double real = this.realPart + n.realPart;
	    double imaginary = this.imaginaryPart + n.imaginaryPart;
	    return new Complex(real, imaginary);
	}
	
	
	public Complex subtract(Complex n) {
		double real = this.realPart - n.realPart;
	    double imaginary = this.imaginaryPart - n.imaginaryPart;
	    return new Complex(real, imaginary);
	}
	
	
	public Complex multiply(Complex n) {
        double real = this.realPart * n.realPart - this.imaginaryPart * n.imaginaryPart;
        double imaginary = this.imaginaryPart * n.realPart + this.realPart * n.imaginaryPart;
        return new Complex(real, imaginary);		
	}
	
	
	public Complex divide(Complex n) {
        double divisor = n.realPart * n.realPart + n.imaginaryPart * n.imaginaryPart;
        double real = (this.realPart * n.realPart + this.imaginaryPart * n.imaginaryPart) / divisor;
        double imaginary = (this.imaginaryPart * n.realPart - this.realPart * n.imaginaryPart) / divisor;
        
        DecimalFormat df = new DecimalFormat("#.####");
        real = Double.parseDouble(df.format(real));
        
        
       imaginary = Math.round(imaginary *10.0) / 10.0 ;
        
        return new Complex(real, imaginary);		
	}
	
	
	public double abs() {
		return Math.sqrt(realPart * realPart + imaginaryPart * imaginaryPart);

	}
	
	
	/**
	 * Override toString method
	 */
	@Override
	public String toString() {
        if (imaginaryPart == 0) {
            return String.valueOf(imaginaryPart) + " + " + String.valueOf(realPart);
        } else if (realPart == 0) {
            return String.valueOf(realPart)+ " + " + imaginaryPart + "i";
        } else if (imaginaryPart < 0) {
            return realPart + " - " + (-imaginaryPart) + "i";
        } else {
            return realPart + " + " + imaginaryPart + "i";
        }		
	}
	
	
	/**
	 * Implementation of Comparable method
	 */
	public int compareTo(Complex other) {
		return Double.compare(this.abs(),other.abs());
	}


}
