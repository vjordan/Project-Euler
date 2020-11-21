package problems.difficulty_05.problems_600_699;

// Inverse Digit Sum
public class Problem684 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int start = 2;
		int end = 90;
		
		long[] fibonacciSequence = calculateFibonacciSequence(end);
		
		long sum = 0;
		for (int i = start; i <= end; i++) {
			long smallestSum = calculateSmallestSum(fibonacciSequence[i]);
			sum += smallestSum;
			System.out.println(fibonacciSequence[i] + " " + smallestSum);
		}
		
		System.out.println();
		System.out.println("Sum = " + sum);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static long calculateSmallestNumberDigitSum (long number) {
		
		long numberDigitSum = 0;
		
		boolean found = false;
		do {
			numberDigitSum++;
			String numberString = Long.toString(numberDigitSum);
			long digitSum = 0;
			for (int i = 0; i < numberString.length(); i++) {
				digitSum += Integer.parseInt(Character.toString(numberString.charAt(i)));
				if (digitSum > number) {
					break;
				}
			}
			if (digitSum == number) {
				found = true;
			}
		} while (!found);
		
		return numberDigitSum;
	}
	
	public static long calculateSmallestSum (long limit) {
		
		long sum = 0;
		
		for (long i = 1; i <= limit; i++) {
			sum += calculateSmallestNumberDigitSum(i);
		}
		
		return sum;
	}
	
	public static long[] calculateFibonacciSequence (int limit) {
		
		long[] fibonacciSequence = new long[limit+1];
		
		long numberA = 0;
		long numberB = 1;
		fibonacciSequence[0] = numberA;
		fibonacciSequence[1] = numberB;
		for (int i = 2; i <= limit; i++) {
			long temp = numberA;
			numberA = numberB;
			numberB += temp;
			fibonacciSequence[i] = numberB;
		}
		
		return fibonacciSequence;
	}

}
