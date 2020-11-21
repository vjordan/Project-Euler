package problems.difficulty_05.problems_030_039;

// Double-base palindromes
public class Problem36 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		long limit = 1000000;
		long sumPalindromicNumbers = 0;
		
		for (long i = 1; i < limit; i++) {
			String numberBase2 = Long.toString(i, 2);
			if (i % 10 != 0 && numberBase2.charAt(0) != '0' && numberBase2.charAt(numberBase2.length()-1) != '0'
					&& isPalindrome(Long.toString(i)) && isPalindrome(numberBase2)) {
				sumPalindromicNumbers += i;
				System.out.println(i + " " + numberBase2);
			}
		}
		
		System.out.println();
		System.out.println("Sum of all numbers which are palindromic in bases = " + sumPalindromicNumbers);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isPalindrome (String number) {

		for (int i = 0; i < number.length()/2; i++) {
			if (number.charAt(i) != number.charAt(number.length()-(1+i))) {
				return false;
			}
		}
		return true;
	}

}
