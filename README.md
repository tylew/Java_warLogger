# War Logger

By Tyler Lewis
   tylewis@chapman.edu

   2020

War Logger project will simulate an args[0] amount of games consisting of battles and wars. The program returns stats across the games along with an output file of individual battle/war details.

Abstract solution involving 5 classes plus the Simulation driver class. All cards distributed to players are their own individual objects.

Game Rules
> In this game of War, two players battle each other to see who can win the most cards. At the start of a single game a deck of 52 cards (legal values 2-10, J, Q, K, A) is split evenly between the two players such that each player holds a stack of 26 random cards. For each battle of the game both players turn over three cards at the top of their stack, and compute the median (middle) value of the cards. If the player has fewer than 3 cards, they take the maximum value. The player with the higher value based on the median (or max value for a player with less than 3 cards) takes all cards played in the battle and places them on the bottom of their stack. If the two values played are equal (a "war"), each player lays down one card and the higher-valued card wins all of the cards on the table, which are then added to the bottom of the player's stack. In the case of another tie, the war process is repeated until there is no tie.
> A player wins by collecting all the cards. Once a single player holds all 52 cards, the game ends.


Navigate to folder containing the files in this repository and run the following command:

> javac Card.java Deck.java Player.java Game.java Simulation.java WarLogger.java

and then...

> java Simulation [args]
Replace [args] with desired amount of games to be played
