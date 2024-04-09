package m;
import java.util.*;
import m.Nodes;
public class Driver {

	public static void main(String[] args) throws Exception {
		Nodes nodes = new Nodes();
		Scanner scan = new Scanner(System.in);
		int choice;
		
		System.out.println("Please pick from the following options:\n");
		System.out.println(" 1. Fill " );
		System.out.println(" 2. Clear " );
		System.out.println(" 3. Count Nodes " );
		System.out.println(" 4. Count ThreeDNodes " );
		System.out.println(" 5. Sort " );
		System.out.println(" 6. Display " );
		System.out.println(" 7. Exit\n " );
		
	
		choice = scan.nextInt();
		
		Driver x = new Driver();
		x.decision(choice);
		

	}
	
	public void decision(int x) throws Exception {
		Scanner scan = new Scanner(System.in);
		if (x == 1) {
			System.out.println("Please enter a size to fill: " );
			int size = scan.nextInt();
			Nodes nodes = new Nodes();
			nodes.fill(size);
		} 
		
	}
	
	
	
	
}
