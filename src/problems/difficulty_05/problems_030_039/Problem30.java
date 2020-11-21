package problems.difficulty_05.problems_030_039;

// Digit fifth powers
public class Problem30 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int power = 5;
		int sumNumbers = 0;
		
		int number = 10;
		long startTimeLoop = System.currentTimeMillis();
		do {
			if (isValid(number, power)) {
				startTimeLoop = System.currentTimeMillis();
				sumNumbers += number;
				System.out.println(number);
			}
			number++;
		} while (System.currentTimeMillis()-startTimeLoop < 5000);
		
		System.out.println();
		System.out.println("Sum of all the numbers that can be written as the sum of same powers of their digits = " + sumNumbers);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isValid (int number, int power) {
		
		String numberString = Integer.toString(number);
		
		int sumfifthPowersDigits = 0;
		for (int i = 0; i < numberString.length(); i++) {
			sumfifthPowersDigits += Math.pow(Integer.parseInt(String.valueOf(numberString.charAt(i))), power);
		}
		
		return number == sumfifthPowersDigits;
	}

}
