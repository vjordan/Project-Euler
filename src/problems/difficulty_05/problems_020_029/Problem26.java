package problems.difficulty_05.problems_020_029;

import java.math.BigInteger;

// Reciprocal cycles
public class Problem26 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 1000;

		int indexLongestRecurringCycle = 0;
		int lengthLongestRecurringCycle = 0;

		for (int i = 7; i <= limit; i = i+2) {
			if (isFactor(i)) {
				BigInteger recurringCycle = new BigInteger("10").pow(i-1).subtract(BigInteger.ONE).divide(new BigInteger(Integer.toString(i)));
				int lengthRecurringCycle = recurringCycle.toString().length();
				if (i > 10) {
					lengthRecurringCycle++;
				}
				if (i > 100) {
					lengthRecurringCycle++;
				}
				if (!hasShorterCycle(recurringCycle) && lengthRecurringCycle > lengthLongestRecurringCycle) {
					lengthLongestRecurringCycle = lengthRecurringCycle;
					indexLongestRecurringCycle = i;
					System.out.println("1/" + indexLongestRecurringCycle);
				}
			}
		}

		System.out.println();
		System.out.println("Value which contains the longest recurring cycle in its decimal fraction part = " + indexLongestRecurringCycle);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static boolean isFactor (int number) {

		boolean isFactor = true;

		for (int i = 3; i <= Math.sqrt(number); i = i+2) {
			if (number % i == 0) {
				isFactor = false;
				break;
			}
		}

		return isFactor;
	}

	public static boolean hasShorterCycle (BigInteger number) {

		String potentialStartCycle = number.toString().substring(0,3);
		if (number.toString().substring(3).contains(potentialStartCycle)) {
			return true;
		}
		return false;
	}

}