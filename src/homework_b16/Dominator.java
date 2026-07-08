package homework_b16;

public class Dominator {

	public static void main(String[] args) {
		// test
		int[] A = { 3, 4, 3, 2, 3, -1, 3, 3 };
		System.out.println(solution(A));

	}

	public static int solution(int[] A) {

		if (A.length == 0) {
            return -1;
        }
        
		//find the candidate 
        int candidate = A[0];
        int count = 1;

        for (int i = 1; i < A.length; i++) {

            if (A[i] == candidate) {
                count++;
            } else {
                count--;
            }
            
            //change to new candidate
            if (count == 0) {
                candidate = A[i];
                count = 1;
            }
        }

		// check if candidate is truly a dominator & get the index 
		int occurCount = 0;
		int dominatorIndex = -1;

		for (int i = 0; i < A.length; i++) {
			if (A[i] == candidate) {
				occurCount++;
				dominatorIndex = i;
			}
		}

		if (occurCount > A.length / 2) {
			return dominatorIndex;
		}

		return -1;
	}
}
