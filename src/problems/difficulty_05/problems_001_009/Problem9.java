package problems.difficulty_05.problems_001_009;

// Special Pythagorean triplet
public class Problem9 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		long limit = 1000;
		boolean isFound = false;

		for (long i = 1; i <= limit/3; i++) {
			for (long j = i+1; j <= (limit-i)/2; j++) {
				for (long k = j+1; k <= limit-(i+j); k++) {
					if (i+j+k == limit && i*i+j*j == k*k) {
						long productABC = i*j*k;
						isFound = true;
						
						System.out.println(i + " * " + i + " + " + j + " * " + j + " = " + k + " * " + k);
						System.out.println("Product = " + productABC);

						break;
					}
				}
				if (isFound) {
					break;
				}
			}
			if (isFound) {
				break;
			}
		}

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
