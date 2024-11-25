import java.util.ArrayList;

// Represents the game table
class Table {
    private Pile pile;                      // The pile from which players draw cards
    private ArrayList<Card> discardedCards; // List of discarded cards
    private Card topCard;                   // The card currently on top of the table

    // Constructor initializes the pile and sets the first top card
    public Table() {
        this.pile = new Pile();
        this.discardedCards = new ArrayList<>();
        pile.fill();
        topCard = pile.nextCard();
        discardedCards.add(topCard);
    }

    // Adds a card to the table and updates the top card
    public void throwCard(Card card) {
        discardedCards.add(card);
        topCard = card;
    }

    // Draws the next card from the pile, reshuffling if necessary
    public Card drawCard() {
        if (pile.isEmpty()) {
            reshuffleDiscardedCards();
        }
        return pile.nextCard();
    }

    // Returns the top card on the table
    public Card getTopCard() {
        return topCard;
    }

    // Reshuffles the discarded cards back into the pile
    private void reshuffleDiscardedCards() {
        if (discardedCards.size() > 1) {
            Card lastCard = discardedCards.remove(discardedCards.size() - 1);
            pile.fill(discardedCards);
            discardedCards.clear();
            discardedCards.add(lastCard);
            topCard = lastCard;
        }
    }

    // Main method to test the Table class
    public static void main(String[] args) {
        Table table = new Table();
        System.out.println("Initial top card: " + table.getTopCard());

        // Simulate drawing and discarding cards
        for (int i = 0; i < 5; i++) {
            Card drawn = table.drawCard();
            System.out.println("Drew: " + drawn);
            table.throwCard(drawn);
        }

        System.out.println("Top card after throws: " + table.getTopCard());
    }
}
