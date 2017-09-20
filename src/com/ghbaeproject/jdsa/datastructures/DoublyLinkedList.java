package com.ghbaeproject.jdsa.datastructures;

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

public class DoublyLinkedList {
	
	
	private Node head;
	private Node tail;
	
	private class Node {
		private int keyVal;
		private Node next;
		private Node prev;
		
		private Node() {
			this.keyVal = 0;
			this.next = null;
			this.prev = null;
		}
		
		private Node(int newKeyVal) {
			this();
			this.keyVal = newKeyVal;
		}
		
		private Node(int newKeyVal, Node next, Node prev) {
			this(newKeyVal);
			this.next = next;
			this.prev = prev;
		}
	}

	public DoublyLinkedList() {
		head = new Node();
		tail = head;
	}
	
	public DoublyLinkedList(int newKeyVal) {
		head = new Node(newKeyVal);
		tail = head;
	}
	
	public DoublyLinkedList(int newKeyVal, Node next, Node prev) {
		head = new Node(newKeyVal, next, prev);
		tail = head;
	}
	
	public boolean insert(int newKeyVal) {
		Node temp = head;
		
		while(temp != null) {
			if(temp.keyVal == newKeyVal) {
				System.out.println("Duplicate key : " + temp.keyVal);
				return false;
			}
			temp = temp.next;
		}
		
		temp = new Node(newKeyVal, head, null);
		head.prev = temp;
		head = temp;
		
		return true;
	}
	
	public boolean insertAt(int index, int newKeyVal) {
		if(index == 0) {
			head = new Node(newKeyVal, head, null);
			return true;
		}
		else {
			Node temp = head, toBePrev = head;
			
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
					toBePrev.next = new Node(newKeyVal, null, toBePrev);
					tail = toBePrev.next;
				}
				else {
					toBePrev.next = new Node(newKeyVal, temp, toBePrev);
					temp.prev = toBePrev.next;
				}
				return true;
			}
		}
	}
	
	public Node search(int keyVal) {
		Node cur = head;
		while(cur != null) {
			if(cur.keyVal == keyVal) {
				System.out.println("Success!");
				return cur;
			}
			cur = cur.next;
		}
		System.out.println("No entry found.");
		return null;
	}
	
	public boolean remove(int keyVal) {
		Node toBeDeleted = head;
		while(toBeDeleted != null && toBeDeleted.keyVal != keyVal) {
			toBeDeleted = toBeDeleted.next;
		}
		
		if(toBeDeleted == null) {
			System.out.println("No entry found.");
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
		Node temp = head;
		while(temp != null) {
			if(temp.next == null) {
				System.out.println(temp.keyVal);
			}
			else {
				System.out.print(temp.keyVal + " <-> ");
			}
			temp = temp.next;
		}
	}
	
	public void traveFromBackword() {
		Node temp = tail;
		while(temp != null) {
			if(temp.prev == null) {
				System.out.println(temp.keyVal);
			}
			else {
				System.out.print(temp.keyVal + " <-> ");
			}
			temp = temp.prev;
		}
	}
	
	public void nteset() {
		DoublyLinkedList DLL = new DoublyLinkedList(1);
		for(int i=0; i < 100; ++i) {
			
		}
	}
}
