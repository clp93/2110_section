package interfacesDemo;

//Note: The code in these demos is not stylistically great.
//      It is brief and missing specifications in order to make presenting
//      easier. We expect your code to adhere to the CS 2110 style guidelines.

// This demo shows that an interface can be used as a "perspective".
// We can cast to an interface type and utilize its methods despite not being
// able to instantiate an interface object!
// Be aware of the compiler errors below.
public class Human implements Whistler {
	public static void main(String[] args) {
		Human h = new Human();
		Whistler w = h;
		Parrot p = new Parrot();
		
		//listenTo calls
		h.listenTo(w);
		h.listenTo(h);
		h.listenTo(p);
//		w.listenTo(h); //error
//		w.listenTo(w); //error
		((Human) w).listenTo(h); 
		
		//talkTo calls
		h.talkTo(h);
//		h.talkTo(w); //error
		h.talkTo((Human) w);
	}

	public void whistle() {		
	}
	
	public void listenTo(Whistler w) {
	}
	
	public void talkTo(Human h) {
	}
}

class Parrot implements Whistler {
	public void whistle() {
	}
}

interface Whistler {
	void whistle();
}
