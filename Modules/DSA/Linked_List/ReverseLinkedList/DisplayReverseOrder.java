
class SinglyLinkedList3{
	Node head;

	static class Node{
		int data;
		Node next;
		Node(){
			data = 0;
			next = null;
		}
		Node(int val){
			data = val;
			next = null;
		}
	}

	boolean isEmpty(){
		return head == null ;
	}

	void display(){
		Node trav = head; 
		while(trav != null ){
			System.out.print(trav.data+" -> ");
			trav = trav.next ;
		}
		System.out.println();
	}

	void addLast(int data){
		//1. create a node and init
		Node new_node = new Node(data);

		// case 1: if list is empty
		if(isEmpty()){
			head = new_node;
		}else{
			// traverse up to last node
		Node trav = head;
		while(trav.next != null ){
			trav = trav.next;
		}
		trav.next = new_node;
		}
		
	}

	Node displayReverseRecursive(Node current){

		//Node current = head;

		if(current.next == null){
			return current;
		}

		Node tail = displayReverseRecursive(current.next);
		System.out.print(tail.data+ " -> " );

		return current;
	}

	public void displayReverseRecursive(){
		if(head != null)
			displayReverseRecursive(head);
			System.out.println(head.data + " -> ");
	}
}

class DisplayReverseOrder {
	public static void main(String[] args) {
		
		// create the object of Linked List 
		SinglyLinkedList3 list = new SinglyLinkedList3();

		//adding elements in list
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);

		// print list
		// System.out.print("Before : ");
		// list.display();

		// //revese list
		// list.recursiveReverse();

		// // print reverse list
		// System.out.print("After : ");
		// list.display();

		System.out.println("display in reverse order: ");
		list.displayReverseRecursive();
		System.out.println("original list: ");
		list.display();

	}
}