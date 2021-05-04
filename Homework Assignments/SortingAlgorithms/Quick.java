// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System. 

import java.util.*;

public class Quick {
	
	static int swaps = 0;
	
	public static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}

	private static int partition(Comparable[] a, int lo, int hi) {
		Comparable pivot = a[hi];
		int i = (lo - 1);
		
		for (int j = lo; j < hi; j++) {
			if (less(a[j], pivot)) {
				i++;
				exch(a, i, j);
				swaps++;
			}
		}
		
		exch(a, i+1, hi);
		swaps++;
		
		return i + 1;
	}
	
	public static void sort(Comparable[] a) {
		StdRandom.shuffle(a);
		sort(a, 0, a.length - 1);
		System.out.println(swaps);
	}
	
	private static void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo) return;
		int j = partition(a, lo, hi);
		sort(a, lo, j-1);
		sort(a, j+1, hi);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {5, 1, 4, 3, 2};
		
		
		System.out.println(Arrays.toString(arr));

	}

}
