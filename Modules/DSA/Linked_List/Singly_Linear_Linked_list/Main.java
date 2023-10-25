import java.util.*;

	// my Linked list class
class SinglyList{
		// LIst classs Fields
		private Node head;
		// list class methods
		SinglyList(){
			head = null;
		}

	// Node class
	static class Node{
		// Node class fields
		private int data;
		private Node next;

		//node class Methods
		public Node(){
			data = 0;
			next = null;
		
		} 
		public Node(int data){
			this.data = data;
			next = null;
		}
	}

		public void display(){
				Node trav = head;

				if(head == null){
					System.out.println("empty list");
				}

				while(trav != null){
					System.out.print(trav.data+ " -> ");
					trav = trav.next;
				}
				System.out.println();
 
		}
		public void addFirst(int data){
			Node new_node =  new Node(data);

			if(head == null){
				head = new_node; 
			}else{
					new_node.next = head ;
					head = new_node;
			}

					}
		public void addLast(int data){
			Node new_node = new Node(data);
			Node trav = head;

			// if list is empty => make new_node as my hrad
			if( head == null ){
				head = new_node;
			}else{
				// travers till last node
			while(trav.next != null){
				trav = trav.next;
			}
			// add new_node after trav
			trav.next = new_node;
			}
			
		} 

		void addAtPos(int val , int pos ){
/*
 				  1. make a new node and init it
				  2. traverse up to node where pos-1 ;
				  3. Make a connect => new_node next shouldn point to trav.next;
				  4. Break a Connection => trav.next = new_node
*/
				 
				 
				 Node new_node = new Node(val);
				 // if list is empty
				 if(head == null ){
				 	head = new_node;
				 	return;
				 } 
				 // if position is 1
				 if(pos == 1){
				 	new_node.next = head;
				 	head = new_node;
				 	return ;
				 }

				 Node trav = head;
				 for(int i= 1; i < pos -1 ; i++){
				 	// case 3: pos > lenght , 
				 	if(trav.next == null){
				 		break;
				 	}
				 	trav  = trav.next ;
				 }

				 if(trav == null ){
				 	trav.next = new_node;
				 }else{

				 new_node.next = trav.next;
				 trav.next = new_node;
				 }
		}

		void deleteFirst(){
			// if list is empty
			if(head == null ){
				throw new RuntimeException("list is empty");
			}else{

				// in general move head
				head = head.next;
			}
		}

		void deleteAll(){
			head = null;
			// all nodes will be GC
		}

		void deleteAtPos( int pos){


			//case 1 if list is empty OR pos < 1 => throw exception
					if( head == null  || pos < 1 ) {
						throw new RuntimeException("deletion:  list is empty OR Invalid position !!!!");
					}
			// case 2: pos = 1 => delete first node
				if( pos == 1){
					deleteFirst();
				}

			// traverse till pos using trav , tale temp with him
			Node temp = null;
			Node trav = head;
			for( int i =1; i < pos ;i++){
				// case 3: pos is beyond length; throw exception
				if( trav == null){
					throw new RuntimeException("Invalid position!!");
				}
				temp = trav;
				trav = trav.next;
			}
			// trav is node to be deleted
			// temp is node before that

			temp.next = trav.next;

			// trav node will be GC
		}

		void deleteLast(){
			Node temp = null , trav = head;

			//if empty list
			if(head == null){
				throw new RuntimeException("list is empty");
			}
			// only one element in list
			if(head.next == null){
				head = head.next;
			}else {
			while(trav.next != null ){
				temp = trav;
				trav = trav.next;
			}

			temp.next = null; 
			}
		}

}

class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int chioce;
		int val , pos;

		SinglyList list = new SinglyList();
		do{
			System.out.println("\n0: Exit.\n1.Display\n2.Add First\n3. Add Last\n4.Add at Pos\n5. Delete First\n6. Delete Last\n7. Delete at Pos\n8. Delete All");

			chioce = sc.nextInt();
			switch (chioce) {
				case 1: // Display
						list.display();
					break;
				case 2:  System.out.println("Enter data: ");

					list.addFirst(sc.nextInt());
					break;
				case 3: 
					System.out.println("Enter data: ");
					 val = sc.nextInt();
					list.addLast(val);
					break;
				case 4:
					System.out.println("Enter element: ");
					 val = sc.nextInt();
					System.out.println("Enter element position: ");
					 pos = sc.nextInt();
					list.addAtPos(val , pos);
					break;

				case 5:
						try{
						list.deleteFirst();
						System.out.println("first element is deleted!!!");
						}catch(Exception e){
							System.out.println(e.getMessage());
						}
				break;
				case 6: // list.deleteLast();
						System.out.println("last element is deleted!!!");
					break;
				case 7: 
						System.out.println("enter position to be deleted");
						pos = sc.nextInt();
						try{
							list.deleteAtPos(pos);
					System.out.println("element is deleted!!!");
					
						}catch(Exception e){
							System.out.println(e.getMessage());
						}
					break;
				case 8:  list.deleteAll();
					break;

			}

		}while(chioce != 0);
		sc.close();


			}
}