// Represents a single card in the game
class Card {
    private int cardNumber;       // The number of the card (0-9)
    private String cardColor;     // The color (suit) of the card

    // Constructor initializes the card's color and number
    public Card(String cardColor, int cardNumber) {
        this.cardNumber = cardNumber;
        this.cardColor = cardColor;
    }

    // Returns the color of the card
    public String getCardColor() {
        return cardColor;
    }

    // Sets the color of the card
    public void setCardColor(String color) {
        this.cardColor = color;
    }

    // Returns the number of the card
    public int getCardNumber() {
        return cardNumber;
    }

    // Returns a string representation of the card (e.g., "H8")
    public String toString() {
        return cardColor + cardNumber;
    }

    // Checks if the card is an eight
    public boolean isEight() {
        return cardNumber == 8;
    }

    // Checks if the card matches another card in either color or number
    public boolean matches(Card other) {
        return this.cardNumber == other.cardNumber || this.cardColor.equals(other.cardColor);
    }
}
