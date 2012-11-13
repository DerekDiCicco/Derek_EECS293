
public class EnglishToInteger 
{
	private int returnInt;
	private boolean isNegative;
	
	public EnglishToInteger()
	{
		returnInt = 0;
	}
	
	public void Translate(String input)
	{
		input = input.toLowerCase();
		if (validSyntax(input))
		{
			if (isZero(input)) returnInt = 0;
			else
			{
				if (isNegative(input)) makeNegative();
				
			}
			
			System.out.println(returnInt);
		}
		else
		{
			System.out.println("Error: See ErrorLog.txt for details");
		}
	}
	
	private boolean validSyntax(String input)
	{
		boolean millionCount = false;
		boolean thousandCount = false;
		boolean hundredCount = false;
		boolean tenCount = false;
	}
	
	private int prefixAmount(String prefix)
	{
		int total = 0;
		
		return total;
	}
	
	private int translateDigit(String digit)
	{
		if (digit.equals("one")) return 1;
		else if (digit.equals("two")) return 2;
		else if (digit.equals("three")) return 3;
		else if (digit.equals("four")) return 4;
		else if (digit.equals("five")) return 5;
		else if (digit.equals("six")) return 6;
		else if (digit.equals("seven")) return 7;
		else if (digit.equals("eight")) return 8;
		else if (digit.equals("nine")) return 9;
		else return 0;
	}
	
	private int translateTeen(String teen)
	{
		if (teen.equals("ten")) return 10;
		else if (teen.equals("eleven")) return 11;
		else if (teen.equals("twelve")) return 12;
		else if (teen.equals("thirteen")) return 13;
		else if (teen.equals("fourteen")) return 14;
		else if (teen.equals("fifteen")) return 15;
		else if (teen.equals("sixteen")) return 16;
		else if (teen.equals("seventeen")) return 17;
		else if (teen.equals("eighteen")) return 18;
		else if (teen.equals("nineteen")) return 19;
		else return 0;
	}
	
	private int multiplyMillion(int prefixAmount)
	{
		return prefixAmount * 1000000;
	}
	
	private int thousandAmount(int prefixAmount)
	{
		return prefixAmount * 1000;
	}
	
	private boolean isNegative(String input)
	{
		if (input.startsWith("minus") || input.startsWith("negative")) return true;
		else return false;
	}
	
	private void makeNegative()
	{
		returnInt = -1;
	}
	
	private boolean isZero(String input)
	{
		if (input.equals("zero")
				|| input.equals("Zero")
				|| input.equals("ZERO")
				|| input.equals("naught")
				|| input.equals("Naught")
				|| input.equals("NAUGHT")) return true;
		else return false;
	}
}
