package problems.difficulty_05.problems_030_039;

import java.util.ArrayList;

//Pandigital products
public class Problem32 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		ArrayList<Integer> numbers = numbersBuilding();

		ArrayList<Integer> products = new ArrayList<Integer>();
		long sumProducts = 0;

		for (int i = 0; i < numbers.size()-1; i++) {
			for (int j = i+1; j < numbers.size(); j++) {
				int multiplicand = numbers.get(i);
				int multiplier = numbers.get(j);
				if (((multiplicand < 10 && multiplier >= 1000) || (multiplicand >= 10 && multiplicand < 100 && multiplier >= 100 && multiplier < 1000))
						&& hasDifferentDigitsBetweenTwoNumbers(Integer.toString(multiplicand), Integer.toString(multiplier))
						) {
					int product = multiplicand*multiplier;
					if (!products.contains(product)
							&& !Integer.toString(product).contains("0")
							&& Integer.toString(product).length() == 9-Integer.toString(multiplicand).length()-Integer.toString(multiplier).length()
							&& hasDifferentDigitsInsideOneNumber(Integer.toString(product))
							&& hasDifferentDigitsBetweenTwoNumbers(Integer.toString(multiplicand)+Integer.toString(multiplier), Integer.toString(product))
							) {
						products.add(product);
						sumProducts += product;
						System.out.println(multiplicand + "*" + multiplier + "=" + product);
					}
				}
			}
		}

		System.out.println();
		System.out.println("Sum of all products whose calculation identity can be written as a pandigital = " + sumProducts);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static ArrayList<Integer> numbersBuilding() {

		ArrayList<Integer> listNumbers = new ArrayList<Integer>();

		for (int i = 1; i < 10000; i++) {
			boolean isValid = Integer.toString(i).contains("0") ? false : hasDifferentDigitsInsideOneNumber(Integer.toString(i));
			if (isValid) {
				listNumbers.add(i);
			}
		}

		return listNumbers;
	}

	public static boolean hasDifferentDigitsInsideOneNumber (String number) {

		for (int i = 0; i < number.length()-1; i++) {
			if (number.substring(i+1).contains(Character.toString(number.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

	public static boolean hasDifferentDigitsBetweenTwoNumbers (String numberA, String numberB) {

		for (int i = 0; i < numberA.length(); i++) {
			if (numberB.contains(Character.toString(numberA.charAt(i)))) {
				return false;
			}
		}
		return true;
	}

}
