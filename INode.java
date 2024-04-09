package m;

import m.Node;

public interface INode extends Comparable {
	/* It's always recommended to use named constants to make changing the values easier
	 * and improve the program comprehension
	 */
	public static final int LOWER_LIMIT = -100;  
	public static final int UPPER_LIMIT =  100;
	static final int DEFAULT_X =0; 
	static final int DEFAULT_Y =0;
	
	public void add(Node INode) throws Exception;
	
	

}
