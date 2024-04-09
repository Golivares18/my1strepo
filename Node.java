/*
 * Gregorio Olivares
 * Object Oriented Programming - cpsc24500 - Section 3
 * 2024-03-23 || Assignment5
 * The purpose of this code will be to use instance INode to be able to perform various methods on a 2 dimensional node
 * 
 */
package m;

import m.INode;

public class Node implements INode {
	
    private int x,y;

    public Node() throws Exception{
    	this( DEFAULT_X, DEFAULT_Y);
    }
    
	public Node(int x, int y) throws Exception {
		setX(x); setY(y);  //set to given values if valid
	}
	/**
	 * Copy constructor
	 * @param node
	 * @throws Exception
	 */
	public Node(Node node) throws Exception {
		setX(node.getX());
		setY(node.getY());
	}

	private boolean isValidX(int x) {
		if (x<=UPPER_LIMIT && x>=LOWER_LIMIT)
			return true;
		return false;
	}
	private boolean isValidY(int y) {
		if (y<=UPPER_LIMIT && y>=LOWER_LIMIT)
			return true;
		return false;
	}
	public int getX() {
		return x;
	}

	public void setX(int x) throws Exception {
		if (isValidX(x))
			this.x = x;
		else
		throw new Exception("Invalid operation: x value shoud be in the range: ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
	}

	public int getY() {
		return y;
	}

	public void setY(int y) throws Exception {
		if (isValidY(y))
			this.y = y;
		else
		throw new Exception("Invalid operation: y value shoud be in the range: ["+LOWER_LIMIT+","+UPPER_LIMIT+"]");
	}
	public void add(Node node) throws Exception {
		if (isValidX(this.x+node.getX()) && isValidY(this.y+node.getY()) ) {
			this.x+=node.getX();
			this.y+=node.getY();
		}	else
			throw new Exception("Invalid operation, the result exceeds the xy-space boundaries...");
	}
	
	public String toString() {
		return "("+this.x+","+this.y+")";
	}
	public boolean equals(Object obj) {
		//to restrict call with only objects of type Node
		if (obj instanceof Node) {
			Node ref = (Node) obj;
			if (this.x==ref.x && this.y == ref.y)
				return true;
			return false;
		}
		return false;
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}


   
} //class Node
