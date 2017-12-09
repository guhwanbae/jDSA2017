package com.ghbaeproject.jdsa.datastructures;

import com.ghbaeproject.jdsa.datastructures.list.DoublyLinkedList;;

public class jDSA2017 {

	public static void main(String[] args) {
		// Test code.
		DoublyLinkedList<String> dll = new DoublyLinkedList<String>();
		dll.insertT("Amy");
		dll.insertT("Baust");
		dll.insertT("Cindy");
		dll.insertT("David");
		dll.insertT("Eros");
		dll.insertT("Frost");
		dll.insertT("Geremy");
		dll.insertT("Harber");
		dll.insertT("Issac");
		dll.insertT("James");
		dll.insertT("Karman");
		dll.insertT("Lee");
		dll.insertT("Mitsubishi");
		dll.insertT("Ng");
		dll.insertT("Omansa");
		dll.insertT("Peter");
		dll.insertT("Qi");
		
		dll.traverse();
		
		dll.traveFromBackword();
		
		dll.remove("Baust");
		dll.insertAt(1, "Bill");
		dll.insertAt(2, "Bruce");
		dll.insertAt(1, "Brew-master");
		
		dll.traverse();
		
		dll.search("Brew-master");
		dll.search("Bruce");
		dll.search("Bill");
		dll.search("Ng");
		
		dll.search("NoNo");
		// Test code end.
	}

}
