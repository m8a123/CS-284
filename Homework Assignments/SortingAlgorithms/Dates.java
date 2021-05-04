// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System. 

public class Dates implements Comparable<Dates>{
	public final int month, day, year;
	
	public Dates(int m, int d, int y) {
		month = m; 
		day = d;
		year = y;
	}
	
	public int compareTo(Dates that) {
		if (this.year < that.year) return -1;
		if (this.year > that.year) return +1;
		if (this.month < that.month) return -1;
		if (this.month > that.month) return +1;
		if (this.day < that.day) return -1;
		if (this.day > that.day) return +1;
		return 0;
	}

}
