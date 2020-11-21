package problems.difficulty_05.problems_010_019;

// Summation of primes
public class Problem10 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		long limit = 2000000;
		long sumPrimesBelowLimit = 2;

		for (long i = 3; i <= limit; i = i+2) {
			if (isPrimeFactor(i)) {
				sumPrimesBelowLimit += i;
			}
		}

		System.out.println("Sum of all the primes = " + sumPrimesBelowLimit);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isPrimeFactor (long number) {
		
		boolean isPrimeFactor = true;
		
		for (long i = 3; i <= Math.sqrt(number); i=i+2) {
			if (number % i == 0) {
				isPrimeFactor = false;
				break;
			}
		}
		
		return isPrimeFactor;
	}

}