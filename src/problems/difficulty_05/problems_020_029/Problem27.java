package problems.difficulty_05.problems_020_029;

// Quadratic primes
public class Problem27 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 1000;

		int maximumNumberOfPrimes = 0;
		long productCoefficients = 0;

		for (int i = -limit+1; i < limit; i++) {
			for (int j = 2; j <= limit; j++) {
				int number = 0;
				long formulaResult = j;
				while (isPrime(formulaResult)) {
					number++;
					formulaResult = number*number + number*i + j;
				}
				if (number > maximumNumberOfPrimes) {
					maximumNumberOfPrimes = number;
					productCoefficients = i*j;
					System.out.println(i + " " + j + " " + maximumNumberOfPrimes);
				}
			}
		}

		System.out.println();
		System.out.println("Product of the coefficients for the quadratic expression that produces the maximum number of primes for consecutives values = " + productCoefficients);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static boolean isPrime (long number) {

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

