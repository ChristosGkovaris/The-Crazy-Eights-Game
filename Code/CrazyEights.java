import java.util.ArrayList;
import java.util.Scanner;

class CrazyEights {
    private Table table;
    private ArrayList<Player> players;
    private int numberOfPlayers;

    public CrazyEights(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.table = new Table();
        this.players = new ArrayList<>();

        players.add(new Player("Human"));
        for (int i = 1; i < numberOfPlayers; i++) {
            players.add(new Player("Computer" + i));
        }

        for (Player player : players) {
            player.draw(table, 5);
        }
    }

    public void play() {
        boolean gameOver = false;
        int currentPlayerIndex = 0;

        while (!gameOver) {
            Player currentPlayer = players.get(currentPlayerIndex);
            System.out.println("\n" + currentPlayer + "'s turn.");
            System.out.println("Table top card: " + table.getTopCard());

            Card cardToPlay = currentPlayerIndex == 0
                    ? currentPlayer.selectCard(table)
                    : currentPlayer.computerSelectCard(table);

            if (cardToPlay != null) {
                currentPlayer.throwCard(table, cardToPlay);
                System.out.println(currentPlayer + " played: " + cardToPlay);
            } else {
                currentPlayer.draw(table);
                System.out.println(currentPlayer + " drew a card.");
            }

            if (currentPlayer.isDone()) {
                System.out.println("\n" + currentPlayer + " wins!");
                gameOver = true;
            }

            currentPlayerIndex = (currentPlayerIndex + 1) % numberOfPlayers;
        }
    }

    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.print("Enter the number of players (2-4): ");
            int numberOfPlayers = scanner.nextInt();
            while (numberOfPlayers < 2 || numberOfPlayers > 4) {
                System.out.print("Invalid input. Enter a number between 2 and 4: ");
                numberOfPlayers = scanner.nextInt();
            }

            CrazyEights game = new CrazyEights(numberOfPlayers);
            game.play();
        }
    }
}
