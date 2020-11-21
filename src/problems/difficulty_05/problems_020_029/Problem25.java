package problems.difficulty_05.problems_020_029;

import java.math.BigInteger;

// 1000-digit Fibonacci number
public class Problem25 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		BigInteger numberA = BigInteger.ONE;
		BigInteger numberB = BigInteger.ONE;
		
		int numberDigits = 1000;
		
		long indexTerm = 2;
		do {
			BigInteger temp = numberA;
			numberA = numberB;
			numberB = numberB.add(temp);
			indexTerm++;
		} while (numberB.toString().length() < numberDigits);
		System.out.println(numberB);
		
		System.out.println();
		System.out.println("Index of the first term in the Fibonacci sequence to contain " + numberDigits + " digits = " + indexTerm);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
