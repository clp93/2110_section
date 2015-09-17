package abstractClassDemo;

import java.util.Arrays;

// Comment line 7 and uncomment line 6 to switch to abstract version
public abstract class Shape implements Comparable<Shape> {
//public class Shape {
	private int x;
	private int y;

	/** Constructor: a shape with bounding box top left (x, y). */
	public Shape(int x, int y) {
		this.x = x;
		this.y = y;
	}

	/** = repr of this Shape, giving its position. */
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

	/** Method main to test things. */
	public static void main(String[] args) {
		Shape[] shapes = new Shape[5];
		shapes[0] = new Circle(3, 4, 1);
		shapes[1] = new Triangle(1, 2, 3, 4);
		shapes[2] = new Square(0, 0, 20);
		shapes[3] = new Square(0, 0, 5);
		shapes[4] = new Square(0, 0, 2);
		
//		Uncomment after uncommenting line 6
		System.out.println("unsorted: " + Arrays.toString(shapes));
		Arrays.sort(shapes);
		System.out.println("  sorted: " + Arrays.toString(shapes));
	}

//	/** Return the sum of the areas of the shapes in s */
//	public static double sumAreas(Shape[] s) {
//		double area = 0;
//		for (Shape sh : s) {
//			if (sh instanceof Circle) {
//				area += ((Circle) sh).area();
//			} else if (sh instanceof Square) {
//				area += ((Square) sh).area();
//			} else if (sh instanceof Triangle) {
//				area += ((Triangle) sh).area();
//			}
//		}
//		return area;
//	}
	
// ABSTRACT CLASS VERSION
	/** Return the sum of the areas of the shapes in s */
	public static double sumAreas(Shape[] s) {
		double area = 0;
		for (Shape sh : s) {
			area += sh.area();
		}
		return area;
	}
// ABSTRACT area() + compareTo()
	/** = area of this Shape. */
	public abstract double area();

	/**
	 * = < 0, 0, or > 0 depending on whether this Shape's area is smaller, than,
	 * equal to, or grater than s's area
	 */
	public @Override int compareTo(Shape s) {
		double diff = area() - s.area();
		return (diff == 0 ? 0 : diff < 0 ? -1 : +1);
	}
	
}
