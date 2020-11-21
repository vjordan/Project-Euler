package problems.difficulty_05.problems_010_019;

import java.util.ArrayList;
import java.util.Random;

// Maximum path sum I
public class Problem18 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int triangleHeight = 15;
		long expectedNumberOfRoutes = (long) Math.pow(2, triangleHeight-1);

		int[][] triangle = triangleBuilding(triangleHeight);

		long sumOfBestRoute = 0;
		int[] positionsOfBestRoute = new int[triangleHeight];
		long numberOfCheckedRoutes = 0;
		ArrayList<String> checkedRoutes = new ArrayList<String>();

		Random random = new Random();
		do {
			int[] positionsRoute = new int[triangleHeight];
			String route = "";
			boolean isAlreadyChecked = false;

			positionsRoute[0] = 0;
			route+=Integer.toString(positionsRoute[0]);
			for (int i = 1; i < triangleHeight; i++) {
				positionsRoute[i] = positionsRoute[i-1]+random.nextInt(2);
				route+=Integer.toString(positionsRoute[i]);
			}

			for (int i = 0; i < checkedRoutes.size(); i++) {
				if (route.equals(checkedRoutes.get(i))) {
					isAlreadyChecked = true;
					break;
				}
			}
			if (!isAlreadyChecked) {
				numberOfCheckedRoutes++;
				checkedRoutes.add(route);
				long sumOfRoute = calculateRoute(triangleHeight, triangle, positionsRoute);
				if (sumOfRoute > sumOfBestRoute) {
					sumOfBestRoute = sumOfRoute;
					positionsOfBestRoute = positionsRoute;
				}
			}
		} while (numberOfCheckedRoutes < expectedNumberOfRoutes);

		System.out.println("Best route =");
		showBestTriangle(triangleHeight, triangle, positionsOfBestRoute);
		System.out.println("Maximum total = " + sumOfBestRoute);
		// System.out.println("Maximum total = " + sumOfBestRoute(triangleHeight, triangle, 0, 0));

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static int[][] triangleBuilding (int triangleHeight) {

		String[] triangleLines = new String[triangleHeight];

		triangleLines[0] = "75";
		triangleLines[1] = "95 64";
		triangleLines[2] = "17 47 82";
		triangleLines[3] = "18 35 87 10";
		triangleLines[4] = "20 04 82 47 65";
		triangleLines[5] = "19 01 23 75 03 34";
		triangleLines[6] = "88 02 77 73 07 63 67";
		triangleLines[7] = "99 65 04 28 06 16 70 92";
		triangleLines[8] = "41 41 26 56 83 40 80 70 33";
		triangleLines[9] = "41 48 72 33 47 32 37 16 94 29";
		triangleLines[10] = "53 71 44 65 25 43 91 52 97 51 14";
		triangleLines[11] = "70 11 33 28 77 73 17 78 39 68 17 57";
		triangleLines[12] = "91 71 52 38 17 14 91 43 58 50 27 29 48";
		triangleLines[13] = "63 66 04 68 89 53 67 30 73 16 69 87 40 31";
		triangleLines[14] = "04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

		int[][] triangle = new int[triangleHeight][triangleHeight];

		for (int i = 0; i < triangleHeight; i++) {
			String[] numbersInLine = triangleLines[i].split(" ");
			for (int j = 0; j < triangleHeight; j++) {
				if (j < numbersInLine.length) {
					triangle[i][j] = Integer.parseInt(numbersInLine[j]);
				} else {
					triangle[i][j] = 0;
				}
			}
		}

		return triangle;
	}

	public static long calculateRoute (int triangleHeight, int[][] triangle, int[] positions) {

		long sumOfRoute = 0;

		for (int i = 0; i < triangleHeight; i++) {
			for (int j = 0; j < triangleHeight; j++) {
				if (j == positions[i]) {
					sumOfRoute+=triangle[i][j];
				}
			}
		}

		return sumOfRoute;
	}
	
	public static void showBestTriangle (int triangleHeight, int[][] triangle, int[] positions) {

		for (int i = 0; i < triangleHeight; i++) {
			for (int j = 0; j < triangleHeight-(i+1); j++) {
				System.out.print(" ");
			}
			for (int j = 0; j < triangleHeight; j++) {
				if (j == positions[i]) {
					if (triangle[i][j] < 10) {
						System.out.print("0");
					}
					System.out.print(triangle[i][j] + " ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	/*public static int sumOfBestRoute (int triangleHeight, int[][] triangle, int row, int column) {
		
		if (row == triangleHeight-1) {
			return triangle[row][column];
		} else {
			return triangle[row][column]+Math.max(sumOfBestRoute(triangleHeight, triangle, row+1, column), sumOfBestRoute(triangleHeight, triangle, row+1, column+1));
		}
	}*/

}
