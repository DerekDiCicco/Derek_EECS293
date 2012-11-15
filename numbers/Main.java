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
		
		/***********************************************
		 * This commented section is for singular inputs
		 **********************************************/
//			try
//			{
//				String input = in.nextLine();
//				System.out.println(translator.Translate(input));
//			}
//			catch (IllegalArgumentException e)
//			{
//				System.out.println("Error: See ErrorLog.txt for details");
//			}
		
		ArrayList<String> lines = new ArrayList<String>();
		while (in.hasNext()) 
		{
			lines.add(in.nextLine());
	    }
		for (String input : lines)
		{
			System.out.println(translator.Translate(input));
		}
	}

}
