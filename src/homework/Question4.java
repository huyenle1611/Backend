package homework;

public class Question4 {

	public static void main(String[] args) {

		//test
		int[] A = {10, 2, 5, 1, 8, 20};

        System.out.println(solution(A));
		
	}

	//O(n^3)
	public static int solution(int[] A) {

		if (A == null || A.length < 3) {
			return 0;
		}

		// Sort smallest to largest
		for (int i = 0; i < A.length-1; i++) {
			int minIndex = i;

			for (int j = i + 1; j < A.length; j++) {
				if (A[j] < A[minIndex]) {
					minIndex = j;
				}
			}

			int temp = A[i];
			A[i] = A[minIndex];
			A[minIndex] = temp;
		}

		// check if any triangle
		for (int i = 0; i < A.length - 2; i++) {
			if ((long) A[i] + A[i + 1] > A[i + 2]) {
				return 1;
			}
		}

		return 0;
	}

}
