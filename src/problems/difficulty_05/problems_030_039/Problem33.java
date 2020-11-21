package problems.difficulty_05.problems_030_039;

//Digit cancelling fractions
public class Problem33 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int numeratorProductNonTrivialFractions = 1;
		int denominatorProductNonTrivialFractions = 1;

		for (int i = 10; i < 99; i++) {
			for (int j = i+1; j < 100; j++) {
				int firstNumberNumerator = Integer.parseInt(String.valueOf(Integer.toString(i).charAt(0)));
				int secondNumberNumerator = Integer.parseInt(String.valueOf(Integer.toString(i).charAt(1)));
				int firstNumberDenominator = Integer.parseInt(String.valueOf(Integer.toString(j).charAt(0)));
				int secondNumberDenominator = Integer.parseInt(String.valueOf(Integer.toString(j).charAt(1)));

				if (secondNumberDenominator != 0 && firstNumberNumerator == firstNumberDenominator) {
					if ((double)i/j == (double)secondNumberNumerator/secondNumberDenominator) {
						numeratorProductNonTrivialFractions *= i;
						denominatorProductNonTrivialFractions *= j;
						System.out.println(i + "/" + j + " = " + secondNumberNumerator + "/" + secondNumberDenominator + " (-" + firstNumberNumerator + ")");
					}
				}
				if (firstNumberNumerator == secondNumberDenominator) {
					if ((double)i/j == (double)secondNumberNumerator/firstNumberDenominator) {
						numeratorProductNonTrivialFractions *= i;
						denominatorProductNonTrivialFractions *= j;
						System.out.println(i + "/" + j + " = " + secondNumberNumerator + "/" + firstNumberDenominator + " (-" + firstNumberNumerator + ")");
					}
				}
				if (secondNumberDenominator != 0 && secondNumberNumerator == firstNumberDenominator) {
					if ((double)i/j == (double)firstNumberNumerator/secondNumberDenominator) {
						numeratorProductNonTrivialFractions *= i;
						denominatorProductNonTrivialFractions *= j;
						System.out.println(i + "/" + j + " = " + firstNumberNumerator + "/" + secondNumberDenominator + " (-" + secondNumberNumerator + ")");
					}
				}
				if (secondNumberNumerator != 0 && secondNumberNumerator == secondNumberDenominator) {
					if ((double)i/j == (double)firstNumberNumerator/firstNumberDenominator) {
						numeratorProductNonTrivialFractions *= i;
						denominatorProductNonTrivialFractions *= j;
						System.out.println(i + "/" + j + " = " + firstNumberNumerator + "/" + firstNumberDenominator + " (-" + secondNumberNumerator + ")");
					}
				}
			}
		}

		int[] reductedFraction = reduceFraction(numeratorProductNonTrivialFractions, denominatorProductNonTrivialFractions);

		System.out.println();
		System.out.println(numeratorProductNonTrivialFractions + "/" + denominatorProductNonTrivialFractions + " = " + reductedFraction[0] + "/" + reductedFraction[1]);
		System.out.println("Denominator of product of the non trivial fractions in lowest common terms = " + reductedFraction[1]);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static int[] reduceFraction (int numerator, int denominator) {

		int gcd = calculateGCD(numerator, denominator);
		int[] reductedFraction = {numerator /= gcd, denominator /= gcd};
		return reductedFraction;
	}

	public static int calculateGCD (int numerator, int denominator) {

		if (numerator % denominator == 0) {
			return denominator;
		}
		return calculateGCD(denominator, numerator % denominator);
	}

}
