package problems.difficulty_05.problems_050_059;

import java.util.ArrayList;

// Consecutive prime sum
public class Problem50 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int limit = 1000000;
		
		ArrayList<Integer> primes = new ArrayList<Integer>();
		int number = 0;
		int sumPrimes = 0;
		do {
			number++;
			if (isPrime(number)) {
				primes.add(number);
				sumPrimes+=number;
			}
		} while (sumPrimes < limit);
		primes.remove(primes.size()-1);
		
		int primeSumMostConsecutivePrimes = 0;
		int numberConsecutivePrimes = primes.size();
		do {
			for (int i = 0; i <= primes.size()-numberConsecutivePrimes; i++) {
				int sum = 0;
				for (int j = 0; j < numberConsecutivePrimes; j++) {
					sum += primes.get(i+j);
				}
				if (isPrime(sum)) {
					primeSumMostConsecutivePrimes = sum;
					break;
				}
			}
			numberConsecutivePrimes--;
		} while (primeSumMostConsecutivePrimes == 0);
		
		System.out.println("Number of terms for the longest sum of consecutive primes = " + (numberConsecutivePrimes+1));
		
		System.out.println();
		System.out.println("Prime that can be written as the sum of the most consecutive primes = " + primeSumMostConsecutivePrimes);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
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
