package problems.difficulty_05.problems_050_059;

import java.math.BigInteger;

// Combinatoric selections
public class Problem53 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 1000000;
		
		int numberCombinations = 0;
		for (int i = 1; i <= 100; i++) {
			for (int j = 1; j <= i; j++) {
				if (factorial(new BigInteger(Integer.toString(i))).divide(factorial(new BigInteger(Integer.toString(j))).multiply(factorial(new BigInteger(Integer.toString(i-j))))).compareTo(new BigInteger(Integer.toString(limit))) == 1) {
					numberCombinations++;
				}
			}
		}
		
		System.out.println("Number of combinations greater than the limit = " + numberCombinations);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static BigInteger factorial (BigInteger number) {

		if (number.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		return number.multiply(factorial(number.subtract(BigInteger.ONE)));
	}

}
