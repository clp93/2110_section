package abstractClassDemo;

public class Triangle extends Shape {
	double base;
	double height;
	
    /** Constructor: a triangle at (x, y) with base b and height h. */
	public Triangle(int x, int y, double b, double h) {
		super(x,y);
		base= b;
		height= h;
	}
	
    /** = area of this Triangle */
	public double area() {
		return 0.5 * base * height;
	}
	
    /** = repr of this Circle */
    public String toString() {
        return String.format("Triangle at %s base %.1f height %.1f", 
        		             super.toString(), base, height);
    }
}