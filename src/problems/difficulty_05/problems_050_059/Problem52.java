package problems.difficulty_05.problems_050_059;

// Permuted multiples
public class Problem52 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int number = 0;
		int smallestPositiveInteger = 0;
		do {
			number++;
			if (Integer.toString(number).length() == Integer.toString(number*6).length()
					&& checkSameDigits(Integer.toString(number), Integer.toString(number*2),Integer.toString(number*3),
					Integer.toString(number*4), Integer.toString(number*5), Integer.toString(number*6))) {
				smallestPositiveInteger = number;
				System.out.println(number + " * 1 = " + (number));
				System.out.println(number + " * 2 = " + (number*2));
				System.out.println(number + " * 3 = " + (number*3));
				System.out.println(number + " * 4 = " + (number*4));
				System.out.println(number + " * 5 = " + (number*5));
				System.out.println(number + " * 6 = " + (number*6));
			}
		} while (smallestPositiveInteger == 0);
		
		System.out.println();
		System.out.println("Smallest positive integer which contains the same digits in the calculations = " + smallestPositiveInteger);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static boolean checkSameDigits (String x1, String x2, String x3, String x4, String x5, String x6) {
		
		String[] numbers = {x1, x2, x3, x4, x5, x6};
		for (int i = 1; i < numbers.length; i++) {
			String number = x1;
			for (int j = 0; j < numbers[i].length(); j++) {
				if (!number.contains(Character.toString(numbers[i].charAt(j)))) {
					return false;
				}
				number = number.replaceFirst(Character.toString(numbers[i].charAt(j)), "");
			}
		}
		return true;
	}

}
