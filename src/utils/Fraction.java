package utils;

public class Fraction {

	long numerator;
	long denominator;

	/**
	 * Constructor
	 * 
	 * @param numr
	 * @param denr
	 */
	public Fraction(long numr, long denr) {
		numerator = numr;
		denominator = denr;
		reduce();
	}

	public long getNumerator() {
		return numerator;
	}

	public void setNumerator(long numerator) {
		this.numerator = numerator;
	}

	public long getDenominator() {
		return denominator;
	}

	public void setDenominator(long denominator) {
		this.denominator = denominator;
	}

	/**
	 * Calculates gcd of two numbers
	 * 
	 * @param numerator
	 * @param denominator
	 * @return
	 */
	public long calculateGCD(long numerator, long denominator) {
		if (numerator % denominator == 0) {
			return denominator;
		}
		return calculateGCD(denominator, numerator % denominator);
	}

	/**
	 * Reduce the fraction to lowest form
	 */
	void reduce() {
		long gcd = calculateGCD(numerator, denominator);
		numerator /= gcd;
		denominator /= gcd;
	}

	/**
	 * Adds two fractions
	 * 
	 * @param fractionTwo
	 * @return
	 */
	public Fraction add(Fraction fractionTwo) {
		long numer = (numerator * fractionTwo.getDenominator()) + 
				(fractionTwo.getNumerator() * denominator);
		long denr = denominator * fractionTwo.getDenominator();
		return new Fraction(numer, denr);
	}

	/**
	 * Subtracts two fractions
	 * 
	 * @param fractionTwo
	 * @return
	 */
	public Fraction subtract(Fraction fractionTwo) {
		long newNumerator = (numerator * fractionTwo.denominator) - 
				(fractionTwo.numerator * denominator);
		long newDenominator = denominator * fractionTwo.denominator;
		Fraction result = new Fraction(newNumerator, newDenominator);
		return result;
	}

	/**
	 * Multiples two functions
	 * 
	 * @param fractionTwo
	 * @return
	 */
	public Fraction multiply(Fraction fractionTwo) {
		long newNumerator = numerator * fractionTwo.numerator;
		long newDenominator = denominator * fractionTwo.denominator;
		Fraction result = new Fraction(newNumerator, newDenominator);
		return result;
	}

	/**
	 * Divides two fractions
	 * 
	 * @param fractionTwo
	 * @return
	 */
	public Fraction divide(Fraction fractionTwo) {
		long newNumerator = numerator * fractionTwo.getDenominator();
		long newDenominator = denominator * fractionTwo.numerator;
		Fraction result = new Fraction(newNumerator, newDenominator);
		return result;
	}

	/**
	 * Returns string representation of the fraction
	 */
	@Override
	public String toString() {
		return this.numerator + "/" + this.denominator;
	}

	public static void main(String[] args) {
		Fraction f1 = new Fraction(25, 35);
		System.out.println(f1.toString());
		Fraction f2 = new Fraction(2, 7);
		Fraction f3 = f1.add(f2);
		System.out.println("Result of addition of " 
				+ f1 + " and " + f2 + " is : " + f3);
		f3 = f1.subtract(f2);
		System.out.println("Result of subtraction of " 
				+ f1 + " and " + f2 + " is : " + f3);
		f3 = f1.divide(f2);
		System.out.println("Result of division of " 
				+ f1 + " and " + f2 + " is : " + f3);
		f3 = f1.multiply(f2);
		System.out.println("Result of multiplication of " 
				+ f1 + " and " + f2 + " is : " + f3);
	}
}
