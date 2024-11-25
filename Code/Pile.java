import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

// Represents the deck of cards used in the game
class Pile {
    private ArrayList<Card> cardHolder; // List to hold all cards in the pile

    // Constructor initializes the card holder
    public Pile() {
        this.cardHolder = new ArrayList<>();
    }

    // Fills the pile with all 40 cards and shuffles them
    public void fill() {
        String[] colors = {"H", "S", "D", "C"};
        for (String color : colors) {
            for (int i = 0; i < 10; i++) {
                cardHolder.add(new Card(color, i));
            }
        }
        shuffle();
    }

    // Overloaded method to fill the pile with a specific list of cards
    public void fill(ArrayList<Card> cards) {
        cardHolder.clear();
        cardHolder.addAll(cards);
        shuffle();
    }

    // Shuffles the pile of cards
    private void shuffle() {
        Collections.shuffle(cardHolder, new Random());
    }

    // Removes and returns the top card from the pile
    public Card nextCard() {
        if (!isEmpty()) {
            return cardHolder.remove(0);
        }
		// If the pile is empty, return null
        return null; 
    }

    // Checks if the pile is empty
    public boolean isEmpty() {
        return cardHolder.isEmpty();
    }

    // Prints all cards in the pile
    public void print() {
        System.out.println(cardHolder);
    }

    // Main method to test the Pile class
    public static void main(String[] args) {
        Pile pile = new Pile();
        pile.fill();
        System.out.println("Filled pile:");
        pile.print();

        // Test drawing cards
        System.out.println("Drawing cards...");
        while (!pile.isEmpty()) {
            System.out.println("Drew: " + pile.nextCard());
        }
        System.out.println("Pile is empty: " + pile.isEmpty());
    }
}
