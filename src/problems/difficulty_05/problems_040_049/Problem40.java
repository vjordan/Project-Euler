package problems.difficulty_05.problems_040_049;

// Champernowne's constant
public class Problem40 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int[] digitsIndex = {1,10,100,1000,10000,100000,1000000};
		
		String irrationalDecimalFraction = "";
		int number = 0;
		
		do {
			number++;
			irrationalDecimalFraction += Integer.toString(number);
		} while (irrationalDecimalFraction.length() < digitsIndex[digitsIndex.length-1]);
		
		int productDigits = 1;
		for (int i = 0; i < digitsIndex.length; i++) {
			String expectedDigit = String.valueOf(irrationalDecimalFraction.charAt(digitsIndex[i]-1));
			productDigits *= Integer.parseInt(expectedDigit);
			System.out.print(expectedDigit + " ");
		}
		System.out.println();
		
		System.out.println();
		System.out.println("Value of the expression = " + productDigits);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
