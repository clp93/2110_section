import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------- Demo 1 part 1 --------------------------
public class PythagoreanSolver {

	public static void main(String[] args) throws IOException {
		calculate();
	}

	/** Calculate C in A^2 + B^2 = C^2 for A and B given by user on keyboard. */ 
	public static void calculate() throws IOException {
		while (true) {
			System.out.print("Give a and b:  ");
			BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in)); //don't worry about this
			String input = inputReader.readLine();
			System.out.println(parseInputAndAnswer(input));
		}
	}

	/** Parse A and B and returns C. WARNING: May throw NumberFormatException. */
	private static double parseInputAndAnswer(String input) {
		String[] numbers = input.split(" ");
		int total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total += convertAndSquare(numbers[i]);
		}
		return Math.sqrt(total);
	}

	/** Convert the input into an int and returns the square. 
	 *  WARNING: May throw NumberFormatException. */
	private static int convertAndSquare(String number) {
		int n = Integer.parseInt(number);
		return n * n;
	}

}
