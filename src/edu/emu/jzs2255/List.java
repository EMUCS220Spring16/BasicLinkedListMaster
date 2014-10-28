package edu.emu.jzs2255;
/**
 * A class to manage a simple linked list of Strings
 * @author Josh Sauder (sjoshua270)
 *
 */
public class List {
	Node head;
	/**
	 * Constructor method
	 */
	public List(){
		head = null;
	}


	/**
	 * Inserts a String into the linked list
	 * in alphabetical order
	 * @param String to store
	 * @return True if success
	 */
	public boolean insert(String value) throws NullPointerException{
		if(value == null) throw new NullPointerException();
		if(value.equals("")) throw new IllegalArgumentException();

		// if list is empty, set up the first node (headNode)
		if(head == null){
			head = new Node(value);
			return true;
		}
		else{
			Node current, prev; // Current and Previous Nodes
			current = head;
			prev = null;
			// Here, using (String) I can ensure that the code will only continue if the 'Object' returned by getObject() was a String
			while( current != null && value.compareTo((String)current.getObject()) > 0){ // continue through each node to find an alphabetical spot for new value
				prev = current;
				current = current.getNext();
			}
			
			if(prev != null){ // as long as there was a 'prev', we can insert the new node
				prev.setNext(new Node(value)); // value needs to be set before 'cur', after 'prev'
				prev.getNext().setNext(current);
				return true;
			}
			else{ // if 'prev' was never set, that means the 'headNode' value was greater than the passed value, and 'headNode' should be replaced
				head = new Node(value);
				head.setNext(current);
				return true;
			}
		}
	}

	/**
	 * Finds a String in the linked list
	 * @param String to search for
	 * @return True if found
	 */
	public boolean find(String word) throws EmptyListException, NullPointerException {
		if(isEmpty()) throw new EmptyListException();
		if(word == null) throw new NullPointerException();
		if(word.equals("")) throw new IllegalArgumentException();

		Node current = head;
		// Once again, making sure the Object returned by getObject() is a String type with '(String)'
		while(current != null && !word.equals((String)current.getObject())){
			current = current.getNext();
		}
		if(current != null) return true;
		return false;
	}

	/**
	 * Removes the first instance of a String from the linked list
	 * @param String to remove
	 * @return True if removed
	 */
	public boolean remove(Object item) throws EmptyListException, NullPointerException {
		// Throwing exceptions!
		if(isEmpty()) throw new EmptyListException();
		if(item == null) throw new NullPointerException();
		if(item.equals("")) throw new IllegalArgumentException();

		Node current = head;
		Node previous = null;
		while(current != null && !item.equals(current.getObject())){
			previous = current;
			current = current.getNext();
		}
		// It is important that you check for previous first
		if(previous == null){
			head = current.getNext();
			return true;
		}
		if(current != null){
			previous.setNext(current.getNext());;
			return true;
		}
		else return false; // If current is null, this means we are sitting at the end of the List, and the word was not found
	}

	/**
	 * Converts the linked list into one String
	 * @return The list in String form
	 */
	public String toString(){
		// If there is nothing in the list
		if(isEmpty()) return "List is Empty";

		String values = "[";
		// start off with the first node
		// remember that this 'node' is exclusive to this method
		Node current = head;

		// continues as long as the current node is not null
		while(current.getNext() != null){
			values += current.getObject();
			values += ", ";
			// increment down the line
			current = current.getNext();
		}
		values += current.getObject();
		values += "]";
		return values;
	}

	/**
	 * Checks if there are items in the linked list
	 * @return True if empty
	 */
	public boolean isEmpty(){
		return head == null;
	}
}
