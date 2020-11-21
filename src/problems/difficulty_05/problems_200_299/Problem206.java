package problems.difficulty_05.problems_200_299;

// Concealed Square
public class Problem206 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		boolean found = false;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				for (int k = 0; k < 10; k++) {
					for (int l = 0; l < 10; l++) {
						for (int m = 0; m < 10; m++) {
							for (int n = 0; n < 10; n++) {
								for (int o = 0; o < 10; o++) {
									for (int p = 0; p < 10; p++) {
										for (int q = 0; q < 10; q++) {
											String numberString = "1" + i + "2" + j + "3" + k + "4" + l + "5" + m + "6" + n + "7" + o + "8" + p + "9" + q + "0";
											Long number = Long.parseLong(numberString);
											if ((long) Math.sqrt(number) * (long) Math.sqrt(number) == number) {
												System.out.println("Math.sqrt(" + number + ") = " + (long) Math.sqrt(number));
												found = true;
												break;
											}
										}
									}
									if (found) {
										break;
									}
								}
								if (found) {
									break;
								}
							}
							if (found) {
								break;
							}
						}
						if (found) {
							break;
						}
					}
					if (found) {
						break;
					}
				}
				if (found) {
					break;
				}
			}
			if (found) {
				break;
			}
		}
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
