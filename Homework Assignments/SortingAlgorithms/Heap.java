// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System. 

import java.util.Arrays;

public class Heap {

	static int swaps = 0;
	
	public static void exch(Object[] a, int i, int j) {
		Object swap = a[i-1];
		a[i-1] = a[j-1];
		a[j-1] = swap;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	// make static and pass arguments
	private static void sink(Comparable[] a, int k, int n) {
		while (2*k <= n) {
			int j = 2*k;
			if (j < n && less(a[j-1], a[j])) j++;
			if (!less(a[k-1], a[j-1])) break;
			exch(a, k, j);
			k = j;
		}
	}
	
	public static void sort(Comparable[] a) {
		int n = a.length;
		for (int k = n/2; k >= 1; k--) {
			sink(a, k, n);
		}
		while (n > 1) {
			exch(a, 1, n);
			sink(a, 1, --n);
			swaps++;
		}
		System.out.println(swaps);
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {5, 1, 4, 3, 2};
		
		
		System.out.println(Arrays.toString(arr));
	}

}
