package problems.difficulty_05.problems_030_039;

// Digit factorials
public class Problem34 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int[] factorials = factorialsNumbersUnder10();
		int sumNumbers = 0;
		
		int number = 2;
		long startTimeLoop = System.currentTimeMillis();
		do {
			number++;
			int sumFactorials = 0;
			for (int i = 0; i < Integer.toString(number).length(); i++) {
				sumFactorials += factorials[Integer.parseInt(String.valueOf(Integer.toString(number).charAt(i)))];
				if (sumFactorials > number) {
					break;
				}
			}
			if (sumFactorials == number) {
				startTimeLoop = System.currentTimeMillis();
				sumNumbers += number;
				System.out.println(number);
			}
		} while (System.currentTimeMillis()-startTimeLoop < 5000);
		
		System.out.println();
		System.out.println("Sum of all numbers which are equal to the sum of the factorial of their digits = " + sumNumbers);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static int[] factorialsNumbersUnder10 () {
		
		int[] factorials = new int[10];
		factorials[0] = 1;
		
		int productNumbers = 1;
		for (int i = 1; i < 10; i++) {
			productNumbers *= i;
			factorials[i] = productNumbers;
		}
		
		return factorials;
	}

}
