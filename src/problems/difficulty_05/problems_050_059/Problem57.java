package problems.difficulty_05.problems_050_059;

import java.math.BigInteger;

// Square root convergents
public class Problem57 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int limit = 1000;
		
		BigInteger previousNumerator = BigInteger.ONE;
		BigInteger previousDenominator = BigInteger.ONE;
		BigInteger currentNumerator = new BigInteger("3");
		BigInteger currentDenominator = new BigInteger("2");
		int numberExpansions = 1;
		int numberFractions = 0;
		
		while (numberExpansions < limit) {
			BigInteger nextNumerator = currentNumerator.multiply(new BigInteger("2")).add(previousNumerator);
			BigInteger nextDenominator = currentDenominator.multiply(new BigInteger("2")).add(previousDenominator);
			previousNumerator = currentNumerator;
			previousDenominator = currentDenominator;
			currentNumerator = nextNumerator;
			currentDenominator = nextDenominator;
			if (currentNumerator.toString().length() > currentDenominator.toString().length()) {
				numberFractions++;
				System.out.println("Expansion " + (numberExpansions+1) + " = " + currentNumerator + " / " + currentDenominator);
			}
			numberExpansions++;
		}
		
		System.out.println();
		System.out.println("Number of fractions which contain a numerator with more digits than the denominator = " + numberFractions);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
