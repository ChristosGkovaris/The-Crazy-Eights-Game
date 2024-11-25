import java.util.ArrayList;
import java.util.HashMap;

class Hand {
    private ArrayList<Card> cards; // List of cards in the player's hand
    private HashMap<String, Integer> colorCounts; // Count of cards by color

    // Constructor initializes the hand and color counts
    public Hand() {
        this.cards = new ArrayList<>();
        this.colorCounts = new HashMap<>();
        for (String color : new String[]{"H", "S", "D", "C"}) {
            colorCounts.put(color, 0);
        }
    }

    // Adds a card to the hand and updates color counts
    public void addCard(Card card) {
        cards.add(card);
        if (!card.isEight()) {
            colorCounts.put(card.getCardColor(), colorCounts.get(card.getCardColor()) + 1);
        }
    }

    // Removes a card from the hand and updates color counts
    public void removeCard(Card card) {
        if (cards.remove(card) && !card.isEight()) {
            colorCounts.put(card.getCardColor(), colorCounts.get(card.getCardColor()) - 1);
        }
    }

    // Gets a card at a specific index
    public Card getCard(int index) {
        return cards.get(index);
    }

    // Checks if the hand is empty
    public boolean isEmpty() {
        return cards.isEmpty();
    }

    // Prints all cards in the hand with their indices
    public void printHand() {
        for (int i = 0; i < cards.size(); i++) {
            System.out.println(i + ": " + cards.get(i));
        }
    }

    // Returns the number of cards in the hand
    public int getCardCount() {
        return cards.size();
    }

    // Finds a matching card for the given card
    public Card findMatchingCard(Card tableCard) {
        for (Card card : cards) {
            if (card.matches(tableCard)) {
                return card;
            }
        }
        for (Card card : cards) {
            if (card.isEight()) {
                card.setCardColor(getMostFrequentColor());
                return card;
            }
        }
        return null;
    }

    // Helper method to determine the most frequent color in the hand
    private String getMostFrequentColor() {
        String mostFrequentColor = null;
        int maxCount = -1;
        for (String color : colorCounts.keySet()) {
            if (colorCounts.get(color) > maxCount) {
                maxCount = colorCounts.get(color);
                mostFrequentColor = color;
            }
        }
        return mostFrequentColor;
    }
}
