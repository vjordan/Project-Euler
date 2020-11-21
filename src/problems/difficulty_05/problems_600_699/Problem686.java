package problems.difficulty_05.problems_600_699;

import java.math.BigInteger;

public class Problem686 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int digits = 123;
		int digitsLength = Integer.toString(digits).length();
		int limit = 678910;
		
		BigInteger two = new BigInteger("2");
		int power = 0;
		int position = 0;
		int result = 0;
		
		while (position < limit) {
			BigInteger number = two.pow(power);
			if (number.toString().length() >= digitsLength && Integer.parseInt(number.toString().substring(0, digitsLength)) == digits) {
				result = power;
				position++;
				System.out.println("p(" + digits + ", " + position + ") = " + result);
			}
			power++;
		}
		
		System.out.println();
		System.out.println("p(" + digits + ", " + position + ") = " + result);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
