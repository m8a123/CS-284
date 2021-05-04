// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System. 


public class Firstnames implements Comparable<Firstnames>{
	public final String name;
	
	public Firstnames(String name) {
		this.name = name;
	}
	
	public int compareTo(Firstnames that) {
		int compare = this.name.compareTo(that.name);
		if (compare < 0) {
			return -1;
		}
		if (compare > 0) {
			return +1;
		}
		return 0;
	}

}
