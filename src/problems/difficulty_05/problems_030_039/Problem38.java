package problems.difficulty_05.problems_030_039;

// Pandigital multiples
public class Problem38 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();
		
		int largestPandigital = 0;

		for (int i = 1; i < 10000; i++) {
			int multiplier = 0;
			String concatenatedProducts = "";
			boolean stopChecking = false;
			do {
				multiplier++;
				String product = Integer.toString(i*multiplier);
				if (product.contains("0")
						|| product.length()+concatenatedProducts.length() > 9
						|| !hasDifferentDigitsInsideOneNumber(product)
						|| !hasDifferentDigitsBetweenTwoNumbers(product, concatenatedProducts)) {
					stopChecking = true;
				} else {
					concatenatedProducts += product;
					if (concatenatedProducts.length() == 9) {
						stopChecking = true;
						System.out.println(i + " * (" + multiplier + ") = " + concatenatedProducts);
						if (Integer.parseInt(concatenatedProducts) > largestPandigital) {
							largestPandigital = Integer.parseInt(concatenatedProducts);
						}
					}
				}
			} while (!stopChecking);
		}
		
		System.out.println();
		System.out.println("Largest pandigital number that can be formed as the concatenated product = " + largestPandigital);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
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
