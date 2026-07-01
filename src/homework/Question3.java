package homework;

public class Question3 {

	public static void main(String[] args) {

		// test

		Question3 q = new Question3();

		int[] A = { 2, 1, 5, -6, 9 };

		System.out.println(q.solution(A));

	}

	public int solution(int[] A) {
		long even = 0;
		long odd = 0;

		// count number of odd and even in the array
		for (int x : A) {
			if (x % 2 == 0) {
				even++;
			} else {
				odd++;
			}
		}

		// count the pairs
		long evenPairs = even * (even - 1) / 2;
		long oddPairs = odd * (odd - 1) / 2;

		long totalPairs = evenPairs + oddPairs;

		if (totalPairs > 1000000000) {
			return -1;
		}

		return (int) totalPairs;
	}
}
