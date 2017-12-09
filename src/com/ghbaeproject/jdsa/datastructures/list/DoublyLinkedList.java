package com.ghbaeproject.jdsa.datastructures.list;

/********************************************************************************
 * DoublyLinkedList.java
 * 
 *      Author: Guhwan Bae, 2017. 09. 20
 *
 * This data structure is a linked data structure that consists of a set of 
 * sequentially linked records called nodes. Each node contains two fields,
 * called links, that are references to the previous and to the next node in
 * the sequence of nodes. 
 *  
 * Input Variables: 
 * 
 * Output Variables: 
 * 
 * Constants: 
 * 
 * Local Variables:
 * 
 * Required Subroutines/Functions: 
 * 
 * Output Files: 
 * 
 * References: 
 * 
 * Documentation: 
 *		None
 * 
 ********************************************************************************/

public class DoublyLinkedList<T> {
	
	private Node<T> head;
	private Node<T> tail;
	
	// Re-define : Generic type node
	private class Node<T> {
		private T keyVal;
		private Node<T> next;
		private Node<T> prev;
		
		private Node() {
			this.keyVal = null;
			this.next = null;
			this.prev = null;
		}
		
		private Node(T newKeyVal) {
			this();
			this.keyVal = newKeyVal;
		}
		
		private Node(T newKeyVal, Node<T> next, Node<T> prev) {
			this(newKeyVal);
			this.next = next;
			this.prev = prev;
		}
	}

	public DoublyLinkedList() {
		// Make empty list!
		head = null;
		tail = head;
	}
	
	public DoublyLinkedList(T newKeyVal) {
		head = new Node<T>(newKeyVal);
		tail = head;
	}
	
	public DoublyLinkedList(T newKeyVal, Node<T> next, Node<T> prev) {
		head = new Node<T>(newKeyVal, next, prev);
		tail = head;
	}
	
	// insert to tail
	public boolean insertT(T newKeyVal) {
		if(head == null && tail == null) {
			head = new Node<T>(newKeyVal, null, null);
			tail = head;
			return true;
		}
		
		Node<T> temp = new Node<T>(newKeyVal, null, tail);
		tail.next = temp;
		tail = temp;
		
		return true;
	}
	
	// insert to head
	public boolean insertH(T newKeyVal) {
		if(head == null && tail == null) {
			head = new Node<T>(newKeyVal, null, null);
			tail = head;
			return true;
		}
		
		Node<T> temp = new Node<T>(newKeyVal, head, null);
		head.prev = temp;
		head = temp;
		
		return true;
	}
	
	// insert to Head with Checking duplicate key
	public boolean insertHCD(T newKeyVal) {
		Node<T> temp = head;
		
		while(temp != null) {
			if(temp.keyVal == newKeyVal) {
				System.out.println("Duplicate key : " + temp.keyVal);
				return false;
			}
			temp = temp.next;
		}
		
		temp = new Node<T>(newKeyVal, head, null);
		head.prev = temp;
		head = temp;
		
		return true;
	}
	
	public boolean insertAt(int index, T newKeyVal) {
		if(index == 0) {
			head = new Node<T>(newKeyVal, head, null);
			tail = head;
			return true;
		}
		Node<T> temp = head, toBePrev = head;
		
		int i;
		for(i=0; i < index && temp != null; ++i) {
			toBePrev = temp;
			temp = temp.next;
		}
		
		if(i != index) {
			System.out.println("Invalid position(" + index + "): Current size is " + i);
			return false;
		}
		else {
			if(temp == null) {
				toBePrev.next = new Node<T>(newKeyVal, null, toBePrev);
				tail = toBePrev.next;
			}
			else {
				toBePrev.next = new Node<T>(newKeyVal, temp, toBePrev);
				temp.prev = toBePrev.next;
			}
			return true;
		}
	}
	
	public Node<T> search(T keyVal) {
		int index=0;
		Node<T> cur = head;
		while(cur != null) {
			if(cur.keyVal == keyVal) {
				System.out.println("Success! " + "Index of " + keyVal + " is " + index);
				return cur;
			}
			++index;
			cur = cur.next;
		}
		System.out.println("No entry found. The keyval " + keyVal + " was not found in this list.");
		return null;
	}
	
	public boolean removeT() {
		if(head == null && tail == null) {
			System.out.println("Failed : Empty list!");
			return false;
		}
		
		Node<T> temp = tail.prev;
		temp.next = null;
		tail = null;
		tail = temp;
		
		return true;
	}
	public boolean removeH() {
		if(head == null && tail == null) {
			System.out.println("Failed : Empty list!");
			return false;
		}
		
		Node<T> temp = head.next;
		temp.prev = null;
		head = null;
		head = temp;
		
		return true;
	}
	// Find keyVal and remove.
	public boolean remove(T keyVal) {
		Node<T> toBeDeleted = head;
		while(toBeDeleted != null && toBeDeleted.keyVal != keyVal) {
			toBeDeleted = toBeDeleted.next;
		}
		
		if(toBeDeleted == null) {
			System.out.println("Failed : No entry found. The keyval " + keyVal + " was not found in this list.");
			return false;
		}
		else {
			if(toBeDeleted == head && toBeDeleted == tail) {
				head = null;
				tail = null;
			}
			else if(toBeDeleted == head) {
				head = toBeDeleted.next;
				head.prev = null;
			}
			else if(toBeDeleted == tail) {
				tail = toBeDeleted.prev;
				tail.next = null;
			}
			else {
				toBeDeleted.prev.next = toBeDeleted.next;
				toBeDeleted.next.prev = toBeDeleted.prev;
			}
		}
		return true;
	}
	
	public void traverse() {
		System.out.println("Traverse from head.");
		System.out.println("Head is "+head.keyVal +".");
		Node<T> temp = head;
		while(temp != null) {
			if(temp.next == null) {
				System.out.println(temp.keyVal);
				System.out.println("End point of list.");
				break;
			}
			else {
				System.out.print(temp.keyVal + " <-> ");
			}
			temp = temp.next;
		}
	}
	
	public void traveFromBackword() {
		System.out.println("Traverse from tail.");
		System.out.println("Tail is "+tail.keyVal +".");
		Node<T> temp = tail;
		while(temp != null) {
			if(temp.prev == null) {
				System.out.println(temp.keyVal);
				System.out.println("Starting point of list.");
			}
			else {
				System.out.print(temp.keyVal + " <-> ");
			}
			temp = temp.prev;
		}
	}
	
}
