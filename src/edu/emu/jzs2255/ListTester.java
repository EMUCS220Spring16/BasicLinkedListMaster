package edu.emu.jzs2255;
/**
 * A Tester class for a standard linked list of Strings
 * @author Josh Sauder (sjoshua270)
 *
 */
public class ListTester {
	// insert() Strings
	private final static String INSERT = "Testing insert()... ";
	// cannot be incorrect, can only fail
	private final static String INSERT_FAILED = "Failed to insert names:";
	
	// find() Strings
	private final static String FIND = "Testing find()... ";
	private final static String FIND_INCORRECT = "find() output incorrect";
	private final static String FIND_FAILED = "Failed to find names:";
	
	// remove() Strings
	private final static String REMOVE = "Testing remove()... ";
	private final static String REMOVE_INCORRECT = "remove() output incorrect";
	private final static String REMOVE_FAILED = "Failed to remove names:";
	
	// isEmpty() Strings
	private final static String EMPTY = "Testing isEmpty()... ";
	private final static String EMPTY_INCORRECT = "isEmpty() output incorrect";
	private final static String EMPTY_FAILED = "Failed to test isEmtpy()";
	
	// print() Strings
	private final static String TOSTRING = "Testing toString()... ";
	private final static String TOSTRING_INCORRECT = "toString() output incorrect";
	private final static String TOSTRING_FAILED = "Failed to print";
	
	// other Strings
	private final static String CORRECT = "Correct!";


	public static void main(String[] args){
		// initialize names
		List list = new List();
		String[] names = {"Josh", "Alex", "Chris", "Josiah", "Timothy", "Randell", "Kyle", "Isaac", "Caleb", "Dee", "Aron", "Jonathan", "Suha", "David", "Alvin", "Josh"};

		// String to test answer against
		String expected = "[Alvin, Aron, Caleb, Chris, David, Dee, Isaac, Jonathan, Josh, Josh, Josiah, Randell, Suha, Timothy]";

		// to keep track of successes
		int correct = 0;

		// Test insert()
		try{
			print(INSERT, false);
			for(int i = 0; i < names.length; i++)
				list.insert(names[i]);
			print(CORRECT, true);
			correct++;
		}
		catch(Exception e){
			print(INSERT_FAILED, true);
			print(e.toString(), true);
		}

		// Test find()
		try{
			print(FIND, false);
			if(list.find("Suha") && !list.find("Louis")){
				print(CORRECT, true);
				correct++;
			}
			else
				print(FIND_INCORRECT, true);
		}
		catch(Exception e){
			print(FIND_FAILED, true);
			print(e.toString(), true);
		}

		// Test remove()
		try{
			print(REMOVE, false);
			if(list.remove("Alex") && list.remove("Kyle")){
				print(CORRECT, true);
				correct++;
			}
			else
				print(REMOVE_INCORRECT, true);
		}
		catch(Exception e){
			print(REMOVE_FAILED, true);
		}
		
		// Test isEmpty()
		try{
			print(EMPTY, false);
			if(!list.isEmpty()){
				print(CORRECT, true);
				correct++;
			}
			else{
				print(EMPTY_INCORRECT, true);
			}
		}
		catch(Exception e){
			print(EMPTY_FAILED, true);
			print(e.toString(), true);
		}

		// Test print()
		try{
			print(TOSTRING, false);
			String print = list.toString();
			if(print.compareTo(expected) == 0){
				print(CORRECT, true);
				correct++;
			}
			else
				print(TOSTRING_INCORRECT, true);
		}
		catch(Exception e){
			print(TOSTRING_FAILED, true);
			print(e.toString(),true);
		}


		print("", true);
		// Print out two lists for review, and a percentage of working methods
		print("Given:    "+list.toString(), true);
		print("Expected: "+expected, true);
		print("Completion: "+100 * correct/5+"%", true);
	}

	/**
	 * Prints a message to console and adds a line if 'newLine' is true
	 * @param message to display
	 * @param add a new line after message
	 */
	private static void print(String msg, boolean newLine){
		if(newLine)
			System.out.println(msg);
		else
			System.out.print(msg);
	}
}
