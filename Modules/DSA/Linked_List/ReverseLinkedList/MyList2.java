
class SinglyLinkedList2{
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

	protected Node recursiveReverse(Node current ){

		// for last element
		if(current.next == null ){

			// if my list has single element
			head = current;
			return current;
		}
		Node tail = recursiveReverse(current.next);
			 tail.next = current;
			 current.next = null ;
			 return current;
	}

	public void recursiveReverse(){
		if(head != null )
		recursiveReverse(head);
	}
}

class MyList2 {
	public static void main(String[] args) {
		
		// create the object of Linked List 
		SinglyLinkedList2 list = new SinglyLinkedList2();

		//adding elements in list
		list.addLast(10);
		list.addLast(20);
		list.addLast(30);
		list.addLast(40);
		list.addLast(50);

		// print list
		System.out.print("Before : ");
		list.display();

		//revese list
		list.recursiveReverse();

		// print reverse list
		System.out.print("After : ");
		list.display();

	}
}