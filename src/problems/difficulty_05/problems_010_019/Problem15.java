package problems.difficulty_05.problems_010_019;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Random;

import utils.Fraction;

// Lattice paths
public class Problem15 {

	public static void main(String[] args) throws FileNotFoundException {
		
		long startTime = System.currentTimeMillis();
		
		int gridLength = 20;
		
		Fraction[] numberOfRoutes = new Fraction[gridLength];
		numberOfRoutes[0] = new Fraction(2,1);
		numberOfRoutes[1] = new Fraction(6,1);
		numberOfRoutes[2] = new Fraction(20,1);
		for (int i = 0; i < 3; i++) {
			System.out.println(i+1 + " " + numberOfRoutes[i].getNumerator());
		}
		
		Fraction[] divisionResults = new Fraction[gridLength-1];
		divisionResults[0] = numberOfRoutes[1].divide(numberOfRoutes[0]);
		divisionResults[1] = numberOfRoutes[2].divide(numberOfRoutes[1]);
		
		Fraction[] subtractionResults = new Fraction[gridLength-2];
		subtractionResults[0] = divisionResults[1].subtract(divisionResults[0]);
		
		Fraction[] fractions = new Fraction[gridLength-3];
		fractions[0] = new Fraction(2,1);
		if (gridLength > 4) {
			fractions[1] = new Fraction(5,3);
		}
		
		for (int i = 3; i < gridLength; i++) {
			subtractionResults[i-2] = subtractionResults[i-3].divide(fractions[i-3]);
			divisionResults[i-1] = divisionResults[i-2].add(subtractionResults[i-2]);
			numberOfRoutes[i] = numberOfRoutes[i-1].multiply(divisionResults[i-1]);
			System.out.println(i+1 + " " + numberOfRoutes[i].getNumerator());
			if (i-1 < gridLength-3) {
				if ((i-1) % 2 == 0) {
					fractions[i-1] = new Fraction(fractions[i-3].getNumerator()+1, fractions[i-3].getDenominator()+1);
				} else {
					fractions[i-1] = new Fraction(fractions[i-3].getNumerator()+2, fractions[i-3].getDenominator()+2);
				}
			}
		}
		
		System.out.println();
		System.out.println("Number of routes = " + numberOfRoutes[gridLength-1].getNumerator());

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
		
		
		
		/*System.setOut(new PrintStream(new File("src/logs/Problem15_2")));
		
		int[][] grid = new int[gridLength+1][gridLength+1];
		
		int number = 99;
		for (int i = 0; i <= gridLength; i++) {
			for (int j = 0; j <= gridLength; j++) {
				number++;
				grid[i][j] = number;
			}
		}
		
		long attempts = 0;
		ArrayList<String> routes = new ArrayList<String>();
		Random random = new Random();
		
		String route = "";
		int row = 0;
		int column = 0;
		
		do {
			if (row < gridLength && column < gridLength) {
				if (row == 0 && column == 0) {
					route += Integer.toString(grid[row][column]);
				}
				
				if (random.nextInt(2) == 0) {
					row++;
				} else {
					column++;
				}
				route += Integer.toString(grid[row][column]);
			}
			else {
				if (row == gridLength) {
					for (int i = column+1; i <= gridLength;i++) {
						route += Integer.toString(grid[row][i]);
					}
				} else {
					for (int i = row+1; i <= gridLength;i++) {
						route += Integer.toString(grid[i][column]);
					}
				}
				
				attempts++;
				
				boolean exist = false;
				for (int i = 0; i < routes.size(); i++) {
					if (route.equals(routes.get(i))) {
						exist = true;
						break;
					}
				}
				if (!exist) {
					routes.add(route);
					System.out.println(routes.size() + " " + attempts);
					System.out.println();
					showRoute(grid, gridLength, route);
				}
				
				route = "";
				row = 0;
				column = 0;
			}
		} while (routes.size() < numberOfRoutes[gridLength-1].getNumerator());*/
	}
	
	/*public static void showRoute(int[][] grid, int gridLength, String route) {
		
		int indexRoute = 0;
		
		for (int i = 0; i <= gridLength; i++) {
			for (int j = 0; j <= gridLength; j++) {
				if (Integer.toString(grid[i][j]).equals(route.substring(indexRoute, indexRoute+3))) {
					System.out.print("# ");
					indexRoute += 3;
				} else {
					System.out.print("  ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}*/
	
	/*public static long numberOfRoutes (int gridLength, int row, int column) {
		
		if (row == gridLength && column == gridLength) {
			return 1;
		}
		if (row == gridLength) {
			return numberOfRoutes(gridLength, row, column+1);
		}
		if (column == gridLength) {
			return numberOfRoutes(gridLength, row+1, column);
		}
		return numberOfRoutes(gridLength, row+1, column)+numberOfRoutes(gridLength, row, column+1);
	}*/

}
