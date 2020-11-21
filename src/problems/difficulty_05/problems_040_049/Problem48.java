package problems.difficulty_05.problems_040_049;

import java.math.BigInteger;

// Self powers
public class Problem48 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int limit = 1000;
		int numberDigits = 10;
		
		BigInteger series = BigInteger.ZERO;
		for (int i = 1; i <= limit ; i++) {
			series = series.add(new BigInteger(Integer.toString(i)).pow(i));
		}
		
		System.out.println(series);
		
		System.out.println();
		System.out.println("Last digits of the series = " + series.toString().substring(series.toString().length()-numberDigits));
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
