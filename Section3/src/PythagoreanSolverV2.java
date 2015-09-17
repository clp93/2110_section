import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// -------------------------- Demo 1 part 2 --------------------------
public class PythagoreanSolverV2 {

	public static void main(String[] args) {
		calculate();
	}

	/** Calculates C in A^2 + B^2 = C^2. Asks for input and prints answer. */
	public static void calculate() {
		boolean finished = false;
		while (!finished) {
			System.out.print("\nGive a and b:  ");
			String input;
			try {
				input = new BufferedReader(new InputStreamReader(System.in)).readLine();
				System.out.println("Received Input...");
				double ans = parseInputAndAnswer(input);
				System.out.println("C = " + ans);
				finished = true;
			} catch (IOException e) {
				System.out.println("There was an error reading the input.");
			} catch (NumberFormatException e) {
				System.out.println("Badly formatted input. Please enter two numbers.");
			}
		}
		System.out.println("Closing application...");
	}

	/**
	 * Parses A and B and returns C. WARNING: May throw NumberFormatException.
	 */
	private static double parseInputAndAnswer(String input) {
		String[] numbers = input.split(" ");
		int total = 0;
		for (int i = 0; i < numbers.length; i++) {
			total += convertAndSquare(numbers[i]);
		}
		return Math.sqrt(total);
	}

	/**
	 * Converts the input into an int and returns the square. WARNING: May throw
	 * NumberFormatException.
	 */
	private static int convertAndSquare(String number) {
		int n = Integer.parseInt(number);
		return n * n;
	}

}
