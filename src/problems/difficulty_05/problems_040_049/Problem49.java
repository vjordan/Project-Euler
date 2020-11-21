package problems.difficulty_05.problems_040_049;

import java.util.ArrayList;

// Prime permutations
public class Problem49 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		String concatenatedTerms = "";
		
		boolean isFound = false;
		for (int i = 1000; i < 8000; i++) {
			if (isPrime(i)) {
				ArrayList<String> permutations = permutationsBuilding(Integer.toString(i));
				for (int j = 1000; j < (10000-i)/2; j++) {
					if (isPrime(i+j) && permutations.contains(Integer.toString(i+j))
							&& isPrime(i+2*j) && permutations.contains(Integer.toString(i+2*j))) {
						System.out.println(i + " " + (i+j) + " " + (i+2*j) + " (+" + j + ")");
						if (i != 1487) {
							concatenatedTerms = Integer.toString(i)+Integer.toString(i+j)+Integer.toString(i+2*j);
							isFound = true;
							break;
						}
					}
				}
			}
			if (isFound) {
				break;
			}
		}
		
		System.out.println();
		System.out.println("Concatenated terms in the sequence = " + concatenatedTerms);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isPrime (int number) {

		if (number == 2) {
			return true;
		}
		if (number < 2 || number % 2 == 0) {
			return false;
		}
		for (int i = 3; i <= Math.sqrt(number); i = i+2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}
	
	public static ArrayList<String> permutationsBuilding (String number) {
		
		ArrayList<String> permutations = new ArrayList<String>();
		
		for (int i = 0; i < number.length(); i++) {
			for (int j = 0; j < number.length(); j++) {
				if (i != j) {
					for (int k = 0; k < number.length(); k++) {
						if (k != i && k != j) {
							for (int l = 0; l < number.length(); l++) {
								if (l != i && l != j && l != k) {
									permutations.add(Character.toString(number.charAt(i))
											+ Character.toString(number.charAt(j))
											+ Character.toString(number.charAt(k))
											+ Character.toString(number.charAt(l)));
								}
							}
						}
					}
				}
			}
		}
		
		return permutations;
	}

}
