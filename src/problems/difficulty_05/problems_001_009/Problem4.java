package problems.difficulty_05.problems_001_009;

// Largest palindrome product
public class Problem4 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		long limitA = 999;
		long limitB = 999;

		long numberA = 0;
		long numberB = 0;
		long largestPalindrome = 0;

		for (long i = 100; i <= limitA; i++) {
			for (long j = 100; j <= limitB; j++) {
				long product = i * j;
				if (isPalindrome(product) && product > largestPalindrome) {
					numberA = i;
					numberB = j;
					largestPalindrome = product;
					System.out.println(numberA + "*" + numberB + "=" + product);
				}
			}
		}

		System.out.println();
		System.out.println(numberA + " * " + numberB + " = " + largestPalindrome);
		System.out.println("Largest palindrome = " + largestPalindrome);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static boolean isPalindrome (long number) {

		boolean isPalindrome = true;

		String numberString = Long.toString(number);

		for (int i = 0; i < numberString.length()/2; i++) {
			if (numberString.charAt(i) != numberString.charAt(numberString.length()-(1+i))) {
				isPalindrome = false;
				break;
			}
		}

		return isPalindrome;
	}

}
