// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System. 


import java.util.Arrays;

public class Merge {

	static int swaps = 0;
	
	private static boolean less(Comparable v, Comparable w) {
		return v.compareTo(w) < 0;
	}
	
	private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid , int hi) {
		for (int k = lo; k <= hi; k++)
			aux[k] = a[k];
		
		int i = lo, j = mid+1;
		for (int k = lo; k <= hi; k++) {
			if (i > mid)					a[k] = aux[j++];
			else if (j > hi)				a[k] = aux[i++];
			// put swap # under
			else if (less(aux[j], aux[i])) {
				a[k] = aux[j++];
				swaps++;
			}
			else							{
				a[k] = aux[i++];
				swaps++;
			}
		}
		System.out.println(swaps);
	}
	
	private static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
		if (hi <= lo) return;
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		merge(a, aux, lo, mid, hi);
	}
	
	public static void sort(Comparable[] a) {
		Comparable[] aux = new Comparable[a.length];
		sort(a, aux, 0, a.length - 1);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {5, 1, 4, 3, 2};
		
		
		System.out.println(Arrays.toString(arr));

	}

}
