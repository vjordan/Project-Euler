package problems.difficulty_05.problems_020_029;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

//Names scores
public class Problem22 {

	public static void main(String[] args) throws Exception {

		long startTime = System.currentTimeMillis();

		String[] names = readNamesFromFile();
		Arrays.sort(names);
		Map<Character,Integer> letterScores = giveLetterScores();

		long totalNameScores = 0;

		for (int i = 0; i < names.length; i++) {
			int nameScore = calculateNameScore(letterScores, names[i]);
			totalNameScores += nameScore*(i+1);
			System.out.println(names[i] + " : " + nameScore + " * " + (i+1) + " = " + nameScore*(i+1));
		}

		System.out.println();
		System.out.println("Total of all the name scores = " + totalNameScores);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static String[] readNamesFromFile() throws Exception {

		String filePath = "src/utils/Problem22.txt";
		String[] names = null;

		BufferedReader reader = new BufferedReader(new FileReader(filePath));
		String line;
		while ((line = reader.readLine()) != null) {
			names = line.replaceAll("\"", "").split(",");
		}
		reader.close();

		return names;
	}

	public static Map<Character,Integer> giveLetterScores() {

		char[] letters = {'A','B','C','D','E','F','G','H','I','J','K','L','M','N','O','P','Q','R','S','T','U','V','W','X','Y','Z'};
		Map<Character,Integer> letterScores = new HashMap<Character,Integer>();

		for (int i = 1; i <= letters.length; i++) {
			letterScores.put(letters[i-1], i);
		}

		return letterScores;
	}

	public static int calculateNameScore(Map<Character,Integer> letterScores, String name) {

		int nameScore = 0;

		for (int i = 0; i < name.length(); i++) {
			nameScore += letterScores.get(name.charAt(i));
		}

		return nameScore;
	}

}
