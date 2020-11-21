package problems.difficulty_05.problems_001_009;

// Even Fibonacci numbers
public class Problem2 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		long limit = 4000000;
		
		boolean finishedSequence = false;
		long valueA = 1;
		long valueB = 2;
		long sumEvenValued = valueB;
		
		do {
			long sumValues = valueA + valueB;
			valueA = valueB;
			valueB = sumValues;
			if (sumValues <= limit) {
				if (sumValues % 2 == 0) {
					sumEvenValued+=sumValues;
					System.out.println(sumValues);
				}
			} else {
				finishedSequence = true;
			}
		} while (!finishedSequence);
		
		System.out.println();
		System.out.println("Sum of the even-valued terms = " + sumEvenValued);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
