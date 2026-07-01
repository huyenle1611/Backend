package homework;

public class Question2 {

	public static void main(String[] args) {

		//
		Question2 q = new Question2();

		int[] A1 = { 4, 1, 2, 3 };
		int test1 = q.solution(A1);
		System.out.println("Test 1 = " + test1);

		int[] A2 = { 1, 100, 2 };
		int test2 = q.solution(A2);
		System.out.println("Test 2 = " + test2);

		int[] A3 = { 1000000000, 1, 2, 2, 1000000000, 1, 1000000000 };
		int test3 = q.solution(A3);
		System.out.println("Test 3 = " + test3);
	}

	//O(n)
	public int solution(int[] A) {
		long MOD = 1000000000;
		long totalIfNextIsPlus = 0;
		long totalIfNextIsMinus = 0;

		for (int x : A) {
			// decision 1: keep the element
			// case 1: the next number will be plus
			long total1 = totalIfNextIsMinus - x;

			// case 2: the next number will be minus
			long total2 = totalIfNextIsPlus + x;

			// decision 2: remove the element
			// case 1: the next number will be plus
			long total3 = totalIfNextIsPlus;

			// case 2: the next number will be minus
			long total4 = totalIfNextIsMinus;

			// keep the 2 best results according to the status plus / minus of next number
			// next number is plus
			totalIfNextIsPlus = Math.max(total1, total3);

			// next number is minus
			totalIfNextIsMinus = Math.max(total2, total4);

		}
		// choose the final best total
		long answer = Math.max(totalIfNextIsPlus, totalIfNextIsMinus);
		return (int) (answer % MOD);
	}
}
