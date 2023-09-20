package JavaBasics;

public class prime {
	public static void main(String[] args) {
		
	int a = 13;
	int temp = 0;
	
	for(int i=2; i<=a-1; i++) {
		if(a%i==0) {
		temp=temp+i;
	}
	}
	
	if(temp==0)
	System.out.println("it's Prime");
	else
	System.out.println("not prime");
	}
}

