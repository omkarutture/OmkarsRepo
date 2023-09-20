package JavaBasics;

import java.util.ArrayList;
import java.util.TreeSet;

public class highestAndSecondHighestElement {
	
	public static void main(String[] args) {

		int ar[] = {12,55,26,8,66,74,89,5,6,78,559,9,5};
		
		TreeSet	tr = new TreeSet();
		for(int num:ar)
           tr.add(num);
		
		ArrayList al= new ArrayList(tr);
		System.out.println("2nd Largest number in array: " + al.get(al.size()-2));
		System.out.println(("2nd Lowest Number in array: "+ al.get(1)));
	}
}
