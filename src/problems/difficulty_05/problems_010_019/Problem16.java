package problems.difficulty_05.problems_010_019;

import java.math.BigInteger;

// Power digit sum
public class Problem16 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		BigInteger number = new BigInteger("2").pow(1000);
		String numberString = number.toString();
		long sumOfDigits = 0;
		for (int i = 0; i < numberString.length(); i++) {
			sumOfDigits+=Integer.parseInt(String.valueOf(numberString.charAt(i)));
		}
		
		System.out.println("Sum of digits = " + sumOfDigits);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
