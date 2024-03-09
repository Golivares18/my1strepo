// Imports 
package m;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Stream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/*
 * Gregorio Olivares
 * Object Oriented Programming - cpsc24500 - Section 3
 * 2024-03-08
 * The purpose of this code is find the total line value, longest row, max in a specific row,
 * and max in file given a two-dimensional array
*/
public class Assignment4 {


	
	
	// Main method
	public static void main(String[] args) {
		String filename = null;
		filename = new String("C:\\Users\\groli\\eclipse-workspace\\Assignment4\\assignment4Data.txt");
			
		// Friendly messages
		System.out.println("Hello, this code will read a .txt file and convert it "
				+ "into a two-dimensional array to provide the file length,\nlongest "
				+ "row, max value in a specific row, and the max value of the file. ");
		System.out.println();
		

		int arr[][] = null;
		try {
			System.out.println("Number of lines in the file = "+ getNoLines(filename));
			arr = create2DArray(filename);
			int longestRow = findLongestRow(arr);
			System.out.println("Longest row in the file is: "+ (longestRow+1 )+", with length of: "
			                      +arr[longestRow].length);
			System.out.println("Max value in first row = "+ findMaxInRow(arr, 0));
			System.out.println("Max value in file = "+ findMax(arr));
		} catch (Exception e) {
			System.out.print(e);
		}
	}
	
	
	/**
	 *
	 * @param filename
	 * @return number of lines in a text file
	 * @throws Exception
	 */
	public static int getNoLines(String filename) throws Exception{
		try (Stream<String> fileStream = Files.lines(Paths.get(filename))) {
			return (int) fileStream.count();
		} 
	}

	
	
	/**
	 * 
	 * @param filename source file
	 * @return two dim array (jagged array), where each row in the array contains the values in one line of the file,
	 * the length of each row depends on the number of values in each line of the file.
	 * @throws Exception
	 */
	public static int[][] create2DArray(String filename) throws Exception {
		// Create variables for rows and index
		int rows = 0;
		
		// Will initialize the rows to become the max value
		int[][] jaggedArray = new int[getNoLines(filename)][];

		// Used in order to read file
		File file = new File(filename);
		Scanner scan = new Scanner(file);
		
		// Method to parse file into 2D Array
		while (scan.hasNextLine()) {
			String[] values = scan.nextLine().trim().split("\\s+");
			jaggedArray[rows] = new int[values.length];
			for (int i=0;i<values.length;i++) {
				jaggedArray[rows][i] = Integer.parseInt(values[i]);
			}
			rows++;
		}
		
		// Verifies that the array was created
		// System.out.println(Arrays.deepToString(jaggedArray));
		
		
        return jaggedArray;
	}
	
	
	
	// This method will find the longest row index in a given two dim array 
	public static int findLongestRow(int[][] arr) {
		// Variable that will be returned 
		int longest = 0;
		int row = 0;
		
		// Method that will take the array with an index of i then assign it to the max
		for (int i=0;i<arr.length;i++) {
			if (arr[i].length>longest) {
				longest=arr[i].length;
				row = i;
			}
		}
		
		return row;
	}
	
	
	
	// will return a max in a specific row given an index
	public static int findMaxInRow(int[][] arr, int row) {
		// Variable that will be returned and method	
		int rowMax = Arrays.stream(arr[row]).max().getAsInt();
		

		return rowMax;
	}
	
	
	
	
	// will return a max in the entire two dim array
	public static int findMax(int[][] arr) {
		// Variable that will be returned 
		int max = Integer.MIN_VALUE;
		
		// Method to loop the row and index in row
		for (int i=0;i<arr[i].length;i++) {
			for (int j=0;j<arr[j].length;j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}
		
		return max;
	}	
	
}
