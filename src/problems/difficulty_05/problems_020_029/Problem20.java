package problems.difficulty_05.problems_020_029;

import java.math.BigInteger;

//Factorial digit sum
public class Problem20 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		long number = 100;
		String factorialResult = factorial(BigInteger.valueOf(number)).toString();

		long sumOfDigits = 0;
		for (int i = 0; i < factorialResult.length(); i++) {
			sumOfDigits+=Integer.parseInt(String.valueOf(factorialResult.charAt(i)));
		}

		System.out.println("Sum of the digits = " + sumOfDigits);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static BigInteger factorial (BigInteger number) {

		if (number.equals(BigInteger.valueOf(1))) {
			return BigInteger.valueOf(1);
		}
		return number.multiply(factorial(number.subtract(BigInteger.valueOf(1))));
	}

}

