import java.util.Random;

public class Example {
	public static void main(String[] args) {
		demo1HelloWorld(args);
		demo2PrintUserArg(args);
		exercise1PointInsideCircle(args);
		demo3PrintHoursAndMinutesFromUserArg(args);
		exercise2Random(4, 9);
		demo5ShowPrimitivesVsClasses();
		demo6CharAndCharacter();
	}
	
// ---------------------------------------- Demo 1 -------------------------------------------- //

	public static void demo1HelloWorld(String[] args) {
		System.out.println("Hello World");
	}

// ---------------------------------------- Demo 2 -------------------------------------------- //
	
	public static void demo2PrintUserArg(String[] args) {
		if (args.length == 0) {
			System.out.println("No arguments");
		} else {
			System.out.println("The first argument is: " + args[0]);
		}
	}

// ---------------------------------------- Demo 3 -------------------------------------------- //

	public static void demo3PrintHoursAndMinutesFromUserArg(String[] args) {
		if (args.length == 0) {
			System.out.println("No arguments");
		} else {
			String time = args[0];
			int indexOfColon = time.indexOf(':');
			if (indexOfColon == -1) {
				System.out.println("Incorrect format");
			} else {
				System.out.println("Hours: " + time.substring(0, indexOfColon));
				System.out.println("Minutes: " + time.substring(indexOfColon + 1));
			}
		}
	}
	
// ---------------------------------------- Demo 4 -------------------------------------------- //
	
	public static void demo4UseJFrame() {
		// JFrame frame = new JFrame();
		// javax.swing.JFrame frame = new javax.swing.JFrame();
	}

// ---------------------------------------- Demo 5 -------------------------------------------- //

	public static void demo5ShowPrimitivesVsClasses() {
		// How to instantiate common primitive types
		int i = 10;
		char c = 'y';
		boolean b = true;
		double d = 3.14;
		
		// == compares primitive types by their value
		int i1 = 5;
		int i2 = 5;
		System.out.println("i1 == i2: " + (i1 == i2));
		System.out.println("i1 == 3: " + (i1 == 3));
		System.out.println();
		
		// == compares objects by their reference
		Animal bob1 = new Animal("Bob");
		Animal bob2 = new Animal("Bob");
		Animal anotherReferenceToBob1 = bob1;
		System.out.println("bob1 == bob2: " + (bob1 == bob2));
		System.out.println("bob1 == anotherReferenceToBob1: " + (bob1 == anotherReferenceToBob1));
	}

// ---------------------------------------- Demo 6 -------------------------------------------- //
	
	private static boolean isEnglishLetter(char ch) {
		return ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z'));
	}
	
	public static void demo6CharAndCharacter() {
		System.out.println("Special character double quote: " + '\"');
		System.out.println("Special character single quote: " + '\'');
		System.out.println("Special character newline: " + '\n');
		System.out.println("Special character tab:" + '\t' + "end tab");
		System.out.println();
		
		System.out.println("int value of char 'a': " + ((int) 'a'));
		System.out.println("char value of 97: " + ((char) 97));
		System.out.println();
		
		System.out.println("int value of char 'b': " + ((int) 'b'));
		System.out.println("int value of char 'c': " + ((int) 'c'));
		System.out.println();
		
		System.out.println("int value of char 'A': " + ((int) 'A'));
		System.out.println("int value of char 'B': " + ((int) 'B'));
		System.out.println("int value of char 'C': " + ((int) 'C'));
		System.out.println();
		
		System.out.println("int value of char '3': " + ((int) '3'));
		System.out.println("int value of char '4': " + ((int) '4'));
		System.out.println("int value of char '5': " + ((int) '5'));
		System.out.println();
		
		char ch = 'y';
		System.out.println(ch + " is an English letter: " + isEnglishLetter(ch));
		System.out.println(ch + " is a letter in ANY language: " + Character.isLetter(ch));
		
		char foreignChar = (char) 2384;
		System.out.println(foreignChar + " is an English letter: " + isEnglishLetter(foreignChar));
		System.out.println(foreignChar + " is a letter in ANY language: " + Character.isLetter(foreignChar));
	}


	
// -------------------------------------- Exercise 1 ------------------------------------------ //
	
	public static void exercise1PointInsideCircle(String[] args) {
		//TODO Write a function that accepts two parameters of type double, 
		//     and prints out a random double between those two numbers
	}

// -------------------------------------- Exercise 2 ------------------------------------------ //
	
	public static void exercise2Random(double lower, double upper) {
		//TODO Write a function that accepts two parameters of type double,
		//     and prints out a random double between those two numbers
	}
}
