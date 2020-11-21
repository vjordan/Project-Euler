package problems.difficulty_05.problems_060_069;

import java.math.BigInteger;

// Powerful digit counts
public class Problem63 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int numberIntegers = 0;
		
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j < 30; j++) {
				if(new BigInteger(Integer.toString(i)).pow(j).toString().length() == j) {
					numberIntegers++;
					System.out.println(i + "^(" + j + ") = " + new BigInteger(Integer.toString(i)).pow(j));
				}
			}
		}
		
		System.out.println();
		System.out.println("Number of positive integers which are also a power = " + numberIntegers);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
