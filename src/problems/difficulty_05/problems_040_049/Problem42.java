package problems.difficulty_05.problems_040_049;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

//Coded triangle numbers
public class Problem42 {

	public static void main(String[] args) throws Exception {

		long startTime = System.currentTimeMillis();

		String largestEnglishWord = "antidisestablishmentarianism";
		String wordLimit = "";
		for (int i = 0; i < largestEnglishWord.length(); i++) {
			wordLimit += "z";
		}
		Map<Character,Integer> letterValues = giveLetterValues();
		int limit = calculateWordValue(letterValues, wordLimit);

		ArrayList<Integer> triangleNumbers = new ArrayList<Integer>();
		int triangleNumber = 0;
		int increment = 0;
		do {
			increment++;
			triangleNumber+=increment;
			triangleNumbers.add(triangleNumber);
		} while (triangleNumber < limit);

		String[] words = readWordsFromFile();
		int numberTriangleWords = 0;
		for (String word : words) {
			int wordValue = calculateWordValue(letterValues, word);
			if (triangleNumbers.contains(wordValue)) {
				numberTriangleWords++;
				System.out.println(word + " : " + wordValue + " = t(" + (triangleNumbers.indexOf(wordValue)+1) + ")");
			}
		}

		System.out.println();
		System.out.println("Number of triangle numbers = " + numberTriangleWords);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static String[] readWordsFromFile() throws Exception {

		String filePath = "src/utils/Problem42.txt";
		String[] words = null;

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		while ((line = reader.readLine()) != null) {
			words = line.replaceAll("\"", "").split(",");
		}
		reader.close();

		return words;
	}

	public static Map<Character,Integer> giveLetterValues() {

		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		Map<Character,Integer> letterValues = new HashMap<Character,Integer>();

		for (int i = 1; i <= letters.length; i++) {
			letterValues.put(letters[i-1], i);
		}

		return letterValues;
	}

	public static int calculateWordValue(Map<Character,Integer> letterValues, String word) {

		int wordValue = 0;

		word = word.toUpperCase();
		for (int i = 0; i < word.length(); i++) {
			wordValue += letterValues.get(word.charAt(i));
		}

		return wordValue;
	}

}
