package abstractClassDemo;

public class Square extends Shape {
    double size;
    
    /** Constructor: a square with side length s at (x, y) */
    public Square(int x, int y, double s) {
        super(x, y);
        size= s;
    }
    
    /** = area of this Square */
    public double area() {
        return size * size;
    }
    
    /** = repr of this Square */
    public String toString() {
        return "Square at " + super.toString() + " size " + size;
    }
}
