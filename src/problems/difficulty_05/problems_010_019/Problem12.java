package problems.difficulty_05.problems_010_019;

// Highly divisible triangular number
public class Problem12 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		long limit = 500;
		long indexLoop = 0;
		long triangleNumber = 0;
		
		do {
			indexLoop++;
			triangleNumber+=indexLoop;
		} while (numberOfFactors(triangleNumber, limit) <= limit);
		
		System.out.println("Triangle number = " + triangleNumber);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static long numberOfFactors(long number, long limit) {
		
		long numberOfDivisors = 0;
		
		for (long i = 1; i <= Math.sqrt(number); i++) {
			if (number % i == 0) {
				numberOfDivisors+=2;
			}
		}
		if (number % Math.sqrt(number) == 0) {
			numberOfDivisors--;
		}
		
		return numberOfDivisors;
	}

}
