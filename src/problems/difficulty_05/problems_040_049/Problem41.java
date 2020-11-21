package problems.difficulty_05.problems_040_049;

//Pandigital prime
public class Problem41 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int number = 987654322;
		int largestPandigitalPrime = 0;

		do {
			number--;
			if (isPandigital(Integer.toString(number)) && isPrime(number)) {
				largestPandigitalPrime = number;
			}
		} while (largestPandigitalPrime == 0);

		System.out.println("Largest pandigital prime = " + largestPandigitalPrime);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static boolean isPandigital (String number) {

		String[] digits = {"1","2","3","4","5","6","7","8","9"};
		for (int i = 0; i < number.length(); i++) {
			if (!number.contains(digits[i])) {
				return false;
			}
		}
		return true;
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
