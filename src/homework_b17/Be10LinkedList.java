package model;

public class Be10LinkedList {
	public B10LinkedListItem head;

	// O(n) check each item to find the last item to add to ll
	public void add(B10LinkedListItem item) {
		//empty list
		if (head == null) {
			head = item;
			return;
		}

		//find the last item to connect 
		B10LinkedListItem pointer = head;
		while (pointer.next != null) {
			pointer = pointer.next;
		}
		pointer.next = item;
	}

	//O(1) if removing item at index 0 / otherwise O(n)
	public void remove(int index) {
		// case 1: invalid or empty list
		if (index < 0 || head == null) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		//case 2: index = 0 (1st element)
		if (index == 0) {
			head = head.next;
			return;
		}

		B10LinkedListItem pointer = head;

		for (int i = 0; i < index - 1; i++) {

			pointer = pointer.next;
			
		//case 3: index > length
			if (pointer == null || pointer.next == null) {
				throw new IndexOutOfBoundsException("Invalid index");
			}
		}
		pointer.next = pointer.next.next;
	}

	
	
	public B10LinkedListItem get(int index) {
		// Case 1: index < 0 or empty list
		if (index < 0|| head == null) {
			throw new IndexOutOfBoundsException("Invalid index");
		}

		B10LinkedListItem pointer = head;

		for (int i = 0; i < index; i++) {
			pointer = pointer.next;
		}
		// Case 2: index > length
		if (pointer == null) {
			throw new IndexOutOfBoundsException("Invalid index");
		}
		return pointer;
	}
}
