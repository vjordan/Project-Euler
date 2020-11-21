package problems.difficulty_05.problems_040_049;

import java.util.ArrayList;

// Pentagon numbers
public class Problem44 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		ArrayList<Integer> pentagonalNumbers = new ArrayList<Integer>();
		int limit = 10000000;
		int pentagonalNumber = 0;
		int increment = -2;
		do {
			increment += 3;
			pentagonalNumber+=increment;
			pentagonalNumbers.add(pentagonalNumber);
		} while (pentagonalNumber < limit);
		
		int minimisedValue = 0;
		int indexDifference = 1;
		do {
			for (int i = indexDifference; i < pentagonalNumbers.size(); i++) {
				if (pentagonalNumbers.contains(pentagonalNumbers.get(i-indexDifference)+pentagonalNumbers.get(i))
						&& pentagonalNumbers.contains(pentagonalNumbers.get(i)-pentagonalNumbers.get(i-indexDifference))) {
					minimisedValue = pentagonalNumbers.get(i)-pentagonalNumbers.get(i-indexDifference);
					System.out.println("P(" + (pentagonalNumbers.indexOf(pentagonalNumbers.get(i-indexDifference))+1)
							+ ") + P(" + (pentagonalNumbers.indexOf(pentagonalNumbers.get(i))+1)
							+ ") = " + pentagonalNumbers.get(i-indexDifference)
							+ " + " + pentagonalNumbers.get(i)
							+ " = " + (pentagonalNumbers.get(i-indexDifference)+pentagonalNumbers.get(i))
							+ " = P(" + (pentagonalNumbers.indexOf(pentagonalNumbers.get(i-indexDifference)+pentagonalNumbers.get(i))+1) + ")"
							);
					System.out.println("P(" + (pentagonalNumbers.indexOf(pentagonalNumbers.get(i))+1)
							+ ") - P(" + (pentagonalNumbers.indexOf(pentagonalNumbers.get(i-indexDifference))+1)
							+ ") = " + pentagonalNumbers.get(i)
							+ " - " + pentagonalNumbers.get(i-indexDifference)
							+ " = " + (pentagonalNumbers.get(i)-pentagonalNumbers.get(i-indexDifference))
							+ " = P(" + (pentagonalNumbers.indexOf(pentagonalNumbers.get(i)-pentagonalNumbers.get(i-indexDifference))+1) + ")"
							);
					break;
				}
			}
			indexDifference++;
		} while (minimisedValue == 0 && indexDifference < pentagonalNumbers.size()-1);
		
		System.out.println();
		System.out.println("Value of pair of pentagonal numbers for which their sum and difference are pentagonal = " + minimisedValue);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
