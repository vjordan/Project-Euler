package problems.difficulty_05.problems_001_009;

// Largest prime factor
public class Problem3 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		long number = 600851475143L;
		long largestPrimeFactor = 1;
		
		if (number % 2 == 0) {
			largestPrimeFactor = 2;
			System.out.println(largestPrimeFactor);
		}
		
		for (long i = 3; i <= Math.sqrt(number); i = i+2) {
			if (number % i == 0 && isPrimeFactor(i) && i > largestPrimeFactor) {
				largestPrimeFactor = i;
				System.out.println(largestPrimeFactor);
			}
		}
		
		if (largestPrimeFactor == 1) {
			largestPrimeFactor = number;
			System.out.println(largestPrimeFactor);
		}
		
		System.out.println();
		System.out.println("Largest prime factor = " + largestPrimeFactor);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isPrimeFactor(long factor) {
		
		boolean isPrimeFactor = true;
		
		for (long i = 3; i <= Math.sqrt(factor); i=i+2) {
			if (factor % i == 0) {
				isPrimeFactor = false;
				break;
			}
		}
		
		return isPrimeFactor;
	}

}
