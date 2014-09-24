package analysis;

public class Counter 
{
	public static void main(String [] args)
	{
		int n = 1000000000;
		int sum = 0;
		
		System.out.println("Time before function call: " + System.currentTimeMillis());
		
		sum = multiples (3, n) + multiples (5, n) - multiples(15, n);
		
		System.out.println("Time after function call: " + System.currentTimeMillis());
		
		System.out.println("Total: " + sum);
	}
	
	static int multiples (int d, int n)
	{
		int last = n - (n%d);
		int count = last/d;
		int first = d;
		int total = (first + last) * count/2;
		return total;
	}
}