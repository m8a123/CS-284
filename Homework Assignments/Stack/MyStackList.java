package HW3;
// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System.


public class MyStackList<Item> {
	private Node first = null;
	
	private class Node{
		Item item;
		Node next;
	}

	public boolean isEmpty() {
		return first == null;
	}
	
	public void push(Item item) {
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
	}
	
	public Item pop() {
		Item item = first.item;
		first = first.next;
		return item;
	}
	
	public static void main(String args[]) {
		
	}
}
