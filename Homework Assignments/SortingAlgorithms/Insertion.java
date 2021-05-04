// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System. 


import java.util.Arrays;
import java.util.*;

public class Insertion {
	
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
			for (int j = i; j>0; j--) {
				if(less(a[j], a[j-1])) {
					exch(a, j, j-1);
					swaps++;
				}
				else break;
			}
		}
		System.out.println(swaps);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		Integer[] arr = new Integer[] {5, 1, 4, 3, 2};
		
		
//		System.out.println(Arrays.toString(arr));

	}

}
