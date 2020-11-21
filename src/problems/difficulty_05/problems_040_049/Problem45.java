package problems.difficulty_05.problems_040_049;

import java.util.ArrayList;

// Triangular, pentagonal, and hexagonal
public class Problem45 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		ArrayList<Integer> triangleNumbers = new ArrayList<Integer>();
		ArrayList<Integer> pentagonalNumbers = new ArrayList<Integer>();
		ArrayList<Integer> hexagonalNumbers = new ArrayList<Integer>();
		int triangleNumber = 0;
		int pentagonalNumber = 0;
		int hexagonalNumber = 0;
		int incrementTriangle = 0;
		int incrementPentagonal = -2;
		int incrementHexagonal = -3;
		int limit = 2000000000;
		
		do {
			incrementTriangle++;
			triangleNumber+=incrementTriangle;
			triangleNumbers.add(triangleNumber);
			incrementPentagonal+=3;
			pentagonalNumber+=incrementPentagonal;
			pentagonalNumbers.add(pentagonalNumber);
			incrementHexagonal+=4;
			hexagonalNumber+=incrementHexagonal;
			hexagonalNumbers.add(hexagonalNumber);
		} while (triangleNumber < limit);
		
		int numberTrianglePentagonalHexagonal = 40755;
		int index = triangleNumbers.indexOf(numberTrianglePentagonalHexagonal);
		do {
			index++;
			if (pentagonalNumbers.contains(triangleNumbers.get(index)) && hexagonalNumbers.contains(triangleNumbers.get(index))) {
				numberTrianglePentagonalHexagonal = triangleNumbers.get(index);
				System.out.println("T(" + (index+1)
						+ ") = P(" + (pentagonalNumbers.indexOf(triangleNumbers.get(index))+1)
						 + ") = H(" + (hexagonalNumbers.indexOf(triangleNumbers.get(index))+1)
						 + ") = " + triangleNumbers.get(index));
			}
		} while (numberTrianglePentagonalHexagonal == 40755 && index < triangleNumbers.size()-1);
		
		System.out.println();
		System.out.println("Next triangle number that is also pentagonal and hexagonal = " + numberTrianglePentagonalHexagonal);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
