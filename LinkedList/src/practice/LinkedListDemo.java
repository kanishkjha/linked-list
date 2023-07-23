package practice;
import java.util.Scanner;

public class LinkedListDemo {
	
	// Swapping two nodes of a LinkedList: ( Very important, most most important )
	
	 public static Node<Integer> swapNodes(Node<Integer> head, int i, int j) {

	        if (i == j) {
	            return head; // If i and j are the same, no need to swap, just return the head
	        }

	        // Initialize pointers to keep track of the nodes to be swapped and their previous nodes
	        Node<Integer> prev1 = null;
	        Node<Integer> curr1 = head;
	        Node<Integer> prev2 = null;
	        Node<Integer> curr2 = head;

	        int k = 0;
	        // Traverse the linked list to find the nodes to be swapped and their previous nodes
	        while (curr1 != null && k < i) {
	            prev1 = curr1;
	            curr1 = curr1.next;
	            k++;
	        }

	        k = 0;
	        while (curr2 != null && k < j) {
	            prev2 = curr2;
	            curr2 = curr2.next;
	            k++;
	        }

	        // Handle cases where i or j are out of range
	        if (curr1 == null || curr2 == null) {
	            return head;
	        }

	        // If the nodes to be swapped are adjacent
	        if (curr1.next == curr2) {
	            if (prev1 != null) {
	                prev1.next = curr2;
	            } else {
	                head = curr2;
	            }
	            curr1.next = curr2.next;
	            curr2.next = curr1;
	        } else if (curr2.next == curr1) {
	            if (prev2 != null) {
	                prev2.next = curr1;
	            } else {
	                head = curr1;
	            }
	            curr2.next = curr1.next;
	            curr1.next = curr2;
	        } else {
	            if (prev1 != null) {
	                prev1.next = curr2;
	            } else {
	                head = curr2;
	            }
	            if (prev2 != null) {
	                prev2.next = curr1;
	            } else {
	                head = curr1;
	            }
	            Node<Integer> temp = curr1.next;
	            curr1.next = curr2.next;
	            curr2.next = temp;
	        }

	        return head;
	    }
	
	// Reversing a LinkedList ( Iterative )
	
	public static Node<Integer> reverseIterative(Node<Integer> head){
		
		if(head==null){
            return head;
        }
		
		Node<Integer> prev=head;
		Node<Integer> curr=head.next;
		prev.next=null;		
		
		while(curr!=null) {
			Node<Integer> temp=curr.next;
			curr.next=prev;
			
			prev=curr;
			curr=temp;
		}
		return prev;
	}
	
	// Reversing a LinkedList (simplest) 
	
	public static Node<Integer> reverseSimple(Node<Integer> head){
		
		if(head==null|| head.next==null) {
			return head;
		}
		
		Node<Integer> reversedTail= head.next;
		Node<Integer> smallHead=reverseSimple(head.next);
		reversedTail.next=head;
		head.next=null;
		
		return smallHead;
	}
	
	// Reversing a LinkedList (better) : O( n )
	
	public static DoubleNode reverseBetter(Node<Integer> head){
		
		if(head==null || head.next==null) {
			DoubleNode ans= new DoubleNode();
			ans.head=head;
			ans.tail=head;
			return ans;
		}
		
		DoubleNode smallAns= reverseBetter(head.next);
		smallAns.tail.next=head;
		head.next=null;
		
		DoubleNode ans=new DoubleNode();
		ans.head=smallAns.head;
		ans.tail=head;
		
		return ans;
	}
	
	
	// Reversing a LinkedList ( Recursively ) : O( n^2 )
	
	public static Node<Integer> reverseRecursively(Node<Integer> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> finalHead=reverseRecursively(head.next);
		
		Node<Integer> temp=finalHead;
		
		while(temp.next!=null) {
			temp=temp.next;
		}
		temp.next=head;
		head.next=null;
		
		return finalHead;
	}
	
	// Inserting at a given position in LinkedList
	
	public static Node<Integer> insert_Recursive(Node<Integer> head, int pos, int elem ){
		
		if(pos==0) {
			Node<Integer> newNode= new Node<Integer>(elem);
			newNode.next= head;
			return newNode;
			}
		
		if(head==null) {
			return head;
		}
		
		head.next=insert_Recursive(head.next, pos-1, elem);
		
		return head;
		
	}
	
	// Print recursively
	
	public static void printRecursive(Node<Integer> head){
		
		if(head==null) {
			return;
		}
		
		System.out.print(head.data+" ");
		printRecursive(head.next);
	}
	
	// Merge sort in LinkedList
	
	public static Node<Integer> mergeSort(Node<Integer> head) {

        if(head==null || head.next==null){
            return head;
        }

        Node<Integer> slow=head;
        Node<Integer>fast=head;

        Node<Integer> head1=head, head2=null;

        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        head2=slow.next;
        slow.next=null;

        Node<Integer> newHead1=mergeSort(head1);
        Node<Integer> newHead2=mergeSort(head2);
        Node<Integer> finalHead=null, finalTail=null;
        Node<Integer> t1= newHead1;
        Node<Integer> t2= newHead2;

        if(t1.data<=t2.data){
            finalHead=t1;
            finalTail=t1;
            t1=t1.next;
        }else{
            finalHead=t2;
            finalTail=t2;
            t2=t2.next;
        }

        while(t1!=null && t2!=null){

            if(t1.data<=t2.data){
                finalTail.next=t1;
                finalTail=t1;
                t1=t1.next;
            }else{
                finalTail.next=t2;
                finalTail=t2;
                t2=t2.next;
            }
        }

        if(t1!=null){
            finalTail.next=t1;
        }else{
            finalTail.next=t2;
        }

        return finalHead;
	}
	
	// Merging two sorted LinkedList
	
	public static Node<Integer> merge(Node<Integer> head1, Node<Integer> head2){
		
		Node<Integer> t1=head1, t2=head2, head=null, tail=null;
		
		if(t1.data<=t2.data) {
			head=t1;
			tail=t1;
			t1=t1.next;
		}
		else {
			head=t2;
			tail=t2;
			t2=t2.next;
		}
		
		while(t1!=null && t2!=null) {
			if(t1.data<=t2.data) {
				tail.next=t1;
				t1=t1.next;
				}
			else {
				tail.next=t2;
				t2=t2.next;
			}
		}
		
		return head;
	}
	
	// Reverse a LinkedList
	
	public static Node<Integer> reverse(Node<Integer> head){
		
		if(head==null || head.next==null) {
			return head;
		}
		
		Node<Integer> prev=head;
		Node<Integer> curr= prev.next;
		
		while(curr!=null) {
			
			Node<Integer> next=curr.next;
			
			curr.next=prev;
			
			prev=curr;
			curr=next;
		}
		head.next=null;
		
		head=prev;
		
		return head;
	}
	
	
	// Calculating a middle of the LinkedList
	
	public static Node<Integer> middle(Node<Integer> head){
		
		Node<Integer> slow=head, fast=head;
		
		while(fast.next!=null && fast.next.next!=null) {
			slow=slow.next;
			fast=fast.next.next;
		}
		
		return slow;
	}
	
	// Taking LinkedList input
	
	public static Node<Integer> takeInput(){
		
		Node<Integer> head=null, tail=null;
		Scanner s= new Scanner(System.in);
		int data= s.nextInt();
		
		while(data!=-1) {
			Node<Integer> newNode= new Node<Integer>(data);
			
			if(head==null) {
				head= newNode;
				tail= newNode;
				
			}else {
				tail.next=newNode;
				tail=newNode;
			}
			data=s.nextInt();
		}
		
		return head;
	}
	
	// Inserting node at a given position of LinkedList
	
	public static Node<Integer> insert(Node<Integer> head, int data, int pos) {
		
		Node<Integer> newNode= new Node<Integer>(data);
		int i=0;
		Node<Integer> temp=head;
		
		if(pos==0) {
			newNode.next=head;
			return newNode;
		}
		
		while(i<pos-1) {
			temp=temp.next;
			i++;
		}
		newNode.next=temp.next;
		temp.next=newNode;
		
		return head;
	}
	
	// Printing a LinkedList
	
	public static void print(Node<Integer> head) {
		while(head!=null) {
			System.out.print(head.data+" ");
			head=head.next;
		}
		System.out.println();
	}

	public static void main(String[] args) {
		
//		Node<Integer> node1= new Node<Integer>(10);
//		Node<Integer> node2= new Node<Integer>(20);
//		Node<Integer> node3= new Node<Integer>(30);
//		node1.next= node2;
//		node2.next=node3;
//		Node<Integer> head= node1;
//		
//		print(head);
//		print(head);
		
		Node<Integer> head= takeInput();
//		Node<Integer> newHead=insert(head,80,0);
//		print(head);
//		printRecursive(head);
//		print(newHead);
//		System.out.println(middle(newHead).data);
		
//		Node<Integer> reversed=reverse(head);
//		print(reversed);
		
//		head=insert_Recursive(head, 2, 10);
//		DoubleNode ans=reverseBetter(head);
		Node<Integer> reversedHead= reverseIterative(head);
		printRecursive(reversedHead);
	
	}

}

class DoubleNode {
	
	Node<Integer> head;
	Node<Integer> tail;

}
