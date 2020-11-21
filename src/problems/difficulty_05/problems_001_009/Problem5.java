package problems.difficulty_05.problems_001_009;

// Smallest multiple
public class Problem5 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 20;
		long number = limit-1;

		do {
			number++;
		} while (!isDivisibleByEach(number, limit));

		System.out.println("Number divisible by each = " + number);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static boolean isDivisibleByEach (long number, int limit) {

		boolean isDivisibleByEach = true;

		for (int i = 2; i <= limit; i++) {
			if (number % i != 0) {
				isDivisibleByEach = false;
				break;
			}
		}

		return isDivisibleByEach;
	}

}
