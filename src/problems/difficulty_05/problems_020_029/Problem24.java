package problems.difficulty_05.problems_020_029;

import java.util.ArrayList;
import java.util.Arrays;

// Lexicographic permutations
public class Problem24 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		long expectedPosition = 1000000;
		ArrayList<Integer> listValues = new ArrayList<Integer>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

		String expectedPermutation = "";
		
		do {
			long factorial = factorial(listValues.size()-1);
			int positionDigit = (int) (expectedPosition/factorial);
			if (expectedPosition % factorial == 0) {
				positionDigit--;
			}
			expectedPermutation += listValues.get(positionDigit).toString();
			expectedPosition -= factorial*positionDigit;
			listValues.remove(positionDigit);
		} while (!listValues.isEmpty());

		System.out.println("Lexicographic permutation at expected position = " + expectedPermutation);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static long factorial (int number) {

		if (number == 0) {
			return 1;
		}
		return number * factorial(number-1);
	}

}

