package analysis;

public class Count 
{
	public static void main (String [] args)
	{
		int n = 1000000000;
		int sum = 0;
		
		System.out.println("Time before loop: " + System.nanoTime());
		
		for (int i = 0; i < n; i++)
		{
			if (i % 3 == 0 || i % 5 == 0)
			{
				sum = sum + i;
			}
		}
		
		System.out.println("Time after loop: " + System.nanoTime());
		
		System.out.println("Total: " + sum);
	}
}