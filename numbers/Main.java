import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) 
	{
		EnglishToInteger translator = new EnglishToInteger();
		Scanner in = new Scanner(System.in);
		
		while (in.hasNext())
		{
			try
			{
				String input = in.nextLine();
				System.out.println(translator.Translate(input));
			}
			catch (IllegalArgumentException e)
			{
				System.out.println("Error: See ErrorLog.txt for details");
				System.exit(7);
			}
		}
	}

}
