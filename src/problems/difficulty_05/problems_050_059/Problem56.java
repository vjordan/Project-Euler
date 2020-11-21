package problems.difficulty_05.problems_050_059;

import java.math.BigInteger;

// Powerful digit sum
public class Problem56 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int limit = 100;
		int maximumDigitalSum = 0;
		
		for (int i = 1; i < limit; i++) {
			for (int j = 1; j < limit; j++) {
				BigInteger number = new BigInteger(Integer.toString(i)).pow(j);
				int digitalSum = 0;
				for (int k = 0; k < number.toString().length(); k++) {
					digitalSum += Integer.parseInt(Character.toString(number.toString().charAt(k)));
				}
				if (digitalSum > maximumDigitalSum) {
					maximumDigitalSum = digitalSum;
					System.out.println(i + "^(" + j + ") = " + digitalSum);
				}
			}
		}
			
		System.out.println();
		System.out.println("Maximum digital sum = " + maximumDigitalSum);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
