package edu.emu.jzs2255;
/**
 * Basic node class that holds a String and a Pointer to the next node
 * @author Josh Sauder (sjoshua270)
 *
 */
public class Node {
	// reference/pointer to the next node in the link chain
	// or null if there is no other
	private Node next;
	// string carried by the node
	private String value;
	
	/**
	 * Constructor method
	 * @param Initial String
	 */
	public Node(String newValue){
		next = null;
		value = newValue;
	}
	
	/**
	 * Returns the value of the Node
	 * @return String stored in the node
	 */
	public String getValue(){
		return value;
	}
	
	/**
	 * Sets the value of the Node
	 * @param New String
	 */
	public void setValue(String newValue){
		value = newValue;
	}
	
	/**
	 * Returns the next Node in the list
	 * @return Next Node in the linked list
	 */
	public Node getNext(){
		return next;
	}
	
	/**
	 * Sets the next Node in the list
	 * @param New next Node in the linked list
	 */
	public void setNext(Node newNext){
		next = newNext;
	}
}
