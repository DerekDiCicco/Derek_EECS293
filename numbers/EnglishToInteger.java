import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class EnglishToInteger 
{
	private int returnInt;
	private boolean validSyntax;
	FileWriter errorWriter;
	
	/******************************************************************************************
	 * SECTION 1: Public methods
	 *****************************************************************************************/
	
	/**
	 * Empty constructor
	 */
	public EnglishToInteger()
	{
	}
	
	/**
	 * Translate method: takes the input, converts to an array, and converts:
	 * -until it reaches "million", "thousand", or the end, it adds to prefixes
	 * -It then uses below private methods to calculate the output integer
	 * @param input The string to be converted to an integer
	 * @return
	 * @throws IllegalArgumentException The syntax is invalid
	 */
	public int Translate(String input) throws IllegalArgumentException
	{
		returnInt = 0;//reset
		input = input.toLowerCase();
		String[] words = input.split(" ");
		checkSyntax(words);
		if (validSyntax)
		{
			if (isZero(words[0])) returnInt = 0;
			else
			{
				String prefix = "";
				for (String str : words)
				{
					if (isDigit(str) || isTeen(str) || isTensValue(str) || str.equals("hundred"))
					{
						prefix = prefix + " " + str;
					}
					else if (str.equals("million"))
					{
						returnInt += multiplyMillion(prefixAmount(prefix));
						prefix = "";//reset prefix
					}
					else if (str.equals("thousand"))
					{
						returnInt += multiplyThousand(prefixAmount(prefix));
						prefix = "";//reset prefix
					}
				}
				//add up final prefix
				returnInt += prefixAmount(prefix);
				//make negative if necessary
				if (isNegative(words)) returnInt *= -1;;
			}
			return returnInt;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
	
	/******************************************************************************************
	 * SECTION 2: Booleans
	 * These methods verify correct syntax and input properties
	 *****************************************************************************************/
	
	/**
	 * Checks if entire string is a negative number
	 * @param input The entire string in array form
	 * @return
	 */
	private boolean isNegative(String[] input)
	{
		if (input[0].equals("minus") || input[0].equals("negative")) return true;
		else return false;
	}
	
	/**
	 * Checks if the particular string is a digit
	 * @param input The string to test
	 * @return
	 */
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
	
	/**
	 * Checks if given string is a teen value
	 * @param input The string to check
	 * @return
	 */
	private boolean isTeen(String input)
	{
		if (input.equals("ten")
				|| input.equals("eleven")
				|| input.equals("twelve")
				|| input.equals("thirteen")
				|| input.equals("fourteen")
				|| input.equals("fifteen")
				|| input.equals("sixteen")
				|| input.equals("seventeen")
				|| input.equals("eighteen")
				|| input.equals("nineteen")) return true;
		else return false;
	}
	
	/**
	 * Checks to see if the given string is a ten value
	 * @param input The string to test
	 * @return
	 */
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
	
	/**
	 * This method takes in separated prefixes and confirms that they are valid
	 * @param prefix the separated string to be diagnosed 
	 * @return
	 */
	private boolean isValidPrefix(String prefix)
	{
		boolean hundredRead = false;
		String[] words = prefix.split(" ");
		//search through entire phrase, detecting patterns
		for (int i = 0; i < words.length; i++)
		{
			if (isDigit(words[i]))
			{
				if (i != 0)//to prevent null pointer exception
				{
					//if a teen or digit is before the digit
					if (isTeen(words[i-1]) || isDigit(words[i-1])) return false;
				}
				if (i != words.length - 1)//to prevent null pointer exception
				{
					//if a teen or digit is after the digit
					if (isTeen(words[i+1]) || isDigit(words[i+1])) return false;
				}
			}
			else if (isTeen(words[i]))
			{
				if (i != 0)//to prevent null pointer exception
				{
					//if a teen or digit is before the teen
					if (isTeen(words[i-1]) || isDigit(words[i-1]) || isTensValue(words[i-1])) return false;
				}
				if (i != words.length - 1)//to prevent null pointer exception
				{
					//if a teen or digit is after the teen
					if (isTeen(words[i+1]) || isDigit(words[i+1]) || isTensValue(words[i+1])) return false;
				}
			}
			else if (isTensValue(words[i]))
			{
				if (i != 0)//to prevent null pointer exception
				{
					//if a teen or digit is before the teen
					if (isTensValue(words[i-1]) || isDigit(words[i-1])) return false;
				}
				if (i != words.length - 1)//to prevent null pointer exception
				{
					//if a teen is after the teen
					if (isTensValue(words[i+1])) return false;
				}
			}
			else if (words[i].equals("hundred"))
			{
				if (i == 0) return false;//hundred needs digit before it
				else 
				{
					if (!hundredRead)
					{
						//if a teen or tens value is before it
						if (isTeen(words[i-1]) || isTensValue(words[i-1])) return false;
						hundredRead = true;
					}
					else return false;
				}
			}
		}
		return true;
	}
	
	/******************************************************************************************
	 * SECTION 3: Integers
	 * These methods calculate integers based on strings, used to calculate the overall translation
	 *****************************************************************************************/
	
	/**
	 * Takes a digit string and return its respective integer value
	 * @param digit The string to translate
	 * @return
	 */
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
	
	/**
	 * Takes a teen string and returns its respective integer value
	 * @param teen The string to translate
	 * @return
	 */
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
	
	/**
	 * Takes ten value and translates it to its respective integer value
	 * @param teen The string to translate
	 * @return
	 */
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
	
	/**
	 * Takes in the prefix string and calculates an appropriate amount
	 * @param prefix The string to be converted
	 * @return
	 */
	private int prefixAmount(String prefix)
	{
		int total = 0;
		String [] words = prefix.split(" ");
		//scan through array and calculate
		for (int i = 0; i < words.length; i++)
		{
			if (isDigit(words[i]))
			{
				//last word, single digit
				if (i == words.length - 1) total += translateDigit(words[i]);
				//otherwise it should be followed by 'hundred'
				else total += multiplyHundred(translateDigit(words[i]));
			}
			else if (isTeen(words[i])) total += translateTeen(words[i]);
			else if (isTensValue(words[i])) total += translateTensValue(words[i]);
			//otherwise it's 'hundred', so skip
		}
		return total;
	}
	
	/**
	 * Multiplies the prefix by one million
	 * @param prefixAmount
	 * @return
	 */
	private int multiplyMillion(int prefixAmount)
	{
		return prefixAmount * 1000000;
	}
	
	/**
	 * Multiplies the prefix by one thousand
	 * @param prefixAmount
	 * @return
	 */
	private int multiplyThousand(int prefixAmount)
	{
		return prefixAmount * 1000;
	}
	
	/**
	 * Multiplies the prefix by one hundred
	 * @param prefixAmount
	 * @return
	 */
	private int multiplyHundred(int prefixAmount)
	{
		return prefixAmount * 100;
	}
	
	/******************************************************************************************
	 * SECTION 4: Voids
	 * These methods perform actions necessary to the translator's effectiveness
	 *****************************************************************************************/
	
	/**
	 * Writes error to the log text file
	 * @param errorMessage The message specifying why there is an error
	 */
	private void logError(String errorMessage)
	{
		try
		{
			errorWriter = new FileWriter("ErrorLog.txt",true);
			PrintWriter text = new PrintWriter(errorWriter);
			text.println("ERROR: " + errorMessage);
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
	
	/**
	 * Ensures that the syntax of the input is correct
	 * -This method is a void because it also logs errors
	 * @param words the arrays of strings to be tested
	 */
	private void checkSyntax(String[] words)
	{
		boolean millionRead = false;
		boolean thousandRead = false;
		
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
				|| isTeen(words[0])
				|| isTensValue(words[0]))
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
			String prefix = "";
			//search through entire phrase, detecting patterns
			for (int i = 0; i < words.length; i++)
			{
				//if the word is part of a prefix, pass it on to the prefix checker
				if (isDigit(words[i])) prefix = prefix + " " + words[i];
				else if (isTeen(words[i])) prefix = prefix + " " + words[i];
				else if (isTensValue(words[i])) prefix = prefix + " " + words[i];
				else if (words[i].equals("hundred")) prefix = prefix + " " + words[i];
				//if million or thousand, make sure it hasn't already been used
				//then check its prefix
				else if (words[i].equals("thousand"))
				{
					//needs prefix
					if (i == 0)
					{
						validSyntax =  false;
						logError("'Thousand' needs a prefix.");
						return;
					}
					if (!thousandRead)
					{
						if (!isValidPrefix(prefix))
						{
							validSyntax =  false;
							logError("Invalid prefix '" + prefix + "'.");
							return;
						}
						else prefix = "";//reset prefix
						thousandRead = true;//so it cannot be used again
					}
					else
					{
						validSyntax =  false;
						logError("Cannot use 'thousand' more than once.");
						return;
					}
				}
				else if (words[i].equals("million"))
				{
					//needs prefix
					if (i == 0)
					{
						validSyntax =  false;
						logError("'Million' needs a prefix.");
						return;
					}
					if (!millionRead)
					{
						if (!isValidPrefix(prefix))
						{
							validSyntax =  false;
							logError("Invalid prefix '" + prefix + "'.");
							return;
						}
						else prefix = "";//reset prefix
						millionRead = true;//so it cannot be used again
					}
					else
					{
						validSyntax =  false;
						logError("Cannot use 'million' more than once.");
						return;
					}
				}
				//zero must be on its own
				else if (isZero(words[i]))
				{
					validSyntax =  false;
					logError("'Zero' or 'naught' must stand on its own.");
					return;
				}
				//minus can only come first
				else if (words[i].equals("minus") || words[i].equals("negative"))
				{
					if (i != 0)
					{
						validSyntax =  false;
						logError("Cannot use 'minus' or 'negatve' unless it is the first word");
						return;
					}
				}
			}
			//check that last part (after thousand and million, or if they do not appear) is valid
			if (!isValidPrefix(prefix))
			{
				validSyntax =  false;
				logError("Invalid string '" + prefix + "'.");
				return;
			}
		}
		else
		{
			validSyntax =  false;
			logError("No input.");
			return;
		}
		validSyntax = true;
	}
	
	/**
	 * Checks if string is equal to zero
	 * @param input The string to check
	 * @return
	 */
	private boolean isZero(String input)
	{
		if (input.equals("zero")
			|| input.equals("naught")) return true;
		else return false;
	}
	
	/**
	 * Checks the spelling to ensure the string used exists
	 * @param input The string to check
	 * @return
	 */
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
}