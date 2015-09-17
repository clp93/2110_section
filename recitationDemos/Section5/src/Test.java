
public class Test {
	public static void main(String[] args) {
		A a = new A();
		System.out.println(a.m());
		m(a);
		
		B b = new B();
		System.out.println(b.m());
		m(b);
		
		A ab = b;
		System.out.println(ab.m());
		m(ab);
	}
	public static void m(A a) {
		System.out.println("Type A");
	}
	
	public static void m(B b) {
		System.out.println("Type B");
	}
}

class A {
	int x;
	public A() { this(1); }
	public A(int x) { this.x = x; }
	int m() { return x; }
}

class B extends A {
	int y;
	B() { this(2); }
	B(int x) {
		super(x+1);
		y = x + super.x;
	}
	int m() { return y; }
}
