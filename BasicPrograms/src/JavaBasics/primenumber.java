package JavaBasics;

public class primenumber {
	
	public static boolean Prime(int num){ //Given Num
		
		if(num<=1) {
		return false;
	}
	
	
	for(int i=2; i<num; i++) {
		if(num % i == 0 ) {
			return false;
		
	}
	}
		return true;
	}
	
	 public static void rangeOfPrime(int num) { //Given Range
	    	
	    	for (int i=2; i<=num; i++) {
	    		if(Prime(i))
	    			System.out.print(i + " ");
	    	}
	    }
	
	public static void main(String [] args) {
		
		System.out.println(Prime(5)); //For given Num
		rangeOfPrime(20); //For Given range		
	}
// =================================================================================================


   
}
