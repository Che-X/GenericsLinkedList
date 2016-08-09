// LinkedList.java
// ===============
// Generics

import java.io.*;

class node<AnyType> {

	AnyType data;
	node<AnyType> next;
	
	node(AnyType data) {
		this.data = data;
	}
}

public class LinkedList<AnyType> {

	private node<AnyType> head, tail;

	// insert at the tail of the list
	void insert(AnyType data) {
		
		// if the list is empty, set 'head' and 'tail' to the new node
		if (head == null) {
			head = tail = new node<AnyType>(data);
		}
		// otherwise, append the new node to the end of the list and move the
		// tail reference forward
		else {
			tail.next = new node<AnyType>(data);
			tail = tail.next;
		}
	}

	// insert at the head of the list
	void headInsert(AnyType data) {
		// first, create the node to be inserted
		node<AnyType> YouCanJustMakeANewNode = new node<AnyType>(data);

		// insert it at the beginning of the list
		YouCanJustMakeANewNode.next = head;
		head = YouCanJustMakeANewNode;

		// if the list was empty before adding this node, 'head' AND 'tail'
		// need to reference this new node
		if (tail == null)
			tail = YouCanJustMakeANewNode;
	}

	// print the contents of the linked list
	void printList() {
		for (node<AnyType> temp = head; temp != null; temp = temp.next)
			System.out.print(temp.data + " ");
		System.out.println();
	}

	// Remove the head of the list (and return its 'data' value).
	AnyType removeHead() {
		// if the list is empty, signify that by returning null
		if (head == null)
			return null;

		AnyType temp = head.data;
		head = head.next;

		if (head == null)
			tail = null;
		
		// Return the value from the old head node.
		return temp;
	}

	// returns true if the list is empty, false otherwise
	boolean isEmpty() {
		return (head == null);
	}

	public static void main(String [] args) {

		// create a new linked list that holds integers
		LinkedList<Integer> L1 = new LinkedList<Integer>();
		
		for (int i = 0; i < 10; i++)
		{
			// this inserts random values on the range [1, 100]
			int SomeRandomJunk = (int)(Math.random() * 100) + 1;
			System.out.println("Inserting " + SomeRandomJunk);
			L1.insert(SomeRandomJunk);
		}

		// print the list to verify everything got in there correctly
		L1.printList();


		// create another linked list (this time, one that holds strings)
		LinkedList<String> L2 = new LinkedList<String>();
		
		L2.insert("Thierry");

		// print the new list to verify everything got in there correctly
		while (!L2.isEmpty())
			System.out.print(L2.removeHead() + " ");
		System.out.println();

		L1.printList();
	}
}
