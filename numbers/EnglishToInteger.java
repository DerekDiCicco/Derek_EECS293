import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.File;
import java.io.Writer;
import java.io.FileNotFoundException;
import java.io.IOException;

public class EnglishToInteger 
{
	private int returnInt;
	private boolean isNegative, validSyntax;
	Writer errorWriter;
	
	public EnglishToInteger()
	{
		returnInt = 0;
		//create error log file
		File errorFile = new File("ErrorLog.txt");
	}
	
	public void Translate(String input)
	{
		input = input.toLowerCase();
		String[] words = input.split(" ");
		checkSyntax(words);
		if (validSyntax)
		{
			if (isZero(words[0])) returnInt = 0;
			else
			{
				if (isNegative(words)) makeNegative();
				
			}
			
			System.out.println(returnInt);
		}
		else
		{
			System.out.println("Error: See ErrorLog.txt for details");
		}
	}
	
	private void checkSyntax(String[] words)
	{
		boolean millionCount = false;
		boolean thousandCount = false;
		boolean hundredCount = false;
		boolean tenCount = false;
		boolean minusCount = false;
		
		//first, make sure every word is recognized
		for (String str : words)
		{
			if (!recognizeWord(str))
			{
				validSyntax = false;
				logError("Input '" + str + "' is invalid.");
				return;
			}
		}
		if (words.length == 1)
		{
			if (isZero(words[0])
				|| isDigit(words[0])
				|| isTeen(words[0]))
			{
				validSyntax = true;
				return;
			}
			else
			{
				validSyntax =  false;
				logError("Input '" + words[0] + "' cannot stand on its own.");
				return;
			}
		}
		else if (words.length > 1)
		{
			//search through entire phrase, detecting patterns
			for (String str : words)
			{
				
			}
		}
		else
		{
			validSyntax =  false;
			logError("No input.");
			return;
		}
	}
	
	private int prefixAmount(String[] prefix)
	{
		int total = 0;
		
		return total;
	}
	
	private boolean isDigit(String input)
	{
		if (input.equals("one")
				|| input.equals("two")
				|| input.equals("three")
				|| input.equals("four")
				|| input.equals("five")
				|| input.equals("six")
				|| input.equals("seven")
				|| input.equals("eight")
				|| input.equals("nine")) return true;
		else return false;
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
	
	private boolean isTeen(String input)
	{
		if (input.equals("ten")
				|| input.equals("eleven")
				|| input.equals("twelve")
				|| input.equals("thirteen")
				|| input.equals("fouteen")
				|| input.equals("fifteen")
				|| input.equals("sixteen")
				|| input.equals("seventeen")
				|| input.equals("eighteen")
				|| input.equals("nineteen")) return true;
		else return false;
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
	
	private boolean isTensValue(String input)
	{
		if (input.equals("twenty")
				|| input.equals("thirty")
				|| input.equals("forty")
				|| input.equals("fifty")
				|| input.equals("sixty")
				|| input.equals("seventy")
				|| input.equals("eighty")
				|| input.equals("ninety")) return true;
		else return false;
	}
	
	private int translateTensValue(String teen)
	{
		if (teen.equals("twenty")) return 20;
		else if (teen.equals("thirty")) return 30;
		else if (teen.equals("forty")) return 40;
		else if (teen.equals("fifty")) return 50;
		else if (teen.equals("sixty")) return 60;
		else if (teen.equals("seventy")) return 70;
		else if (teen.equals("eighty")) return 80;
		else if (teen.equals("ninety")) return 90;
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
	
	private boolean isNegative(String[] input)
	{
		if (input[0].equals("minus") || input[0].equals("negative")) return true;
		else return false;
	}
	
	private void makeNegative()
	{
		returnInt = -1;
	}
	
	private boolean isZero(String input)
	{
		if (input.equals("zero")
			|| input.equals("naught")) return true;
		else return false;
	}
	
	private boolean recognizeWord(String input)
	{
		if (isDigit(input)
			|| isTeen(input)
			|| isTensValue(input)
			|| isZero(input)
			|| input.equals("minus")
			|| input.equals("negative")
			|| input.equals("hundred")
			|| input.equals("thousand")
			|| input.equals("million")) return true;
		else return false;
	}
	
	private void logError(String errorMessage)
	{
		try
		{
			errorWriter = new BufferedWriter(new FileWriter("ErrorLog.txt"));
			errorWriter.write("ERROR: " + errorMessage);
		}
		catch (FileNotFoundException e) 
		{
            e.printStackTrace();
        } 
		catch (IOException e) 
		{
            e.printStackTrace();
        } finally 
        {
        	try
        	{
        		errorWriter.close();
        	}
        	catch (IOException e)
        	{
        		e.printStackTrace();
        	}
        }
	}
}