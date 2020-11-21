package problems.difficulty_05.problems_020_029;

import java.math.BigInteger;
import java.util.ArrayList;

// Distinct powers
public class Problem29 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int limit = 100;
		
		ArrayList<BigInteger> listTerms = new ArrayList<BigInteger>();
		for (int i = 2; i <= limit; i++) {
			for (int j = 2; j <= limit; j++) {
				BigInteger power = new BigInteger(Integer.toString(i)).pow(j);
				if (!listTerms.contains(power)) {
					listTerms.add(power);
				}
			}
		}
		
		System.out.println("Number of distinct terms in the sequence = " + listTerms.size());
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
