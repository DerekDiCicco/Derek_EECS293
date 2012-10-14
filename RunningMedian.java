/*
RunningMedian.pseudocode
Derek DiCicco

October 18, 2012

This file calculates the running median of a given set of T
*/

/*
CORRECTNESS ARGUMENT
Suppose the following sequence is entered.  The following will occur:
RunningMedian(1, 2, 3)  |	1,2,3 are added to parameters
median 					|	The array[1 2 3] is by definition returned 
add(4, 5) 				|	4 and 5 are added to Parameters.
							[2 3 4] is returned 
add(6, 7) 				|	6 and 7 are added to Parameters.
							[3 4 5] is returned 
median					|	[3 4 5] is returned 
add(8, 9) 				|	8 and 9 are added to Parameters.
							[4 5 6] is returned

WORST CASE RUNNING TIME: O(n^2)
*/
import java.util.*;

 public class RunningMedian
{
	/*Global variables*/
	// T medianLower, medianMiddle, medianHigher;
	 private int medianLower, medianMiddle, medianHigher;
	//arrayList Parameters;
	 private List<Integer> Parameters = new ArrayList<Integer>();
	
	
	/*
	CONSTRUCTOR: the constructor for this class takes in three values then:
		-adds them to the Parameters array list
		-makes the number of parameters 3
	*/
	// RunningMedian(T a, T b, T c)
	 public RunningMedian(int a, int b, int c)
	 {
		// add to Parameters: a, b, c;
		 Parameters.add(a);
		 Parameters.add(b);
		 Parameters.add(c);
		// sort Parameters with Insertion sort;
		 Collections.sort(Parameters);
	 }
	
	/*
	Purpose: adds two units and returns the new median values.
	Process:
		-adds the parameters to the array list
		-increases the number of parameters by two
		-calls the median method to return the new median
	*/
	// T[] add(T a, T b)
	 public int[] add(int a, int b)
	 {
		// add to Parameters: a, b;
		 Parameters.add(a);
		 Parameters.add(b);
		// sort Parameters using insertion sort;
		 Collections.sort(Parameters);
		// return median();
		 return median();
	 }
	
	/*
	Purpose: returns the median of the parameters entered
	Process:
		-sorts the parameters array list
			-Quick Sort was chosen because since the array list is sorted after every
			two additions, it will typically run fast.
		-if there are only the three paramters, those are the medians
		-otherwise:
			-subtract the number of parameters by three, divide by two
			-that factor is the beginning of the three medians
		-return those medians
	*/
	// T[] median()
	 public int[] median()
	 {
		// integer beginHere = (length of Parameters - 3) / 2;
		 int beginHere = (Parameters.size() - 3) / 2;
		// medianLower = Parameters[beginHere];
		// medianMiddle = Parameters[beginHere + 1];
		// medianHigher = Parameters[beginHere + 2];
		 medianLower = Parameters.get(beginHere);
		 medianMiddle = Parameters.get(beginHere+1);
		 medianHigher = Parameters.get(beginHere+2);
		// return [medianLower, medianMiddle, medianHigher];
		 int[] medians = {medianLower,medianMiddle,medianHigher};
		 return medians;
	 }
}