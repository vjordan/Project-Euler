package problems.difficulty_05.problems_020_029;

// Number spiral diagonals
public class Problem28 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int gridLength = 1001;
		int[][] grid = gridBuilding(gridLength);

		long sumNumbersDiagonals = -1;
		for (int i = 0; i < gridLength; i++) {
			sumNumbersDiagonals+=grid[i][i]+grid[i][gridLength-(1+i)];
		}

		System.out.println("Sum of the numbers on the diagonals = " + sumNumbersDiagonals);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static int[][] gridBuilding (int gridLength) {

		int[][] grid = new int[gridLength][gridLength];

		for (int i = 0; i < gridLength; i++) {
			for (int j = 0; j < gridLength; j++) {
				grid[i][j] = 0;
			}
		}

		int row = gridLength/2;
		int column = gridLength/2;
		int number = 1;
		grid[row][column] = number;
		char direction = 'R';
		column++;

		do {		
			number++;
			grid[row][column] = number;
			switch (direction) {
			case 'R' :
				if (grid[row+1][column] == 0) {
					direction = 'D';
					row++;
				} else {
					column++;
				}
				break;
			case 'L' :
				if (grid[row-1][column] == 0) {
					direction = 'U';
					row--;
				} else {
					column--;
				}
				break;
			case 'U' :
				if (grid[row][column+1] == 0) {
					direction = 'R';
					column++;
				} else {
					row--;
				}
				break;
			case 'D' :
				if (grid[row][column-1] == 0) {
					direction = 'L';
					column--;
				} else {
					row++;
				}
				break;
			}
		} while (grid[0][gridLength-1] == 0);

		return grid;
	}

}
