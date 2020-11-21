package problems.difficulty_05.problems_090_099;

import java.math.BigInteger;

// Large non-Mersenne prime
public class Problem97 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int numberDigits = 10;
		
		BigInteger nonMersennePrime = new BigInteger("28433").multiply(new BigInteger("2").pow(7830457)).add(BigInteger.ONE);
		String lastDigits = nonMersennePrime.toString().substring(nonMersennePrime.toString().length()-numberDigits);
		
		System.out.println("Last digits of the massive non-Mersenne prime = " + lastDigits);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
