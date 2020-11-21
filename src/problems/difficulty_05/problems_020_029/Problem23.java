package problems.difficulty_05.problems_020_029;

import java.util.ArrayList;

//Non-abundant sums
public class Problem23 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 28123;

		ArrayList<Integer> listAbundantNumbers = new ArrayList<Integer>();

		for (int i = 1; i <= limit; i++) {
			if (sumOfDivisors(i) > i) {
				listAbundantNumbers.add(i);
			}
		}

		ArrayList<Integer> listNumbersSumOfAbundantNumbers = new ArrayList<Integer>();
		for (int i = 0; i < listAbundantNumbers.size(); i++) {
			if (listAbundantNumbers.get(i)*2 <= limit) {
				for (int j = i; i < listAbundantNumbers.size(); j++) {
					int sumOfAbundantNumbers = listAbundantNumbers.get(i) + listAbundantNumbers.get(j);
					if (sumOfAbundantNumbers <= limit) {
						listNumbersSumOfAbundantNumbers.add(sumOfAbundantNumbers);
					} else {
						break;
					}
				}
			} else {
				break;
			}
		}

		long sumNumbersNotSumOfAbundantNumbers = 0;
		for (int i = 1; i <= limit; i++) {
			if (!listNumbersSumOfAbundantNumbers.contains(i)) {
				sumNumbersNotSumOfAbundantNumbers += i;
			}
		}

		System.out.println("Sum of all the numbers which cannot be written as the sum of two abundant numbers = " + sumNumbersNotSumOfAbundantNumbers);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static long sumOfDivisors (int number) {

		long sumOfDivisors = 1;

		for (int i = 2; i <= number/2; i++) {
			if (number % i == 0) {
				sumOfDivisors += i;
			}
		}

		return sumOfDivisors;
	}

}
