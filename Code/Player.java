import java.util.Scanner;

// Represents a player in the game (human or computer)
class Player {
    private String name; // Name of the player
    private Hand hand; // The player's hand of cards


    // Constructor initializes the player's name and hand
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }


    // Draws a single card from the table
    public void draw(Table table) {
        Card card = table.drawCard();
        if (card != null) {
            hand.addCard(card);
        }
    }


    // Draws multiple cards from the table
    public void draw(Table table, int numberOfCards) {
        for (int i = 0; i < numberOfCards; i++) {
            draw(table);
        }
    }


    // Throws a card onto the table
    public void throwCard(Table table, Card card) {
        hand.removeCard(card);
        table.throwCard(card);
    }


    // Checks if the player has no cards left
    public boolean isDone() {
        return hand.isEmpty();
    }


    // Returns the player's name
    public String toString() {
        return name;
    }


    // Human player's card selection logic
    public Card selectCard(Table table) {
        System.out.println("Your hand:");
        hand.printHand();
        System.out.println("Table top card: " + table.getTopCard());

        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                System.out.print("Select a card to throw (index) or -1 to pass: ");
                int choice = scanner.nextInt();

                if (choice == -1) {
                    return null;
                }

                if (choice >= 0 && choice < hand.getCardCount()) {
                    Card selectedCard = hand.getCard(choice);
                    if (selectedCard.matches(table.getTopCard())) {
                       if (selectedCard.isEight()) {
                           System.out.print("Select a new suit (H/S/D/C): ");
                           selectedCard.setCardColor(scanner.next());
                        }
                        return selectedCard;
                    } else {
                        System.out.println("Invalid choice, card doesn't match.");
                    }
                } else {
                    System.out.println("Invalid index, try again.");
                }
            }
        } finally {
            // Close scanner to prevent resource leaks
            scanner.close(); 
        }
    }

    
    // Computer player's card selection logic
    public Card computerSelectCard(Table table) {
        return hand.findMatchingCard(table.getTopCard());
    }


    // Main method to test the Player class
    public static void main(String[] args) {
        Table table = new Table();
        Player player = new Player("Human");

        player.draw(table, 5);
        System.out.println("Player's hand after drawing:");
        player.hand.printHand();

        Card selectedCard = player.selectCard(table);
        if (selectedCard != null) {
            player.throwCard(table, selectedCard);
            System.out.println("Card thrown: " + selectedCard);
        } else {
            System.out.println("Player passed.");
        }
    }
}
