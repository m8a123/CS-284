package HW3;
//Mehta Nimtrakul
//I pledge my honor that I have abided by the Stevens Honor System.


public class MyStackArray<Item> {
	
	private Item[] s;
	private int N = 0;
	
	@SuppressWarnings("unchecked")
	public MyStackArray() {
		s = (Item[]) new Object[N];
		
	}
	
	public boolean isEmpty() {
		return N == 0;
	}

	public void push(Item item) {
		if (N == 0) {
			resize(1);
		}
		else if (N == s.length) {
			resize(2 * s.length);
		}
		s[N++] = item;
		
	}
	
	public void resize(int capacity) {
		@SuppressWarnings("unchecked")
		Item[] copy = (Item[]) new Object[capacity];
		for (int i = 0; i < N; i++) {
			copy[i] = s[i];
		}
		s = copy;
		
	}
	
	public Item pop() {
		assert !isEmpty() : "Cannot pop, stack is empty";
		Item item = s[--N];
		s[N] = null;
		if (N > 0 && N == s.length/4) {
			resize(s.length/2);
		}
		return item;
	}
	
	public int getLength() {
		return s.length;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyStackArray<Integer> stack1 = new MyStackArray<Integer>();
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		System.out.println(stack1.getLength());
		stack1.push(3);
		stack1.push(4);
		System.out.println(stack1.getLength());
		for(int i = 0; i < 4; i++) {
			stack1.pop();
		}
		System.out.println(stack1.getLength());
		

	}

}
