package abstractClassDemo;

public class Circle extends Shape {
    double radius;
    
    /** Constructor: a circle at (x, y) with radius r. */
    public Circle(int x, int y, double r) {
        super(x, y);
        radius= r;
    }
    
    /** = area of this Circle */
    public double area() {
        return Math.PI * radius * radius;
    }
    
    /** = repr of this Circle */
    public String toString() {
        return "Circle at " + super.toString() + " radius " + radius;
    }
}
