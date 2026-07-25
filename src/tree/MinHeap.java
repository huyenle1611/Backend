package all_about_tree;

public class MinHeap {
	Node[] heap;
	int pointer; // point at the next empty position in array

	public MinHeap(int capacity) {
		heap = new Node[capacity];
		pointer = 0;
	}

	// function to add a node into MinHeap
	public void addNode(Node node) {
		if (node == null) {
			return;
		}
		// if array is full -> resize
		if (pointer == heap.length) {
			resize();
		}
		// add new node into pointer index
		heap[pointer] = node;

		// arrange nodes in the MinHeap to make the root smallest
		rearrangeUp(pointer);
		pointer++;
	}

	public void resize() {
		Node[] newHeap = new Node[heap.length * 2];
		// copy all items from old heap array into newHeap array
		for (int i = 0; i < heap.length; i++) {
			newHeap[i] = heap[i];
		}
		heap = newHeap;
	}

	public void swap(int firstIndex, int secondIndex) {

		Node temp = heap[firstIndex];
		heap[firstIndex] = heap[secondIndex];
		heap[secondIndex] = temp;
	}

	public void rearrangeUp(int currentIndex) {
		while (currentIndex > 0) {
			int parentIndex = (currentIndex - 1) / 2;
			// if parent > child => swap them
			if (heap[parentIndex].value > heap[currentIndex].value) {
				swap(currentIndex, parentIndex);
			}
			currentIndex = parentIndex;
		}
	}

	// function to remove the min node (root node) in the min heap
	public Node removeMinNode() {
		// heap is empty
		if (pointer == 0) {
			return null;
		}

		Node minNode = heap[0];
		pointer--; // pointer points at last node

		// move the last node to top
		heap[0] = heap[pointer];
		heap[pointer] = null;

		// rearrange all nodes in the MinHeap
		if (pointer > 0) {
			rearrangeDown(0);
		}
		return minNode;
	}

	public void rearrangeDown(int currentIndex) {
		while (currentIndex * 2 + 1 < pointer) {

			int leftChildIndex = currentIndex * 2 + 1;
			int rightChildIndex = currentIndex * 2 + 2;

			// Assume left child is smaller
			int smallerChildIndex = leftChildIndex;

			// If right child exists and is smaller
			if (rightChildIndex < pointer && heap[rightChildIndex].value < heap[leftChildIndex].value) {
				smallerChildIndex = rightChildIndex;
			}

			// parent node is smaller than smaller child >> no need to swap
			if (heap[currentIndex].value <= heap[smallerChildIndex].value) {
				break;
			}

			swap(currentIndex, smallerChildIndex);

			currentIndex = smallerChildIndex;
		}
	}

	// print to test
	public void printHeap() {

		for (int i = 0; i < pointer; i++) {
			System.out.print(heap[i].value + " ");
		}

		System.out.println();
	}

	// test
	public static void main(String[] args) {
		MinHeap minHeap = new MinHeap(4);

		minHeap.addNode(new Node(10));
		minHeap.addNode(new Node(5));
		minHeap.addNode(new Node(8));
		minHeap.addNode(new Node(2));

		// add node 1 into heap array
		minHeap.addNode(new Node(1));

		// print heap 1
		minHeap.printHeap();

		// remove min node
		minHeap.removeMinNode();

		// print heap 2
		minHeap.printHeap();
	}

}
