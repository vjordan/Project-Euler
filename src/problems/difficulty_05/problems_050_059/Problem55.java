package problems.difficulty_05.problems_050_059;

import java.math.BigInteger;

// Lychrel numbers
public class Problem55 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 10000;
		int lychrelNumbers = 0;
		
		for (int i = 1; i < limit; i++) {
			BigInteger number = new BigInteger(Integer.toString(i)).add(new BigInteger(reverse(new BigInteger(Integer.toString(i)))));
			int index = 1;
			while (index < 50 && !isPalindrome(number)) {
				number = number.add(new BigInteger(reverse(number)));
				index++;
			}
			if (index == 50) {
				lychrelNumbers++;
				System.out.println(i);
			}
		}
		
		System.out.println();
		System.out.println("Number of Lychrel numbers = " + lychrelNumbers);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static String reverse (BigInteger number) {
		
		String numberString = number.toString();
		String reversedNumber = "";
		for (int i = numberString.length()-1; i >= 0; i--) {
			reversedNumber += numberString.charAt(i);
		}
		return reversedNumber;
	}
	
	public static boolean isPalindrome (BigInteger number) {

		String numberString = number.toString();
		for (int i = 0; i < numberString.length()/2; i++) {
			if (numberString.charAt(i) != numberString.charAt(numberString.length()-(1+i))) {
				return false;
			}
		}
		return true;
	}
}
