
public enum Suit {
	CLUBS("black"), DIAMONDS("red"), HEARTS("red"), SPADES("black");
	
	// Enums can have fields and constructors to initialize those fields.
	// The only time the constructor can be called is in the declaration of initial enum constants
	private String color;
	
	Suit(String c) {
		color = c;
	}
	
	// Enums can have instance (or static) methods.
	// Examples of calling instance methods on enum values:
	//    Suit.CLUBS.color();
	//    Suit.HEARTS.isRed();
	
	public String getColor() {
		return color;
	}
	
	public boolean isRed() {
		return color == "red";
	}
	
	public boolean isBlack() {
		return color == "black";
	}
}
