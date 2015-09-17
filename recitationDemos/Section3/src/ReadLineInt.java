import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReadLineInt {

	public static void main(String[] args) throws IOException {
		readLineInt();
	}

	/**
	 * Input line supposed to contain an int. (whitespace on either side OK).
	 * Read line, return the int. If line doesn’t contain int, ask user again
	 */
	public static int readLineInt() throws IOException {
		BufferedReader inputReader = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter an int: ");
		String input = inputReader.readLine().trim();
		// inv: input contains last input line read; previous
		// lines did not contain a recognizable integer.
		while (true) {
			try {
				return Integer.parseInt(input);
			} catch (NumberFormatException e) {
				System.out.println("Input not int. Must be an int like");
				System.out.println("43 or -20. Try again: enter an int:");
				input = inputReader.readLine().trim();
			}
		}
	}
}
