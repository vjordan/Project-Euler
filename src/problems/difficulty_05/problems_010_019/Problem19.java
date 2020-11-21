package problems.difficulty_05.problems_010_019;

// Counting Sundays
public class Problem19 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int startYear = 1901;
		int numberOfYears = 100;

		int numberOfMonthsPerYear = 12;
		int numberOfDaysInMonth = 0;
		long sumOfDays = 0;

		int numberOfSundaysOnFirstOfMonth = 0;

		for (int i = 0; i <= numberOfYears; i++) {
			for (int j = 0; j < numberOfMonthsPerYear; j++) {
				if (j == 1) {
					if ((i+(startYear-1)) % 4 == 0) {
						if ((i+(startYear-1)) % 100 == 0 && (i+(startYear-1)) % 400 != 0) {
							numberOfDaysInMonth = 28;
						} else {
							numberOfDaysInMonth = 29;
						}
					} else {
						numberOfDaysInMonth = 28;
					}
				} else if (j == 3 || j == 5 || j == 8 || j == 10) {
					numberOfDaysInMonth = 30;
				} else {
					numberOfDaysInMonth = 31;
				}

				sumOfDays+=numberOfDaysInMonth;
				if (i > 0 && (sumOfDays-(numberOfDaysInMonth-1)) % 7 == 0) {
					numberOfSundaysOnFirstOfMonth++;
					if (j < 9) {
						System.out.print("0");
					}
					System.out.println(j+1 + "/" + (i+(startYear-1)));
				}
			}
		}

		System.out.println();
		System.out.println("Number of Sundays which fell on the first of the month = " + numberOfSundaysOnFirstOfMonth);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
