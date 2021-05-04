package HW2;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IDLListTest {

	@Test
	void testAdd() {
		
		// test for add(int index, E elem)
		// covers both add(E elem) and append(E elem) because I call the original add function
		// check if head is set
		IDLList<Integer> list = new IDLList<Integer>(); 
		list.add(0, 1);
		int expected = 1;
		int actual = list.getHead();
		assertEquals(expected, actual);
		// check if tail is set
		int expected2 = 1;
		int actual2 = list.getLast();
		assertEquals(expected2, actual);
		
		// adding to the beginning
		IDLList<Integer> list2 = new IDLList<Integer>(); 
		list2.add(0, 1);
		list2.add(0, 2);
		list2.add(0, 3);
		int expected3 = 3;
		int actual3 = list2.getHead();
		// check if numbers are added to the beginning each time
		assertEquals(expected3, actual3);
		
		// check if tail is 1, since they keep appending
		int expected4 = 1;
		int actual4 = list2.getLast();
		assertEquals(expected4, actual4);
		
		// adding to the end
		IDLList<Integer> list3 = new IDLList<Integer>(); 
		list3.add(0, 1);
		list3.add(1, 2);
		list3.add(2, 3);
		
		// check if tail was updated
		int expected5 = 3;
		int actual5 = list3.getLast();
		assertEquals(expected5, actual5);
		// check if head was set
		int expected6 = 1;
		int actual6 = list3.getHead();
		assertEquals(expected6, actual6);
		
		// adding in the middle
		IDLList<Integer> list4 = new IDLList<Integer>(); 
		list4.add(0, 1);
		list4.add(1, 2);
		list4.add(2, 3);
		list4.add(2, 10);
		// check if get method retrieves correct data at index inserted
		int expected7 = 10;
		int actual7 = list4.get(2);
		assertEquals(expected7, actual7);
		// checks size
		assertEquals(4, list4.size());
		// These cases cover add(int index ,E elem), add(E elem), append(E elem), get(), getHead(), getLast(), size()
		// ************************************************************************************************************
		IDLList<Integer> myIntList = new IDLList<Integer>();        
		myIntList.add(0, 1);        
		myIntList.add(1, 2);        
		myIntList.add(2, 4);        
		myIntList.add(2, 3);
		int[] resultsInt = {1,2,3,4};
		for (int i=0; i<myIntList.size(); i++) {            assertEquals(myIntList.get(i), resultsInt[i]);        }
		IDLList<String> myStrList = new IDLList<String>();        
		myStrList.add(0, "cat");        
		myStrList.add(1, "bat");        
		myStrList.add(2, "mat");        
		myStrList.add(2, "hat");
		String[] resultsStr = {"cat", "bat", "hat", "mat"};        
		for (int i=0; i<myStrList.size(); i++) {            assertEquals(myStrList.get(i), resultsStr[i]);        }
		myStrList.add("first");
		assertTrue(myStrList.add(3, "extra"));
		assertEquals(myStrList.get(0), "first");
		
		IDLList<Integer> myIntList2 = new IDLList<Integer>();
        myIntList2.add(0, 1);
        myIntList2.add(1, 2);
        myIntList2.add(2, 4);
        myIntList2.add(2, 3);
        myIntList2.append(5);


        assertEquals(myIntList2.get(myIntList2.size()-1), 5);
	}
	
    @org.junit.jupiter.api.Test
    void append() {
        // Testing method add(int index, E elem) int
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(0, 1);
        myIntList.add(1, 2);
        myIntList.add(2, 4);
        myIntList.add(2, 3);
        myIntList.append(5);


        assertEquals(myIntList.get(myIntList.size()-1), 5);
    }
    @org.junit.jupiter.api.Test
    void get() {
        // test getting valid values
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(0, 1);
        myIntList.add(1, 2);
        myIntList.add(2, 4);
        myIntList.add(2, 3);

        int[] resultsInt = {1,2,3,4};
        for (int i=0; i<myIntList.size(); i++) {
            assertEquals(myIntList.get(i), resultsInt[i]);
        }

        // test with invalid indices
        assertThrows(IndexOutOfBoundsException.class, () -> myIntList.get(10));
        assertThrows(IndexOutOfBoundsException.class, () -> myIntList.get(-1));
    }
    @org.junit.jupiter.api.Test
    void getHead() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        assertEquals(myStrList.getHead(), "cat");

        // for empty list
        IDLList<String> myStrList2 = new IDLList<String>();
        assertThrows(NullPointerException.class, () -> myStrList2.getHead());
    }
	
    @org.junit.jupiter.api.Test
    void getLast() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        assertEquals(myStrList.getLast(), "mat");

        // for empty list
        IDLList<String> myStrList2 = new IDLList<String>();
        assertThrows(NullPointerException.class, () -> myStrList2.getLast());
    }
    @org.junit.jupiter.api.Test
    void size() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        assertEquals(myStrList.size(), 4);
    }
    // failed
    @org.junit.jupiter.api.Test
    void remove() {
        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        myStrList.remove();

        String[] results = {"bat", "hat", "mat"};
        for (int i=0; i<3; i++) {
            assertEquals(myStrList.get(i), results[i]);
        }

        // test for empty string
        IDLList<Integer> myIntList = new IDLList<Integer>();
        assertThrows(IllegalStateException.class, () -> myIntList.remove());

    }
    
    @org.junit.jupiter.api.Test
    void removeLast() {

        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        myStrList.removeLast();

        String[] results = {"cat", "bat", "hat"};
        for (int i=0; i<3; i++) {
            assertEquals(myStrList.get(i), results[i]);
        }

        // test for empty string
        IDLList<Integer> myIntList = new IDLList<Integer>();
        assertThrows(IllegalStateException.class, () -> myIntList.removeLast());
    }
	
    @org.junit.jupiter.api.Test
    void removeAt() {

        IDLList<String> myStrList = new IDLList<String>();
        myStrList.add(0, "cat");
        myStrList.add(1, "bat");
        myStrList.add(2, "mat");
        myStrList.add(2, "hat");

        myStrList.removeAt(1);

        String[] results = {"cat", "hat", "mat"};
        for (int i=0; i<3; i++) {
            assertEquals(myStrList.get(i), results[i]);
        }

        // test for empty list
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(10);
        assertThrows(IllegalStateException.class, () -> myIntList.removeAt(10));

    }
    
    @org.junit.jupiter.api.Test
    void testRemove2() {
        // remove first occurrence of element
        IDLList<Integer> myIntList = new IDLList<Integer>();
        myIntList.add(0, 1);
        myIntList.add(1, 2);
        myIntList.add(2, 2);
        myIntList.add(2, 3);

        // remove entry and check return
        assertTrue(myIntList.remove(2));
        assertFalse(myIntList.remove(-1));

        int[] results = {1,3,2};
        for (int i=0; i<3; i++) {
            assertEquals(myIntList.get(i), results[i]);
        }
    }
	@Test
	void testRemove() {
		IDLList<Integer> list = new IDLList<Integer>(); 
		list.add(0, 1);
		// testing if return value is 1 
		assertEquals(list.remove(), 1);
		IDLList<Integer> list2 = new IDLList<Integer>(); 
		list2.add(0, 1);
		list2.add(1, 2);
		assertEquals(list2.remove(), 1);
		// check if size is decremented
		assertEquals(1, list2.size());
		
		// testing removeLast
		IDLList<Integer> list3 = new IDLList<Integer>(); 
		list3.add(0, 1);
		list3.add(1, 2);
		// check if removed element is 2
		assertEquals(list3.removeLast(), 2);
		// check if tail is updated to data of 1, replacing 2
		assertEquals(list3.getLast(), 1);
		
		// testing removeAt for a middle element, since remove() and removeLast() handle the first and last elements.
		IDLList<Integer> list4 = new IDLList<Integer>(); 
		list4.add(0, 1);
		list4.add(1, 2);
		list4.add(2, 3);
		
		assertEquals(list4.removeAt(1), 2);
		
		// testing remove(E elem)
		IDLList<Integer> list5 = new IDLList<Integer>(); 
		list5.add(0, 1);
		list5.add(1, 2);
		list5.add(2, 3);
		
		assertEquals(list5.remove(2), true);
		assertEquals(list5.toString(), "1 -> 3 -> ");
		
		
		
	}
	@Test
	void testToString() {
		IDLList<Integer> list5 = new IDLList<Integer>(); 
		list5.add(0, 1);
		list5.add(1, 2);
		list5.add(2, 3);
		
		assertEquals(list5.toString(), "1 -> 2 -> 3 -> ");
	}

}
