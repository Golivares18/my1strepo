package m;
import m.Node;


public class ThreeDNode extends Node{

	public static void main(String[] args) {}
	
	
	private int z;
	
	// Default constructors
	public ThreeDNode() throws Exception {
		super(); // This makes sure that x and y are defaulted to 0
		this.z = 0;
	}
	
	
	// Copy constructor
	public ThreeDNode(ThreeDNode m) throws Exception {
		super(m.getX(),m.getY());
		this.z = m.z;
	}
	
	
	// 3 parameter
	public ThreeDNode(int x,int y,int z) throws Exception{
		super(x,y);
		setZ(z);		
	}
	
	
	// Get && set methods for z
	public int getZ() {
		return z;
	}
		
	public void setZ(int z) {
		if (z<INode.LOWER_LIMIT || z>INode.UPPER_LIMIT) {
			throw new IllegalArgumentException("The node has a value that is out of the provided range");
		}
		this.z = z;
	}
	
	public void add(ThreeDNode m) throws Exception {
		super.add(m);
		int updatedZ = this.z + m.z;
		
		// Ensure still within range
		if (updatedZ<INode.LOWER_LIMIT || updatedZ>INode.UPPER_LIMIT) {
			throw new IllegalArgumentException("The z value is out of the provide range");
		}
		this.z = updatedZ;
	}
	
    @Override
    public String toString() {
        return String.format("ThreeDNode(%d, %d, %d)", getX(), getY(), this.z);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ThreeDNode)) return false;
        ThreeDNode other = (ThreeDNode) obj;
        return this.getX() == other.getX() && this.getY() == other.getY() && this.z == other.z;
    }

}
