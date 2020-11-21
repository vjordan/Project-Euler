package problems.difficulty_05.problems_040_049;

import java.util.ArrayList;

//Sub-string divisibility
public class Problem43 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int[] firstPrimes = {2,3,5,7,11,13,17};
		ArrayList<ArrayList<String>> divisibleNumbers = new ArrayList<ArrayList<String>>();
		for (int i = 0 ; i < firstPrimes.length ; i++) {
			divisibleNumbers.add(new ArrayList<String>());
		}

		for (int i = 10; i < 1000; i++) {
			for (int j = 0; j < firstPrimes.length; j++) {
				if (i % firstPrimes[j] == 0) {
					if (i < 100) {
						divisibleNumbers.get(j).add("0" + Integer.toString(i));
					} else {
						divisibleNumbers.get(j).add(Integer.toString(i));
					}
				}
			}
		}

		for (int i = 0; i < firstPrimes.length; i++) {
			ArrayList<String> numbersToRemove = new ArrayList<String>();
			for (int j = 0; j < divisibleNumbers.get(i).size(); j++) {
				String number = divisibleNumbers.get(i).get(j);
				if (number.charAt(0) == number.charAt(1)
						|| number.charAt(0) == number.charAt(2)
						|| number.charAt(1) == number.charAt(2)) {
					numbersToRemove.add(number);
				}
			}
			for (int j = 0; j < numbersToRemove.size(); j++) {
				divisibleNumbers.get(i).remove(divisibleNumbers.get(i).indexOf(numbersToRemove.get(j)));
			}
		}

		for (int i = firstPrimes.length-2; i >=  0; i--) {
			ArrayList<String> numbersToRemove = new ArrayList<String>();
			for (int j = 0; j < divisibleNumbers.get(i).size(); j++) {
				String numberA = divisibleNumbers.get(i).get(j);
				boolean found = false;
				for (int k = 0; k < divisibleNumbers.get(i+1).size(); k++) {
					String numberB = divisibleNumbers.get(i+1).get(k);
					if (numberB.startsWith(numberA.substring(1))
							&& numberA.charAt(0) != numberB.charAt(2)) {
						found = true;
						break;
					}
				}
				if (!found) {
					numbersToRemove.add(numberA);
				}
			}
			for (int j = 0; j < numbersToRemove.size(); j++) {
				divisibleNumbers.get(i).remove(divisibleNumbers.get(i).indexOf(numbersToRemove.get(j)));
			}
		}

		for (int i = 1; i < firstPrimes.length; i++) {
			ArrayList<String> numbersToRemove = new ArrayList<String>();
			for (int j = 0; j < divisibleNumbers.get(i).size(); j++) {
				String numberA = divisibleNumbers.get(i).get(j);
				boolean found = false;
				for (int k = 0; k < divisibleNumbers.get(i-1).size(); k++) {
					String numberB = divisibleNumbers.get(i-1).get(k);
					if (numberA.startsWith(numberB.substring(1))) {
						found = true;
						break;
					}
				}
				if (!found) {
					numbersToRemove.add(numberA);
				}
			}
			for (int j = 0; j < numbersToRemove.size(); j++) {
				divisibleNumbers.get(i).remove(divisibleNumbers.get(i).indexOf(numbersToRemove.get(j)));
			}
		}

		String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
		long sumPandigitalNumbers = 0;
		for (int i = 0; i < divisibleNumbers.get(0).size(); i++) {
			for (int j = 0; j < divisibleNumbers.get(1).size(); j++) {
				if (divisibleNumbers.get(0).get(i).substring(1,3).equals(divisibleNumbers.get(1).get(j).substring(0,2))) {
					for (int k = 0; k < divisibleNumbers.get(2).size(); k++) {
						if (divisibleNumbers.get(1).get(j).substring(1,3).equals(divisibleNumbers.get(2).get(k).substring(0,2))) {
							for (int l = 0; l < divisibleNumbers.get(3).size(); l++) {
								if (divisibleNumbers.get(2).get(k).substring(1,3).equals(divisibleNumbers.get(3).get(l).substring(0,2))) {
									for (int m = 0; m < divisibleNumbers.get(4).size(); m++) {
										if (divisibleNumbers.get(3).get(l).substring(1,3).equals(divisibleNumbers.get(4).get(m).substring(0,2))) {
											for (int n = 0; n < divisibleNumbers.get(5).size(); n++) {
												if (divisibleNumbers.get(4).get(m).substring(1,3).equals(divisibleNumbers.get(5).get(n).substring(0,2))) {
													for (int o = 0; o < divisibleNumbers.get(6).size(); o++) {
														if (divisibleNumbers.get(5).get(n).substring(1,3).equals(divisibleNumbers.get(6).get(o).substring(0,2))) {
															String combination = divisibleNumbers.get(0).get(i)
																	+divisibleNumbers.get(1).get(j).charAt(2)
																	+divisibleNumbers.get(2).get(k).charAt(2)
																	+divisibleNumbers.get(3).get(l).charAt(2)
																	+divisibleNumbers.get(4).get(m).charAt(2)
																	+divisibleNumbers.get(5).get(n).charAt(2)
																	+divisibleNumbers.get(6).get(o).charAt(2);
															boolean valid = true;
															for (int p = 0; p < combination.length()-1; p++) {
																if (combination.substring(p+1).contains(Character.toString(combination.charAt(p)))) {
																	valid = false;
																	break;
																}
															}
															if (valid) {
																for (int p = 0; p < digits.length; p++) {
																	if (!combination.contains(digits[p])) {
																		combination = digits[p] + combination;
																		break;
																	}
																}
																sumPandigitalNumbers += Long.parseLong(combination);
																System.out.println(combination);
															}
														}
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

		System.out.println();
		System.out.println("Sum of all pandigital numbers with the property = " + sumPandigitalNumbers);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	/*long start = 1023456789;
	long end = 9876543210L;
	for (long i = start; i <= end; i++) {
		if (isPandigital(Long.toString(i))) {
			boolean isDivisible = true;
			for (int j = 0; j < firstPrimes.length; j++) {
				if (Integer.parseInt(Long.toString(i).substring(1+j, 4+j)) % firstPrimes[j] != 0) {
					isDivisible = false;
					break;
				}
			}
			if (isDivisible) {
				sumPandigitalNumbers += i;
				System.out.println(i);
			}
		}
	}*/

}
