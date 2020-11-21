package problems.difficulty_05.problems_040_049;

import java.util.ArrayList;

// Distinct primes factors
public class Problem47 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int numberConsecutiveNumbersAndDistinctPrimeFactors = 4;
		
		ArrayList<Integer> primes = primesBuilding();
		ArrayList<Integer> consecutiveNumbers = new ArrayList<Integer>();
		
		int number = 0;
		do {
			number++;
			int divisiblePrimes = 0;
			for (int i = 0; i < primes.size(); i++) {
				if (primes.get(i) < number) {
					if (number % primes.get(i) == 0) {
						divisiblePrimes++;
						if (divisiblePrimes == numberConsecutiveNumbersAndDistinctPrimeFactors) {
							if (!consecutiveNumbers.isEmpty() && consecutiveNumbers.get(consecutiveNumbers.size()-1) != number-1) {
								consecutiveNumbers.removeAll(consecutiveNumbers);
							}
							consecutiveNumbers.add(number);
							break;
						}
					}
				} else {
					break;
				}
			}
		} while (consecutiveNumbers.size() < numberConsecutiveNumbersAndDistinctPrimeFactors);
		
		System.out.println("First number of the consecutive integers having distinct prime factors = " + consecutiveNumbers.get(0));
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static ArrayList<Integer> primesBuilding() {
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			if (isPrime(i)) {
				primes.add(i);
			}
		}
		return primes;
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
