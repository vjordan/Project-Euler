package problems.difficulty_05.problems_030_039;


//Pandigital multiples
public class Problem39 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 1000;
		int maximisedNumberSolutions = 0;
		int bestValue = 0;

		for (int i = 3; i <= limit; i++) {
			int numberSolutions = calculateNumberSolutionsRightAngleTriangle(i);
			if (numberSolutions > maximisedNumberSolutions) {
				maximisedNumberSolutions = numberSolutions;
				bestValue = i;
				System.out.println(i + " " + numberSolutions);
			}
		}

		System.out.println();
		System.out.println("Value for which the number of solutions is maximised = " + bestValue);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static int calculateNumberSolutionsRightAngleTriangle (int number) {

		int numberSolutions = 0;

		for (int i = 1; i <= number/3; i++) {
			for (int j = i; j <= (number-i)/2; j++) {
				int k = number-(i+j);
				if (i*i + j*j == k*k) {
					numberSolutions++;
				}
			}
		}

		return numberSolutions;
	}

}

