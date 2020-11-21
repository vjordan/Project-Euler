package problems.difficulty_05.problems_001_009;

// Largest product in a series
public class Problem8 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		String bigNumber = "7316717653133062491922511967442657474235534919493496983520312774506326239578318016984801869478851843858615607891129494954595017379583319528532088055111254069874715852386305071569329096329522744304355766896648950445244523161731856403098711121722383113622298934233803081353362766142828064444866452387493035890729629049156044077239071381051585930796086670172427121883998797908792274921901699720888093776657273330010533678812202354218097512545405947522435258490771167055601360483958644670632441572215539753697817977846174064955149290862569321978468622482839722413756570560574902614079729686524145351004748216637048440319989000889524345065854122758866688116427171479924442928230863465674813919123162824586178664583591245665294765456828489128831426076900422421902267105562632111110937054421750694165896040807198403850962455444362981230987879927244284909188845801561660979191338754992005240636899125607176060588611646710940507754100225698315520005593572972571636269561882670428252483600823257530420752963450";
		
		int numberOfDigits = 13;
		String greatestSequence = "";
		long greatestProduct = 0;
		
		for (int i = 0; i <= bigNumber.length()-numberOfDigits; i++) {
			String sequence = bigNumber.substring(i, i+numberOfDigits);
			long product = calculationProduct(sequence);
			if (product > greatestProduct) {
				greatestSequence = sequence;
				greatestProduct = product;
				System.out.println(showSequence(greatestSequence) + greatestProduct);
			}
		}
		
		System.out.println();
		System.out.println("Greatest sequence = " + greatestSequence);
		System.out.println(showSequence(greatestSequence) + greatestProduct);
		System.out.println("Greatest product = " + greatestProduct);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static long calculationProduct(String sequence) {
		
		long product = 1;
		
		for (int i = 0; i < sequence.length(); i++) {
			int number = Integer.parseInt(String.valueOf(sequence.charAt(i)));
			if (number == 0) {
				product = 0;
				break;
			} else {
				product *= number;
			}
		}
		
		return product;
	}
	
	public static String showSequence (String sequence) {
		
		String calculationString = "";
		
		for (int i = 0; i < sequence.length()-1; i++) {
			calculationString += sequence.charAt(i) + "*";
		}
		calculationString += sequence.charAt(sequence.length()-1) + " = ";
		
		return calculationString;
	}

}
