package edu.emu.jzs2255;
/**
 * Basic node class that holds a String and a Pointer to the next node
 * @author Josh Sauder (sjoshua270)
 *
 */
public class Node {
	
	private Node nextNode; // Reference to the next Node in the list
	private Object data; // Data kept by the Node (can be String, Integer, Double, or any custom Object that you make)
	
	/**
	 * Constructor method
	 * Initializes variables appropriately
	 * @param newObject 	New Object for the Node to start with.
	 */
	public Node(Object newObject){
		data = newObject;
		nextNode = null;
	}
	
	/**
	 * Returns the data from the Node
	 * @return 		Object stored in the node
	 */
	public Object getObject(){
		return data;
	}
	
	/**
	 * Sets the Object of the Node
	 * @param 	newData	New Object for the Node to store.
	 */
	public void setObject(Object newData){
		data = newData;
	}
	
	/**
	 * Returns the next Node in the list
	 * @return 		Next Node in the list
	 */
	public Node getNext(){
		return nextNode;
	}
	
	/**
	 * Sets the next Node in the list
	 * @param 		New Node to assign as the following Node
	 */
	public void setNext(Node newNext){
		nextNode = newNext;
	}
}
