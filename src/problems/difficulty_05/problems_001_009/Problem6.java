package problems.difficulty_05.problems_001_009;

// Sum square difference
public class Problem6 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		long limit = 100;
		long sumOfNumbers = 0;
		long sumOfSquares = 0;
		
		for (long i = 1; i <= limit; i++) {
			sumOfNumbers+=i;
			sumOfSquares+=i*i;
		}
		
		long difference = sumOfNumbers*sumOfNumbers-sumOfSquares;
		
		System.out.println(sumOfNumbers + " * " + sumOfNumbers + " - " + sumOfSquares + " = " + difference);
		System.out.println("Difference between the sum of the squares and the square of the sum = " + difference);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
