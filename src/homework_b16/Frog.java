package homework_b16;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Frog {

	public static void main(String[] args) {
		
		//test1
		int[] A1 = {0, 0, 0, 1, 1, 0, 1, 0, 0, 0, 0};
        System.out.println(solution(A1)); 
        
        
       //test 2
        int[] A2 = {0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 0};
        System.out.println(solution(A2)); 

	}

	public static int solution(int[] A) {

		int N = A.length;

		// create fibonacci list
		ArrayList<Integer> fibonacci = new ArrayList<>();

		int first = 1;
		int second = 2;

		fibonacci.add(first);
		fibonacci.add(second);

		// goal is N, start point is -1
		while (first + second <= N + 1) {

			int next = first + second;

			fibonacci.add(next);

			first = second;
			second = next;
		}

		// creating queue
		Queue<int[]> queue = new LinkedList<>();
		boolean[] visited = new boolean[N];

		// start point: position = -1, jumps = 0
		queue.add(new int[] { -1, 0 });

		// check all the nodes in the queue, until the queue is empty
		while (!queue.isEmpty()) {

			// get the first one in the line to check
			int[] currentPos = queue.poll();

			int position = currentPos[0];
			int jumps = currentPos[1];

			for (int jump : fibonacci) {
				int nextPosition = position + jump;

				// Reached the other side
				if (nextPosition == N) {
					return jumps + 1;
				}

				// over the range
				if (nextPosition > N) {
					break;
				}

				// Can land only on leaf (1) and only add the position that is not visited
				if (nextPosition >= 0 && A[nextPosition] == 1 && !visited[nextPosition]) {
					visited[nextPosition] = true;
					queue.add(new int[] { nextPosition, jumps + 1 });
				}
			}
		}

		return -1;

	}
}
