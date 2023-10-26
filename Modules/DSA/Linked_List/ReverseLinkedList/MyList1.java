
class SinglyLinkedList1{
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

	void reverse(){

		// make a oldHead 
		Node oldhead = head;
		head = null ;

		while(oldhead != null ){
		// delete the node from oldList deleteFist
		Node temp = oldhead;
		oldhead = oldhead.next;

		// now add temp as addFirst() in new List
		temp.next = head ;
		head = temp ;
		}
 	}
}

class MyList1 {
	public static void main(String[] args) {
		
		// create the object of Linked List 
		SinglyLinkedList1 list = new SinglyLinkedList1();

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
		list.reverse();

		// print reverse list
		System.out.print("After : ");
		list.display();

	}
}