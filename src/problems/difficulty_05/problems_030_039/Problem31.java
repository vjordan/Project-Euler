package problems.difficulty_05.problems_030_039;

// Coin sums
public class Problem31 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int expectedTotal = 200;
		long numberDifferentWays = 0;

		for (int i = 0; i <= expectedTotal/200; i++) {
			for (int j = 0; j <= (expectedTotal-i*200)/100; j++) {
				for (int k = 0; k <= (expectedTotal-i*200-j*100)/50; k++) {
					for (int l = 0; l <= (expectedTotal-i*200-j*100-k*50)/20; l++) {
						for (int m = 0; m <= (expectedTotal-i*200-j*100-k*50-l*20)/10; m++) {
							for (int n = 0; n <= (expectedTotal-i*200-j*100-k*50-l*20-m*10)/5; n++) {
								for (int o = 0; o <= (expectedTotal-i*200-j*100-k*50-l*20-m*10-n*5)/2; o++) {
									int p = (expectedTotal-i*200-j*100-k*50-l*20-m*10-n*5-o*2)/1;
									numberDifferentWays++;
									System.out.println(i + "*£2 + " + j + "*£1 + " + k + "*50p + " + l + "*20p + " + m + "*10p + " + n + "*5p + " + o + "*2p + " + p + "*1p");
								}
							}
						}
					}
				}
			}
		}

		System.out.println();
		System.out.println("Number of different ways which can £2 be made using any number of coins = " + numberDifferentWays);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

}
