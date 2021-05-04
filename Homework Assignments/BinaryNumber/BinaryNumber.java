package HW1;

import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

// Mehta Nimtrakul
// I pledge my honor that I have abided by the Stevens Honor System.
// CS 284D

public class BinaryNumber {
	// data fields
	private int data[];
	private int length;
	
	// methods
	
	// constructors 
	public BinaryNumber(int length) {
		if (length <= 0) {
			throw new IllegalArgumentException("Only non-negative, non-zero integers allowed");
		}
		
		int[] intArray = new int[length];
		
		this.data = intArray;
		this.length = intArray.length;
	
	}
	

	
	public BinaryNumber(String str) {
		// check if inputs are 1's and 0's and handle with exception
		
		int[] arr = new int[str.length()];
		
		for (int i = 0; i<str.length(); i++){
            if (str.charAt(i) =='1') {
                arr[i] = Character.getNumericValue(str.charAt(i));
            }
            else if (str.charAt(i) =='0') {
                arr[i] = Character.getNumericValue(str.charAt(i));
            }
            else{
                throw new IllegalArgumentException("String should only contain 0's and 1's");
            }
        }
		
		this.data = arr;
		this.length = str.length();
		
	}
	
	public int getLength() {
		return this.length;
	}
	
	public int[] getInnerArray() {
		return this.data;
	}
	
	public int getDigit(int index) {
		if (index < 0 || index >= this.data.length) {
			throw new IndexOutOfBoundsException("Index is out of bounds");
		}
		return this.data[index];
		
		
	}
	
	public int toDecimal() {
		int sum = 0;
		int exp = this.length - 1;
		for (int i = 0; i < this.length; i++) {
			sum += this.data[i]*(Math.pow(2, exp));
			exp--;
			
		}
		return sum;
	}
	
	public void bitShift(int direction, int amount) {
		// 
		// check if the amount is <=0 so throw an exception
		// if direction is -1 left shift, multiplication
		// create a new array with amount + the size of your current array
		// int arr[] = new int[data array size + amount]
		// iterate up to the size of your array and place the values in 
		// the new array and leave the end as zeros.
		// change the size of the object and set data array to new array
		
		// if direction is 1 right shift division.
		// check if the amount that you wish to shift is greater than size
		// if so set size to 1 and data array to just one 0.
		// if it's not, make an array with size of data array length - amount
		// iterate up to the size of the array - amount 
		// set values if new array with values of old new arr[i] old arr[i]
		// set your data fields, data array to new data array and the size to the new array.
		if (amount <= 0) {
			throw new IllegalArgumentException("Amount must be greater than 0");
		}
		// right shift
		if (direction == 1) {
			if (amount > this.length) {
				int[] arr = new int[1];
				this.data = arr;
			}
			else {
				int[] arr1 = new int[this.data.length - amount];
				for (int i = 0; i < this.data.length - amount; i++) {
					arr1[i] = this.data[i];
				}
				this.data = arr1;
			}
		}
		// left shift 
		if (direction == -1) {
			int[] arr2 = new int[this.data.length + amount];
			for (int i = 0; i < this.data.length; i++) {
				arr2[i] = this.data[i];
			}
			this.data = arr2;
		}
		if (direction != 1 && direction != -1) {
			throw new IllegalArgumentException("Direction must be 1 or -1");
		}
	}
	
	public static int[] bwor(BinaryNumber bn1, BinaryNumber bn2) {
		// check if both numbers are not the same size, throw exception
		//bn1.getLength() -> returns length of the binary number
		// make a new array with the size of both
		// iterate through both and check if they are either 1's -> put 1 in new array
		// neither one, then place a zero in the array
		// return that array.
		
		// bwand is the same thing
		if (bn1.getLength() != bn2.getLength()) {
			throw new IllegalArgumentException("Binary numbers must be the same size");
		}
		else {
			int[] arr = new int[bn1.getLength()];
			for (int i = 0; i < bn1.getLength(); i++) {
				if(bn1.data[i] == 1 || bn2.data[i] == 1) {
					arr[i] = 1;
				}
				else {
					continue;
				}
			}
			return arr;
		}
		
	}
	
	public static int[] bwand(BinaryNumber bn1, BinaryNumber bn2) {
		if (bn1.getLength() != bn2.getLength()) {
			throw new IllegalArgumentException("Binary numbers must be the same size");
		}
		else {
			int[] arr = new int[bn1.getLength()];
			for (int i = 0; i < bn1.getLength(); i++) {
				if(bn1.data[i] == 1 && bn2.data[i] == 1) {
					arr[i] = 1;
				}
				else {
					continue;
				}
			}
			return arr;
		}
		
	}

	public String toString() {
		return Arrays.toString(this.getInnerArray());
	}
	
	public static int[] prepend(int[] array, int amount) {
		int[] arr = new int[array.length + amount];
		int j = 0;
		for (int i = amount; i < array.length+amount; i++) {
			arr[i] = array[j];
			j++;
		}
		return arr;
	}
	// for add, you can iterate backwards for both numbers
	// check which is smaller and prepend it with the difference
	// iterate backwards for both binary numbers
	// have a remainder variable
	// take the sum of the indexes and modulo (%2)
	// have a carry over value sum / 2
	// set your index in the new array as remainder
	// when done going through loop, if carry > 0
	// make a new array with the size of old array + 1
	// place carry over value into the array
	// set the data array to new final result from adding
	// set the size of that data array
	public void add(BinaryNumber aBinaryNumber) {
		// Parameter Binary Number has bigger length, so add 0's to this.data
		if (this.data.length < aBinaryNumber.length) {
			int[] arr = new int[this.data.length];
			arr = prepend(this.data, aBinaryNumber.length - this.data.length);
			this.data = arr;
			this.length = arr.length;
		}
		// Same thing but with This.data
		if (aBinaryNumber.length < this.data.length) {
			int[] arr1 = new int[aBinaryNumber.length];
			arr1 = prepend(aBinaryNumber.data, this.data.length - aBinaryNumber.length);
			
			aBinaryNumber.data = arr1;
			aBinaryNumber.length = arr1.length;
		}
		int[] ans = new int[this.length];
		int i = this.length-1;
		int carry = 0;
		int sum;
		
		while (i >= 0) {
			sum = carry;
			
			sum += this.data[i];
			sum += aBinaryNumber.data[i];
			
			
			ans[i] = sum % 2;
			carry = sum / 2;
			
			i--;
			
		}
		if (carry != 0) {
			 int[] res = new int[ans.length+1]; 
			 res[0] = 1;
			 int l = 0;
			 for (int k = 1; k < res.length; k++) {
				 res[k] = ans[l];
				 l++;
				 
			 }
			 this.length = res.length;
			 this.data = res;
		}
		else {
			this.length = ans.length;
			this.data = ans;
		}
		
	}
	
	
	
	public static void main(String[] args) {
		int[] values1 = {1,2,3};
		
		int[] values2 = values1;
		
		values2[0] = 4;
		
		System.out.println(values1[0]);
	}
}
