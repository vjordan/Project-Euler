package problems.difficulty_05.problems_020_029;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

// Amicable numbers
public class Problem21 {

	public static void main(String[] args) {

		long startTime = System.currentTimeMillis();

		long limit = 10000;
		long sumAmicableNumbers = 0;

		Map<Long,Long> mapNumbersDivisors = new HashMap<>();

		for (long i = 1; i < limit; i++) {
			mapNumbersDivisors.put(i, sumOfDivisors(i));
		}
		
		Set<Entry<Long,Long>> setMap = mapNumbersDivisors.entrySet();
		Iterator<Entry<Long,Long>> iterator = setMap.iterator();
		while (iterator.hasNext()){
			Entry<Long,Long> entry = iterator.next();
			long number = entry.getKey();
			long sumOfDivisors = entry.getValue();
			if (number < sumOfDivisors && sumOfDivisors < limit && mapNumbersDivisors.get(sumOfDivisors).equals(number)) {
				sumAmicableNumbers+=number+sumOfDivisors;
				System.out.println(number + " " + sumOfDivisors);
			}
		}

		System.out.println();
		System.out.println("Sum of all the amicable numbers = " + sumAmicableNumbers);

		System.out.println();
		long endTime = System.currentTimeMillis();
		System.out.println("Execution time = " + (endTime - startTime) + " ms");
	}

	public static long sumOfDivisors (long number) {

		if (number == 1) {
			return 1;
		}

		long sumOfDivisors = 0;

		for (int i = 1; i <= number/2; i++) {
			if (number % i == 0) {
				sumOfDivisors+=i;
			}
		}

		return sumOfDivisors;
	}

}
