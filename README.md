# Crazy Eights Game

Welcome to the "Crazy Eights Game", a simplified version of the popular card game implemented in Java. The game supports human vs. computer gameplay, challenging you to outsmart the AI opponents.


## Game Instructions
- Objective: Be the first player to get rid of all your cards.
- How to Play: The game begins with a shuffled deck, and each player is dealt five cards. On your turn, either play a card   that matches the top card on the
  table in color or number, or play an "8" card to change the color. If you cannot play a card, draw one from the pile. The game continues until one player
  has no cards left.
- Special Rules: An "8" card can be played at any time and allows you to choose the next color. If the draw pile is empty, the discarded cards are reshuffled
  into a new pile.
- Game End: The first player to get rid of all their cards wins the game.


## Implementation Details
- The game is implemented in Java with object-oriented principles.
- The card deck consists of 40 cards: 10 numbers (0-9) for each of the 4 suits (H, S, D, C).
- Key game components: **`Card`** represents a single card with color and number. **`Pile`** manages the deck and shuffling. **`Hand`** represents a player's
  hand of cards. **`Table`** tracks the top card and manages drawing and discarding. **`Player`** handles the player's actions (human or computer). 
  **`CrazyEights`**Controls game flow and logic. **`Game`** entry point to start the game.


## How to Run
- Clone the Repository:
  ```bash
  git clone https://github.com/ChristosGkovaris/The-Crazy-Eights-Game.git
  cd The-Crazy-Eights-Game
