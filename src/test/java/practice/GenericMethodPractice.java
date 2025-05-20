package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {
	
		int sum = add(10,20);
		System.out.println(sum);
		System.out.println(add(sum,30));
		System.out.println(add(50,80));
		int sub = sub(40,20);
		System.out.println(sub);
		System.out.println(sub(sub,30));
		System.out.println(sub(90,80));
		int mul = mul(10,20);
		System.out.println(mul);
		System.out.println(mul(mul,30));
		System.out.println(mul(50,80));

	}

	public static int add(int a,int b) {	
		int c = a + b;	
		return c;
	}
	
	public static int sub(int a,int b) {	
		int c = a - b;	
		return c;
	}
	
	public static int mul(int a,int b) {	
		int c = a*b;	
		return c;
	}
}
