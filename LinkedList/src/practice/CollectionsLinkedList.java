package practice;
import java.util.LinkedList;

public class CollectionsLinkedList {

	public static void main(String[] args) {
		
		LinkedList<Integer> ll= new LinkedList<Integer>();
		ll.add(10);
		ll.add(30);
		ll.addFirst(40);
		ll.addFirst(7);
		ll.set(2, 100);
		System.out.println(ll.size());
		
		for(int i=0; i<ll.size(); i++) {
			System.out.print(ll.get(i)+" ");
		}

	}

}
