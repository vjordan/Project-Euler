package problems.difficulty_05.problems_001_009;

// Multiples of 3 and 5
public class Problem1 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		long limit = 1000;
		int[] divisors = {3,5};
		long sum = 0;
		
		for (long i = divisors[0]; i < limit; i++) {
			for (int j = 0; j < divisors.length; j++) {
				if (i % divisors[j] == 0) {
					sum+=i;
					break;
				}
			}
		}
		
		System.out.println("Sum of all the multiples = " + sum);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
