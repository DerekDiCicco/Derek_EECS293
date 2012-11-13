
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
		if (validSyntax(input))
		{
			if (isZero(input)) returnInt = 0;
			
			System.out.println(returnInt);
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
		if (digit.equals("one") || digit.equals("One") || digit.equals("ONE")) return 1;
		else if (digit.equals("two") || digit.equals("Two") || digit.equals("TWO")) return 2;
		else if (digit.equals("three") || digit.equals("Three") || digit.equals("THREE")) return 3;
		else if (digit.equals("four") || digit.equals("Four") || digit.equals("FOUR")) return 4;
		else if (digit.equals("five") || digit.equals("Five") || digit.equals("FIVE")) return 5;
		else if (digit.equals("six") || digit.equals("Six") || digit.equals("SIX")) return 6;
		else if (digit.equals("seven") || digit.equals("Seven") || digit.equals("SEVEN")) return 7;
		else if (digit.equals("eight") || digit.equals("Eight") || digit.equals("EIGHT")) return 8;
		else if (digit.equals("nine") || digit.equals("Nine") || digit.equals("NINE")) return 9;
		else return 0;
	}
	
	private int translateTeen(String teen)
	{
		if (teen.equals("ten") || teen.equals("Ten") || teen.equals("TEN")) return 10;
		else if (teen.equals("eleven") || teen.equals("Eleven") || teen.equals("ELEVEN")) return 11;
		else if (teen.equals("twelve") || teen.equals("Twelve") || teen.equals("TWELVE")) return 12;
		else if (teen.equals("thirteen") || teen.equals("Thirteen") || teen.equals("THIRTEEN")) return 13;
		else if (teen.equals("fourteen") || teen.equals("Fourteen") || teen.equals("FOURTEEN")) return 14;
		else if (teen.equals("fifteen") || teen.equals("Fifteen") || teen.equals("FIFTEEN")) return 15;
		else if (teen.equals("sixteen") || teen.equals("Sixteen") || teen.equals("SIXTEEN")) return 16;
		else if (teen.equals("seventeen") || teen.equals("Seventeen") || teen.equals("SEVENTEEN")) return 17;
		else if (teen.equals("eighteen") || teen.equals("Eighteen") || teen.equals("EIGHTEEN")) return 18;
		else if (teen.equals("nineteen") || teen.equals("Nineteen") || teen.equals("NINETEEN")) return 19;
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
