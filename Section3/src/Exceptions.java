import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Exceptions {
	public static void main(String[] args) {
		//Exercise 1
//		System.out.println("Ex.1: " + 
//		    (getIndex(new int[]{2110,0,1,2110,2110},2,2110) == 3 ? "good!" : "fail"));
		
		//Exercise 2
		int[][] matrix = new int[][] {{1,2},{3,4},{5,6}};
		print2D(matrix);
		System.out.println("--------- TRANSPOSE ----------");
		print2D(transpose(matrix));
	}
	
	



	
	// -------------------------- Exercise 1 --------------------------
	/** Returns the index of occurrence n (one-indexed) of the target number. 
	 *  Precondition: n >= 1 && arr != null */
	public static int getIndex(int[] b, int n, int t) {
		for (int i = 0; i < b.length; i++) {
			if (b[i] == t) {
				if (n == 1)
					return i;
				n--;
			}
		}
		return -1;

	}
	
	// -------------------------- Exercise 2 --------------------------
	/** Returns the transpose of a matrix. Assume that the matrix is rectangular. */
	public static int[][] transpose(int[][] b) {
		//TODO: return a new 2D array that is the transpose of the input matrix
		//Feel free to use print2D(int[][]) from below to help you debug
		int [][] t = new int[b[0].length][b.length];
		for (int i= 0; i < b.length; i++) {
			for (int j= 0; j < b[i].length; j++) {
				t[j][i] = b[i][j];
			}
		}
		return t;
	}
	
	private static void print2D(int[][] array) {
		for (int[] arr : array) {
			System.out.println(Arrays.toString(arr));
		}
	}
	
	// -------------------------- Prelim Exercise --------------------------
	// From Prelim 1 Fall 2014
	private static double m(int x) {
		int y = x;
		try {
			System.out.println("one");
			y = 5/x;
			System.out.println("two");
			return 5/(x+2);
		} catch (NullPointerException e) {
			System.out.println("three");
		} catch (RuntimeException e) {
			System.out.println("four");
			y = 5/(x+1);
			System.out.println("five");
		}
		System.out.println("six");
		y = 4/x;
		System.out.println("seven");
		return 1/x;
	}
	// If m(x) is called for some x<0, which will definitely be printed? 4,5,7,None of these?
	// Which value(s) of x will cause an exception to be thrown out of m? 
	
	
	
	// -------------------------- Debugger Demo --------------------------
	//Find the bug using the debugger. (Can go over if time permits.)
	public static void pointInsideCircle(String[] args) {
		double xDiff = Double.parseDouble(args[0]) - Double.parseDouble(args[2]);
		double yDiff = Double.parseDouble(args[1]) - Double.parseDouble(args[3]);
		double radius = Double.parseDouble(args[4]);
		boolean insideCircle = Math.sqrt(xDiff * xDiff + yDiff * yDiff) < radius;
		String answer = "Point is ";
		if (insideCircle); {
			System.out.println(answer + "inside the circle");
		}
		if (!insideCircle) {
			System.out.println(answer + "outside the circle");
		}
	}
}
