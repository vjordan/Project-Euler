package problems.difficulty_05.problems_060_069;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

// Maximum path sum II
public class Problem67 {

	public static void main(String[] args) throws Exception {

		//long startTime = System.currentTimeMillis();
		
		int[][] triangle = triangleBuilding();	
		showTriangle(triangle);

		int sumOfBestRoute = 0;
		Random random = new Random();
		do {
			int[] positionsRoute = new int[triangle.length];
			positionsRoute[0] = 0;
			int sumOfRoute = triangle[0][positionsRoute[0]];
			for (int i = 1; i < triangle.length; i++) {
				positionsRoute[i] = positionsRoute[i-1]+random.nextInt(2);
				sumOfRoute += triangle[i][positionsRoute[i]];
			}
			if (sumOfRoute > sumOfBestRoute) {
				sumOfBestRoute = sumOfRoute;
				System.out.println(sumOfBestRoute);
			}
		} while (true);

		/*System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");*/
	}

	public static int[][] triangleBuilding () throws Exception {

		ArrayList<String> triangleLines = new ArrayList<String>();
		String filename = "src/utils/Problem67.txt";

		BufferedReader fileReader = new BufferedReader(new FileReader(filename));
		String line;
		while ((line = fileReader.readLine()) != null) {
			triangleLines.add(line);
		}
		fileReader.close();

		int[][] triangle = new int[triangleLines.size()][triangleLines.size()];

		for (int i = 0; i < triangleLines.size(); i++) {
			String[] numbersInLine = triangleLines.get(i).split(" ");
			for (int j = 0; j < triangleLines.size(); j++) {
				if (j < numbersInLine.length) {
					triangle[i][j] = Integer.parseInt(numbersInLine[j]);
				} else {
					triangle[i][j] = 0;
				}
			}
		}

		return triangle;
	}

	public static void showTriangle (int[][] triangle) {

		for (int i = 0; i < triangle.length; i++) {
			for (int j = 0; j < triangle.length-(i+1); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < triangle.length; j++) {
				if (triangle[i][j] != 0) {
					if (triangle[i][j] < 10) {
						System.out.print("0");
					}
					System.out.print(triangle[i][j] + " ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
}
