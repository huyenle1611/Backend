package heap;

import java.util.Collections;
import java.util.PriorityQueue;

public class MiddleNumber {
	public static double middleNumber(int[] A) {
		if (A.length == 0 || A == null) {
			return -1;
		}

		if (A.length == 1) {
			return A[0];
		}

		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(Collections.reverseOrder());

		maxHeap.add(Math.min(A[0], A[1]));
		minHeap.add(Math.max(A[0], A[1]));

		// compare to add number into max heap and min heap
		for (int i = 2; i < A.length; i++) {
			if (A[i] >= minHeap.peek()) {
				minHeap.add(A[i]);
			} else {
				maxHeap.add(A[i]);
			}

			// make sure heaps have no more than 1 difference
			int diff = minHeap.size() - maxHeap.size();

			if (diff < -1) {
				minHeap.add(maxHeap.poll());
			} else if (diff > 1) {
				maxHeap.add(minHeap.poll());
			}

		}

		// check to get middle number
		if (maxHeap.size() == minHeap.size()) {
			return (double) (maxHeap.peek() + minHeap.peek()) / 2;
		} else if (maxHeap.size() > minHeap.size()) {
			return (double) maxHeap.peek();
		} else {
			return (double) minHeap.peek();
		}
	}
	
	
	//testing

	public static void main(String[] args) {
		int[] A = { 8, 1, 3, 5, 9, 7, 10 };
		System.out.println(middleNumber(A));

	}

}
