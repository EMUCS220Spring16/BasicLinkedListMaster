package edu.emu.jzs2255;
/**
 * A class to manage a simple linked list of Strings
 * @author Josh Sauder (sjoshua270)
 *
 */
public class List {
	Node headNode;
	/**
	 * Constructor method
	 */
	public List(){
		headNode = null;
	}

	/**
	 * Inserts a String into the linked list
	 * in alphabetical order
	 * @param String to store
	 * @return True if success
	 */
	public boolean insert(String value){
		// if list is empty, set up the first node (headNode)
		if(headNode == null){
			headNode = new Node(value);
			return true;
		}
		else{
			// Current and Previous Nodes
			Node cur, prev;
			cur = headNode;
			prev = null;
			// continue through each node to find an alphabetical spot for new value
			while( cur != null && cur.getValue().compareTo(value) < 0){
				prev = cur;
				cur = cur.getNext();
			}
			// as long as there was a 'prev', we can insert the new node
			if(prev != null){
				// value needs to be set before 'cur', after 'prev'
				prev.setNext(new Node(value));
				if(cur != null)
					prev.getNext().setNext(cur);
			}
			// if 'prev' was never set, that means the 'headNode' value
			// was greater than the passed value, and 'headNode' should be replaced
			else{
				headNode = new Node(value);
				headNode.setNext(cur);
			}
			return true;
		}
	}
	
	/**
	 * Finds a String in the linked list
	 * @param String to search for
	 * @return True if found
	 */
	public boolean find(String word){
		Node current = headNode;
		while(current != null){
			if(current.getValue() == word){
				return true;
			}
			current = current.getNext();
		}
		return false;
	}
	
	/**
	 * Removes the first instance of a String from the linked list
	 * @param String to remove
	 * @return True if removed
	 */
	public boolean remove(String word){
		Node current = headNode;
		Node previous = null;
		while(current != null){
			if(current.getValue() == word){
				if(previous == null){
					headNode = current.getNext();
				}
				else{
					previous.setNext(current.getNext());
				}
				return true;
			}
			previous = current;
			current = current.getNext();
		}
		return false;
	}

	/**
	 * Converts the linked list into one String
	 * @return The list in String form
	 */
	public String toString(){
		String values = "[";
		// start off with the first node
		// remember that this 'node' is exclusive to this method
		Node node = headNode;

		// continues as long as the current node is not null
		while(node != null){
			values += node.getValue();
			// as long as there is another node, we can add a comma to look pretty
			if(node.getNext() != null){
				values += ", ";
			}
			// increment down the line
			node = node.getNext();
		}
		values += "]";
		return values;
	}
	
	/**
	 * Checks if there are items in the linked list
	 * @return True if empty
	 */
	public boolean isEmpty(){
		return headNode == null;
	}
}
