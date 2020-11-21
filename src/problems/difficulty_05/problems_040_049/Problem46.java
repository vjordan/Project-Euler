package problems.difficulty_05.problems_040_049;

import java.util.ArrayList;

// Goldbach's other conjecture
public class Problem46 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int number = 1;
		int smallestOddCompositeNumber = 0;
		do {
			number++;
			if (isOddComposite(number) && !isFollowingConjecture(number)) {
				smallestOddCompositeNumber = number;
			}
		} while (smallestOddCompositeNumber == 0);
		
		System.out.println();
		System.out.println("Smallest odd composite that cannot be written as the sum of a prime and twice a square = " + smallestOddCompositeNumber);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isOddComposite (int number) {
		
		if (number % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(number); i = i+2) {
			if (number % i == 0) {
				return true;
			}
		}
		return false;
	}
	
	public static boolean isFollowingConjecture (int number) {
		
		ArrayList<Integer> primesUnderNumber = new ArrayList<Integer>();
		for (int i = 2; i < number; i++) {
			if (isPrime(i)) {
				primesUnderNumber.add(i);
			}
		}
		for (int i = primesUnderNumber.size()-1; i >= 0; i--) {
			if ((number-primesUnderNumber.get(i)) % 2 == 0
					&& (int) Math.sqrt((number-primesUnderNumber.get(i))/2) == (double) Math.sqrt((number-primesUnderNumber.get(i))/2)) {
				System.out.println(number + " = " + primesUnderNumber.get(i) + " + 2 * " + (int) Math.sqrt((number-primesUnderNumber.get(i))/2) + "^2");
				return true;
			}
		}
		return false;
	}
	
	public static boolean isPrime (int number) {

		if (number == 2) {
			return true;
		}
		if (number < 2 || number % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(number); i = i+2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

}
