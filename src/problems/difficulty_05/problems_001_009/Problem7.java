package problems.difficulty_05.problems_001_009;

// 10001st prime
public class Problem7 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		long position = 10001;
		long indexLoop = 1;
		long indexPrime = 1;
		
		do {
			indexLoop+=2;
			if (isPrimeFactor(indexLoop)) {
				indexPrime++;
				if (indexPrime == position) {
					long primeLimit = indexLoop;
					
					System.out.println("Prime number at position = " + primeLimit);
				}
			}
		} while (indexPrime < position);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static boolean isPrimeFactor (long number) {
		
		boolean isPrimeFactor = true;
		
		for (long i = 3; i <= Math.sqrt(number); i=i+2) {
			if (number % i == 0) {
				isPrimeFactor = false;
				break;
			}
		}
		
		return isPrimeFactor;
	}

}
