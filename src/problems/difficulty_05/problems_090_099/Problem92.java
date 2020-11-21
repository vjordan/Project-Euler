package problems.difficulty_05.problems_090_099;

// Square digit chains
public class Problem92 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int limit = 10000000;
		int numberStartingNumbers = 0;
		
		for (int i = 1; i < limit; i++) {
			int sumSquareDigits = calculateSumSquareDigits(i);
			while (sumSquareDigits != 1 && sumSquareDigits != 89) {
				sumSquareDigits = calculateSumSquareDigits(sumSquareDigits);
			}
			if (sumSquareDigits == 89) {
				numberStartingNumbers++;
			}
		}
		
		System.out.println("Number of starting numbers which will arrive at 89 = " + numberStartingNumbers);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static int calculateSumSquareDigits (long number) {
		
		int sumSquareDigits = 0;
		
		String numberString = Long.toString(number);
		for (int i = 0; i < numberString.length(); i++) {
			int integerDigit = Integer.parseInt(Character.toString(numberString.charAt(i)));
			sumSquareDigits += integerDigit*integerDigit;
		}
		
		return sumSquareDigits;
	}

}
