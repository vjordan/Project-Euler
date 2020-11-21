package problems.difficulty_05.problems_050_059;

// Spiral primes
public class Problem58 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int gridLength = 1;
		int numberPrimes = 0;
		do {
			gridLength += 2;
			for (int i = 0; i <= 3; i++) {
				if (isPrime(gridLength*gridLength-(i*(gridLength-1)))) {
					numberPrimes++;
				}
			}
			System.out.println(gridLength + " " + numberPrimes*100/(gridLength*2-1) + "%");
		} while (numberPrimes*100/(gridLength*2-1) >= 10);
		
		System.out.println();
		System.out.println("Side length of the square spiral for which the ratio of primes along both diagonals first falls below 10% = " + gridLength);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isPrime (int number) {

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
