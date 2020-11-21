package problems.difficulty_05.problems_010_019;

// Longest Collatz sequence
public class Problem14 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		long limit = 1000000;
		long longestChain = 1;
		long startingNumber = 1;
		
		for (long i = 2; i < limit; i++) {
			long chainLength = 1;
			long term = i;
			do {
				chainLength++;
				if (term % 2 == 0) {
					term /= 2;
				} else {
					term = term*3+1;
				}
			} while (term != 1);
			if (chainLength > longestChain) {
				startingNumber = i;
				longestChain = chainLength;
				System.out.println(startingNumber + " " + longestChain);
			}
		}
		
		System.out.println();
		System.out.println("Starting number which produces the longest chain = " + startingNumber);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
