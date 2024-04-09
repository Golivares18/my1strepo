package m;
import java.util.*;


public class Nodes {
	
	private ArrayList<INode> list;

	public Nodes() {
		list = new ArrayList<>();
	}

    // Method to randomly fill the ArrayList with Nodes and ThreeDNodes
    public void fill(int size) throws Exception {
        list.clear(); // Clear existing nodes
        Random random = new Random();
        NodeFactory factory = new NodeFactory();
        for (int i = 0; i < size; i++) {
            if (random.nextBoolean()) { // Randomly decide whether to add Node or ThreeDNode
                list.add(factory.getThreeDNode());
            } else {
                list.add(factory.getNode());
            }
        }
    }
    
    // Method to delete all elements in the ArrayList
    public void clear() {
        list.clear();
    }
    
    // Method to count the number of Nodes in the ArrayList
    public int countNodes() {
        int count = 0;
        for (INode node : list) {
            if (node instanceof Node) {
                count++;
            }
        }
        return count;
    }
    
    // Method to count the number of ThreeDNodes in the ArrayList
    public int countThreeDNodes() {
        int count = 0;
        for (INode node : list) {
            if (node instanceof ThreeDNode) {
                count++;
            }
        }
        return count;
    }

    
    // Method to sort the ArrayList based on the sum of x and y, or x and y and z
    public void sort() {
        list.sort(new Comparator<INode>() {
            @Override
            public int compare(INode node1, INode node2) {
                int sum1 = node1 instanceof ThreeDNode ? ((ThreeDNode) node1).getX() + ((ThreeDNode) node1).getY() + ((ThreeDNode) node1).getZ() : ((Node) node1).getX() + ((Node) node1).getY();
                int sum2 = node2 instanceof ThreeDNode ? ((ThreeDNode) node2).getX() + ((ThreeDNode) node2).getY() + ((ThreeDNode) node2).getZ() : ((Node) node2).getX() + ((Node) node2).getY();
                return Integer.compare(sum1, sum2);
            }
        });
    }
    
    // Method to return a multi-line string representing the nodes in the ArrayList
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (INode node : list) {
            result.append(node).append("\n");
        }
        return result.toString();
    }
    
    
}
