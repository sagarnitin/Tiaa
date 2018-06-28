
public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		swaptwonumber();
		
		
	}
	static void method()
	{
		int fib=5;
		int i[]=new int[fib];
		i[0]=0;
		i[1]=1;
		for (int j = 0; j < i.length-2; j++) 
		{
			i[j+2]=i[j]+i[j+1];
			
		}
		for (int j = 0; j < i.length; j++) {
			System.out.print(i[j]);
		}
		
	}
	static void palindrome()
	{
		////bob
		String s="bobr";
		String s1="";
		String s2="";
		
		for (int i = 0; i < s.length(); i++) {
			s1=s1+s.charAt(i);
			
		}
		for (int i = s.length()-1; i >=0; i--) {
			
			s2=s2+s.charAt(i);
		}
		
		if(s1.equalsIgnoreCase(s2))
		{
			System.out.println("palandrome");
		}
		else 
		{
			System.out.println("Not a palindrome");
		}
	}

	
	static void reversString()
	{
		String Str="abcd";
		String s="";
		for (int i = Str.length()-1; i >=0; i--) 
		{
			s=s+Str.charAt(i);
			
			
		}
		System.out.println(s);
		
	}
	static void integerpalindrome()
	{
		int a=121;
		int rem;
		int sum=0;
		int num=a;
		while(num >0)
		{
			rem=num%10;
			sum=(sum*10)+rem;
			num=num/10;
			
			
			
		}
		
		System.out.println(sum);
		
	}
	static void factorial()
	{
		//5=5*4*3*2*1
		int num=5;
		int sum=1;
		
		while(num>1)
		{
			int a=	num*(num-1);
			sum=sum*a;
			num=num-2;
			
		}
		System.out.println(sum);
		
	}
	static void swaptwonumber()
	{
		int a=1;
		int b=3;
		int c; 
		a=a+b;
		b=a-b;
		a=a-b;
		System.out.println(a+""+b);
	}
	
	static void method()
	{
		int i=0;
		int num=0;
		String prime="";
		for (int j = 1; j <=100; j++) {
			
			int counter=0;
			for (int num1 = j; num1 < array.length; num1++) {
				
			}
			
		}
	}
}
