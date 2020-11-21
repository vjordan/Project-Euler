package problems.difficulty_05.problems_070_079;

import static java.util.Comparator.comparingInt;
import static java.util.stream.Collectors.toMap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

// Passcode derivation
public class Problem79 {

	public static void main(String[] args) {
		
		long startTime = System.currentTimeMillis();
		
		int[] keylogs = keyLogsBuilding();
		HashMap<Integer, ArrayList<Integer>> successors = successorsCalculation(keylogs).entrySet().stream().sorted(Collections.reverseOrder(comparingInt(e -> e.getValue().size()))).collect(toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> { throw new AssertionError(); }, LinkedHashMap::new)); 
		
		String passcode = "";
		for (HashMap.Entry<Integer, ArrayList<Integer>> successor : successors.entrySet()) {
			if (!successor.getValue().isEmpty()) {
				passcode += Integer.toString(successor.getKey());
			} else {
				break;
			}
			if (successor.getValue().size() == 1) {
				passcode += Integer.toString(successor.getValue().get(0));
			}
		}
		
		System.out.println("Shortest possible secret passcode = " + passcode);
		
		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}
	
	public static int[] keyLogsBuilding() {
		
		int[] keylogs = new int[50];
		
		keylogs[0] = 319;
		keylogs[1] = 680;
		keylogs[2] = 180;
		keylogs[3] = 690;
		keylogs[4] = 129;
		keylogs[5] = 620;
		keylogs[6] = 762;
		keylogs[7] = 689;
		keylogs[8] = 762;
		keylogs[9] = 318;
		keylogs[10] = 368;
		keylogs[11] = 710;
		keylogs[12] = 720;
		keylogs[13] = 710;
		keylogs[14] = 629;
		keylogs[15] = 168;
		keylogs[16] = 160;
		keylogs[17] = 689;
		keylogs[18] = 716;
		keylogs[19] = 731;
		keylogs[20] = 736;
		keylogs[21] = 729;
		keylogs[22] = 316;
		keylogs[23] = 729;
		keylogs[24] = 729;
		keylogs[25] = 710;
		keylogs[26] = 769;
		keylogs[27] = 290;
		keylogs[28] = 719;
		keylogs[29] = 680;
		keylogs[30] = 318;
		keylogs[31] = 389;
		keylogs[32] = 162;
		keylogs[33] = 289;
		keylogs[34] = 162;
		keylogs[35] = 718;
		keylogs[36] = 729;
		keylogs[37] = 319;
		keylogs[38] = 790;
		keylogs[39] = 680;
		keylogs[40] = 890;
		keylogs[41] = 362;
		keylogs[42] = 319;
		keylogs[43] = 760;
		keylogs[44] = 316;
		keylogs[45] = 729;
		keylogs[46] = 380;
		keylogs[47] = 319;
		keylogs[48] = 728;
		keylogs[49] = 716;
		
		return keylogs;
	}
	
	public static HashMap<Integer, ArrayList<Integer>> successorsCalculation(int[] keylogs){
		
		HashMap<Integer, ArrayList<Integer>> successors = new HashMap<Integer, ArrayList<Integer>>();
		
		for (int i = 0; i <= 9; i++) {
			successors.put(i, new ArrayList<Integer>());
		}
		
		for (int keylog : keylogs) {
			String keylog_string = Integer.toString(keylog);
			int[] numbers = new int[keylog_string.length()];
			for (int i = 0; i < keylog_string.length(); i++) {
				numbers[i] = Integer.parseInt(String.valueOf(keylog_string.charAt(i)));
			}
			for (int i = 0; i < numbers.length; i++) {
				if (i != numbers.length-1) {
					for (int j = i+1; j < numbers.length; j++) {
						if (!successors.get(numbers[i]).contains(numbers[j])) {
							successors.get(numbers[i]).add(numbers[j]);
						}
					}
				}
			}
		}
		
		return successors;
	}

}
