package HW2;

import java.util.*;
import java.util.ArrayList;

// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System.

public class IDLList<E> {

	// data fields
    private Node<E> head;
    private Node<E> tail;
    private int size;
    private ArrayList<Node<E>> indicies;
    
    public class Node<E>{
        //inner class data fields
        E data;
        Node<E> next;
        Node<E> prev;


        public Node(E elem){
            this.data = elem;
            // since element is given prev and next are null
            this.next = null;
            this.prev = null;
        }

        public Node(E elem, Node<E> prev, Node<E> next){
            // set the data fields
            // since element and prev and next are given set all values
        	this.data = elem;
        	this.prev = prev;
        	this.next = next;

        }

    }
    
    public IDLList(){
    	this.head = null;
    	this.tail = null;
    	this.size = 0;
    	
    	this.indicies = new ArrayList<Node<E>>();
    	
    }
    
    public boolean add(int index, E elem) {
    	// index out of bounds
    	if (index < 0 || index >= this.size+1) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
    	}
    	// adding index > 0 with empty list
    	if (this.size == 0 && index != 0) {
    		throw new IllegalArgumentException("Cannot add element of index > 0 when empty");
    	}
    	// adding index 0 to empty list
    	if (this.size == 0 && index == 0) {
    		Node<E> node = new Node<E>(elem, null, null);
    		this.head = node;
    		this.tail = node;
    		this.indicies.add(node);
    		this.size += 1;
    		return true;
    	}
    	// adding to the beginning
    	if (index == 0 && this.size > 0) {
    		Node<E> oldfirst = this.indicies.get(0);
    		Node<E> first = new Node<E>(elem, null, oldfirst);
    		this.head = first;
    		oldfirst.prev = first;
    		this.indicies.add(0, first);
    		this.size += 1;
    		return true;
    	}
    	// adding to the end
    	if (index == this.size) {
    		Node<E> oldlast = this.indicies.get(this.size-1);
    		Node<E> last = new Node<E>(elem, oldlast, null);
    		oldlast.next = last;
    		this.tail = last;
    		this.indicies.add(last);
    		this.size += 1;
    		return true;
    		
    	}
    	
    	// adding in the middle
    	if (index > 0 && index < this.size) {
    		Node<E> node = new Node<E>(elem, this.indicies.get(index-1), this.indicies.get(index));
    		this.indicies.get(index-1).next = node;
    		this.indicies.get(index).prev = node;
    		this.indicies.add(index ,node);
    		this.size += 1;
    		return true;
    	}
    	
    	return true;
    }
    
    public boolean add(E elem) {
    	// prepends
    	add(0, elem);
    	return true;
    }
    
    public boolean append(E elem) {
    	// appends to end
    	add(this.size, elem);
    	return true;
    }
    
    
    public E get(int index) {
    	if (index < 0 || index > this.size - 1) {
    		throw new IndexOutOfBoundsException("Index out of bounds");
    	}
    	E temp = this.indicies.get(index).data;
    	return temp;
    	
    }
    
    
    public E getHead(){
        // check if head == null, throw exception
        // if not, return head.data
    	if (this.head == null) {
    		throw new NullPointerException("head is null");
    	}
    	else {
    		return this.head.data;
    	}
    }

    public E getLast(){
        // check if tail is null, throw exception
        // else return tail.data
    	if (this.tail == null) {
    		throw new NullPointerException("Tail is null");
    	}
    	else{
    		return this.tail.data;
    	}
    }

    public int size(){
        //return this.size
    	return this.size;
    }
    
    public E remove() {
    	// empty list
    	if (this.head == null || this.size == 0) {
    		throw new IllegalStateException("List is empty, there is no head");
    	}
    	// only one node
    	if (this.size == 1) {
    		E temp = get(0);
    		this.indicies.remove(0);
    		this.head = null;
    		this.tail = null;
    		this.size -= 1;
    		return temp;
    	}
    	else {
    		E temp = get(0);
    		// normal removal
    		this.head = this.head.next;
    		this.size -= 1;
    		// change
    		this.indicies.remove(0);
    		// change
    		return temp;
    	}
    	
    }
    
    public E removeLast() {
    	if (this.head == null || this.size == 0) {
    		throw new IllegalStateException("List is empty");
    	}
    	// only one node
    	else if (this.size == 1) {
    		E temp = get(this.size-1);
    		this.head = null;
    		this.tail = null;
    		this.indicies.remove(this.size-1);
    		this.size -= 1;
    		return temp;
    	}
    	else {
    		E temp = get(this.size-1);
    		this.tail = this.indicies.get(size-2);
    		this.indicies.remove(this.size-1);
    		this.tail.next = null;
    		this.size -= 1;
    		return temp;
    	}
    	
    }
    
    public E removeAt(int index) {
    	if (this.size == 0) {
    		throw new IllegalStateException("Cannot insert element at given index with empty list");
    	}
    	if (index < 0 || index > this.size - 1) {
    		throw new IllegalStateException("Index out of bounds");
    	}
    	if (this.size == 1 && index != 0) {
    		throw new IllegalStateException("Index needs to be 0 if size is 1");
    	}
    	if (this.size == 1 && index == 0) {
    		// remove node
    		return this.remove();
    	}
    	else {
    		if (index == 0) {
    			return this.remove();
    		}
    		else if (index == this.size - 1) {
    			return this.removeLast();
    		}
    		
    		E temp = get(index);
    		this.indicies.get(index-1).next = this.indicies.get(index+1);
    		this.indicies.get(index+1).prev = this.indicies.get(index-1);
    		this.indicies.remove(index);
        	size -= 1;
        	return temp;
    		
    	}
    	
    }
    
    public boolean remove(E elem) {
    	Node<E> curr = this.head;
    	int index = 0;
    	
    	while (curr != null) {
    		if(curr.data == elem) {
    			 if(this.size == 1) {
    				 this.remove();
        			 return true;
    			 }
    			 if(index == this.size-1) {
    				 this.removeLast();
    				 return true;
    			 }
    			 else {
    				 this.removeAt(index);
    				 return true;
    			 }
    			 
    		}
    		curr = curr.next;
    		index++;
    	}
    	return false;
    }
    
    
    
    public String toString() {
    	String s = "";
    	Node<E> headRef = this.head;
    	Node<E> temp = this.head;
    	while(temp != null){
    		s += temp.data.toString();
    		s += " -> ";
    		temp = temp.next;
    	}
    	this.head = headRef;
    	return s;
    }
	
	public static void main(String[] args) {
		IDLList<Integer> list = new IDLList<Integer>();
		
		list.add(0, 1);
		list.add(1, 2);
		list.add(2, 3);
		list.add(3, 4);
//		list.append(5);

		System.out.println(list.remove(4));

		System.out.println(list.tail.data);
		
		
		System.out.println(list.toString());
		
		
	}

}
