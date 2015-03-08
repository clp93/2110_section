import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Deck {
	
	private ArrayList<PlayingCard> cards;

	public Deck() {
		cards = new ArrayList<PlayingCard>();
		
		// Suit.values() returns an array of all values in enum Suit
		for (Suit s : Suit.values()) {
			for (int i = 1; i < 14; i++) {
				cards.add(new PlayingCard(s, i));
			}
		}
	}
	
	public void shuffleDeck() {
		Collections.shuffle(cards);
	}
	
	public PlayingCard drawCard() {
		return cards.remove(cards.size() - 1);
	}
	
	// removes all cards of specified Suit.
	public void removeAll(Suit suit) {
		ArrayList<PlayingCard> newDeck = new ArrayList<PlayingCard>();
		for (PlayingCard card : cards) {
			
			// Notice that you can use != and == to compare enum values. equals works too
			if (card.suit != suit) {
				newDeck.add(card);
			}
		}
		cards = newDeck;
	}
	
	public double probabilityOfRed() {
		int numRed = 0;
		for (PlayingCard c : cards) {
			
			// Suit has instance methods that can be called on any Suit enum value
			if (c.suit.isRed()) {
				numRed++;
			}
		}
		return ((double) numRed) / cards.size();
	}
	
	public double probabilityOfBlack() {
		return 1 - probabilityOfRed();
	}
	
	@Override
	public String toString() {
		return Arrays.toString(cards.toArray());
	}
	
	public void printProbabilities() {
		System.out.println("Probability of red:   " + probabilityOfRed());
		System.out.println("Probability of black: " + probabilityOfBlack());
		System.out.println();
	}
	
	public static void main(String[] args) {
		Deck d = new Deck();
		System.out.println(d);
		System.out.println();
		
		System.out.println("New deck of cards");
		d.printProbabilities();

		System.out.println("Removing all hearts");
		d.removeAll(Suit.HEARTS);
		d.printProbabilities();

		System.out.println("New deck of cards. Shuffling and drawing 7 random cards.");
		d = new Deck();
		d.shuffleDeck();
		for (int i = 0; i < 7; i++) {
			System.out.println(d.drawCard());
		}
		d.printProbabilities();
	}

}
