// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System. 


import java.util.Arrays;
import java.util.*;

public class Selection {
	
	static int swaps = 0;
	
	public static void exch(Object[] a, int i, int j) {
		Object swap = a[i];
		a[i] = a[j];
		a[j] = swap;
	}
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	public static void sort(Comparable[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i+1; j < N; j++) {
				if (less(a[j], a[min]))
					min = j;
			}
			exch(a, i, min);
			swaps++;
		}
		System.out.println(swaps);
	}
	public static void main (String[] args) {
		
		
		Long[] arr = new Long[] {5l, 1l, 4l, 3l, 2l};
	
		
//		System.out.println(Arrays.toString(arr));
		
	}
	
}
