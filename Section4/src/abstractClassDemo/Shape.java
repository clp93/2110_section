package abstractClassDemo;
import java.util.Arrays;

public class Shape {
	private int x;
	private int y;

	/** Constructor: a shape with bounding box top left  (x, y). */
	public Shape(int x, int y) {
		this.x= x;
		this.y= y;
	}

	/** = repr of this Shape, giving its position. */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/** Method main to test things. */
	public static void main(String[] args) {
		Shape[] shapes= new Shape[5];
		shapes[0]= new Circle(3, 4, 1);
		shapes[1]= new Triangle(1, 2, 3, 4);
		shapes[2]= new Square(0, 0, 20);
		shapes[3]= new Square(0, 0, 5);
		shapes[4]= new Square(0, 0, 2);
		System.out.println("unsorted: " + Arrays.toString(shapes));
		Arrays.sort(shapes);
		System.out.println("  sorted: " + Arrays.toString(shapes));
	}

	/** Return the sum of the areas of the shapes in s */
	public static double sumAreas(Shape[] s){ 
		return 0; //TODO
	}
}
