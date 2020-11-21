package problems.difficulty_05.problems_010_019;


//Number letter counts
public class Problem17 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		int limit = 1000;

		String[] numbersInWords = new String[limit];
		String[] numbersUnder20 = numbersUnder20();
		String[] numbersUnder100 = numbersUnder100(numbersUnder20);
		String[] numbersUnder1000 = numbersUnder1000(numbersUnder20, numbersUnder100);
		String thousand = "thousand";

		long numberOfLetters = 0;

		for (int i = 0; i < limit; i++) {
			if (i == 999) {
				numbersInWords[i] = numbersUnder20[0] + thousand;
			} else if (i < 19){
				numbersInWords[i] = numbersUnder20[i];
			} else if (i < 99) {
				numbersInWords[i] = numbersUnder100[i-19];
			} else {
				numbersInWords[i] = numbersUnder1000[i-99];
			}
			numberOfLetters += numbersInWords[i].length();
		}

		System.out.println("Number of letters = " + numberOfLetters);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static String[] numbersUnder20 () {

		String[] numbersUnder20 = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen", "nineteen"};

		return numbersUnder20;
	}

	public static String[] numbersUnder100 (String[] numbersUnder20) {

		String[] numbersUnder100 = new String[80];
		String[] starts = {"twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};

		int indexStart = -1;
		int indexNumberUnder10 = -1;
		for (int i = 0; i < 80; i++) {
			if (i % 10 == 0) {
				indexStart++;
				indexNumberUnder10 = -1;
				numbersUnder100[i] = starts[indexStart];
			} else {
				indexNumberUnder10++;
				numbersUnder100[i] = starts[indexStart] + numbersUnder20[indexNumberUnder10];
			}
		}

		return numbersUnder100;
	}

	public static String[] numbersUnder1000 (String[] numbersUnder20, String[] numbersUnder100) {

		String[] numbersUnder1000 = new String[900];
		String hundred = "hundred";
		String and = "and";

		int indexNumberUnder10 = -1;
		int indexNumberUnder100 = -1;
		for (int i = 0; i < 900; i++) {
			if (i % 100 == 0) {
				indexNumberUnder10++;
				indexNumberUnder100 = -1;
				numbersUnder1000[i] = numbersUnder20[indexNumberUnder10] + hundred;
			} else {
				indexNumberUnder100++;
				if (indexNumberUnder100 < 19) {
					numbersUnder1000[i] = numbersUnder20[indexNumberUnder10] + hundred + and + numbersUnder20[indexNumberUnder100];
				} else {
					numbersUnder1000[i] = numbersUnder20[indexNumberUnder10] + hundred + and + numbersUnder100[indexNumberUnder100-19];
				}
			}
		}

		return numbersUnder1000;
	}

}
