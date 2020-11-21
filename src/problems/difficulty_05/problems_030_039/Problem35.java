package problems.difficulty_05.problems_030_039;

import java.util.ArrayList;
import java.util.Collections;

// Circular primes
public class Problem35 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 1000000;
		ArrayList<Integer> checkedNumbers = new ArrayList<Integer>();
		
		int numberOfCircularPrimes = 0;
		
		for (int i = 0; i < limit/5; i++) {
			if (!checkedNumbers.contains(i)) {
				ArrayList<Integer> numbers = rotateDigits(i);
				int numberNewCircularPrimes = 0;
				for (int number : numbers) {
					if (number > i) {
						checkedNumbers.add(number);
						numberNewCircularPrimes++;
					}
				}
				if (areCircularPrimes(numbers)) {
					numberOfCircularPrimes += numberNewCircularPrimes+1;
					System.out.println(numbers);
				}
			}
		}
		
		System.out.println();
		System.out.println("Number of circular primes below limit = " + numberOfCircularPrimes);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static ArrayList<Integer> rotateDigits (int number) {
		
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		numbers.add(number);
		
		String numberString = Integer.toString(number);
		for (int i = 1; i < numberString.length(); i++) {
			String newNumber = "";
			for (int j = 0; j < numberString.length(); j++) {
				int newIndex = j+i;
				if (newIndex >= numberString.length()) {
					newIndex -= numberString.length();
				}
				newNumber += numberString.charAt(newIndex);
			}
			numbers.add(Integer.parseInt(newNumber));
		}
		
		return numbers;
	}
	
	public static boolean areCircularPrimes (ArrayList<Integer> numbers) {
		
		Collections.sort(numbers);
		for (int number : numbers) {
			if (!isPrime(number)) {
				return false;
			}
		}
		return true;
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
