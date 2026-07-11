package homework_b17;

import model.B10LinkedListItem;
import model.Be10LinkedList;

public class B10Main {

	public static void main(String[] args) {
		
		Be10LinkedList ll = new Be10LinkedList();
		
		B10LinkedListItem item0 = new B10LinkedListItem();
		B10LinkedListItem item1 = new B10LinkedListItem();
		B10LinkedListItem item2 = new B10LinkedListItem();
			
		item0.value = 0;
		item1.value = 1;
		item2.value = 2;
				
		
		ll.add(item0);
		ll.add(item1);
		ll.add(item2);
		
		
		System.out.println(ll.get(0).value);
		System.out.println(ll.get(1).value);
		System.out.println(ll.get(2).value);
		
		
		ll.remove(2);
		
		System.out.println("after remove item 2");
		
		System.out.println(ll.get(2));

	}

}
