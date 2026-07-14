package homework_b18;

import java.util.Arrays;

public class AdjacentPQ {

	public static void main(String[] args) {
		int[] A = { 0, 3, 3, 7, 5, 3, 11, 1 };
		System.out.println(solution(A));

	}

	// O(nlogn)
	public static int solution(int[] A) {

		if (A == null || A.length < 2) {
			return 0;
		}

		Arrays.sort(A);

		int pairCount = 0;
		int previousFreq = 0;
		int currentFreq = 1;

		for (int i = 1; i <= A.length; i++) {
			if (i < A.length && A[i] == A[i - 1]) {
				currentFreq++;
				continue;
			}
			// pairs of same number (3,3,3)
			pairCount += currentFreq * (currentFreq - 1) / 2;

			// pairs within different nums (0,1,3...)
			pairCount += previousFreq * currentFreq;

			// reset
			previousFreq = currentFreq;
			currentFreq = 1;
		}

		return pairCount;
	}

}
