package HW3;
import java.util.*;
import java.lang.*;
//Mehta Nimtrakul
//I pledge my honor that I have abided by the Stevens Honor System.

public class ArithSolver {
	
	// check if expression has numbers with more than single digits
	//(1.2+1)
	public boolean multiDigits(String s) {
		boolean flag = false;
		for (int i = 0; i < s.length()-1; i++) {
			String c = String.valueOf(s.charAt(i));
		
			if (c.equals("(") || c.equals(")") || c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
				continue;
			}
            if ((s.charAt(i) >= '0' && s.charAt(i) <= '9' && s.charAt(i+1) >= '0' && s.charAt(i+1) <= '9') || c.equals(".")) {
                flag = true;
            }
	}
		return flag; 
	}
	
	// check if expression is correct for bad input
	public boolean isExpression(String s) {
		
		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			if (!c.equals("(") && !c.equals(")") && !c.equals("+") && !c.equals("-") && !c.equals("*") && !c.equals("/") && !c.equals(".") && 
					!Character.isDigit(s.charAt(i))) {
				return false;
			}
		}
		return true;
	}
	
	public double Dijkstra(String s) {
		MyStackList<String> ops = new MyStackList<String>();
		MyStackList<Double> vals = new MyStackList<Double>();
		if (isExpression(s)) {
		if (!multiDigits(s)) {
		for (int i = 0; i < s.length(); i++) {
			String c = String.valueOf(s.charAt(i));
			if (c.equals("(")) continue;
			else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
				
				ops.push(c);
			}
			else if (c.equals(")")) {
				String op = ops.pop();
				double val = vals.pop();
				
				if (op.equals("+")) {
					val = vals.pop() + val;	
				}
				else if (op.equals("-")) {
					val = vals.pop() - val;
				}
				else if (op.equals("*")) {
					
					val = vals.pop() * val;
				}
				else if (op.equals("/")) {
					val = vals.pop() / val;
				}
				vals.push(val);
			}
			else {
				vals.push(Double.parseDouble(c));
			}
		}
		
		}
		
		// handling multiple digits
		// "(1+130)"
		if (multiDigits(s)) {
			for (int i = 0; i < s.length(); i++) {
				String c = String.valueOf(s.charAt(i));
				
				
				if (c.equals("(")) continue;
				else if (c.equals("+") || c.equals("-") || c.equals("*") || c.equals("/")) {
					
					
					ops.push(c);
				}
				else if (c.equals(")")) {
					String op = ops.pop();
					double val = vals.pop();
					
					if (op.equals("+")) {
						val = vals.pop() + val;						
					}
					else if (op.equals("-")) {
						val = vals.pop() - val;
					}
					else if (op.equals("*")) {
						val = vals.pop() * val;
					}
					else if (op.equals("/")) {
						val = vals.pop() / val;
					}
					
					vals.push(val);
							
				}
				else {
					String num = "";
					while (Character.isDigit(s.charAt(i)) ||  String.valueOf(s.charAt(i)).equals(".")){
						num += String.valueOf(s.charAt(i));
						
						i++;
					}
					vals.push(Double.parseDouble(num));
					i--;
					
				}
			}
			
		}
		double ans = vals.pop();
		return ans;
		}
		else {
			throw new IllegalArgumentException("Can only input mathematical expressions");
		}
		
	}
	
		

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArithSolver solve = new ArithSolver();
		String t = "((2+3)*(1+2))";
		String s = "as";
		
		
		System.out.println(solve.isExpression(t));
		System.out.println(solve.Dijkstra(t));
		
		

	}
	

}
