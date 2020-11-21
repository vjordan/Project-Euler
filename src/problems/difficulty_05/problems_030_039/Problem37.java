package problems.difficulty_05.problems_030_039;

//Truncatable primes
public class Problem37 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int expectedLimit = 11;
		int foundTruncatablePrimes = 0;

		int sumTruncatablePrimes = 0;

		int number = 9;
		do {
			number++;
			boolean isTruncatedPrime = false;
			String numberString = Integer.toString(number);
			String numberLeftToRight = "";
			String numberRightToLeft = "";
			for (int i = 0; i < numberString.length(); i++) {
				if (i == numberString.length()-1 && isPrime(number)) {
					isTruncatedPrime = true;
				} else {
					numberLeftToRight += Character.toString(numberString.charAt(i));
					numberRightToLeft += Character.toString(numberString.charAt(numberString.length()-(1+i)));
					if (!isPrime(Integer.parseInt(numberLeftToRight)) || !isPrime(Integer.parseInt(new StringBuilder(numberRightToLeft).reverse().toString()))) {
						break;
					}
				}
			}
			if (isTruncatedPrime) {
				foundTruncatablePrimes++;
				sumTruncatablePrimes += number;
				System.out.println(number);
			}
		} while (foundTruncatablePrimes < expectedLimit);

		System.out.println();
		System.out.println("Sum of truncatable primes = " + sumTruncatablePrimes);

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
