/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package deliverable3;

import java.util.ArrayList;
import java.util.*;

/**
 * The class that models your game. You should create a more specific child of
 * this class and instantiate the methods given.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class Game {

    private String name = null;
//    private GroupOfCards middlePile;
    //  private int cardsInMiddle;

    public static int numOfGames = 0;

    public Game() {

        numOfGames++;
    }

    public String startGame(ArrayList<Player> players, ArrayList< Card> deckOfCards) {

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j < 4; j++) {
                Card c1 = new Card(Card.Value.values()[i], Card.Suit.values()[j]);
                deckOfCards.add(c1);
            }
        }

        if (players.size() >= 2 && players.size() <= 4) {

            int handSize = 7;
            for (int i = 0; i < players.size(); i++) {
                ArrayList<Card> hand = new ArrayList<>();
                ArrayList<Card> deckOfRemovedCards = new ArrayList<>();
                players.get(i).setHand(hand, deckOfRemovedCards, deckOfCards);

            }
            return "game started succesfully";
        } else  return "player size must be between 2 and 4";
            
        
    }
    Scanner input = new Scanner(System.in);

    /**
     * When the game is over, use this method to declare and display a winning
     * player.
     */
    public String exitGame(ArrayList<Player> players) {
        if (players.size() != 0) {
            int highestScore = players.get(0).getScore();
            String winner = "player 1";
            for (int i = 0; i < players.size(); i++) {
                if (players.get(i).getScore() > highestScore) {
                    winner = ("player " + (i + 1));
                    highestScore = players.get(i).getScore();
                }
                System.out.println("Score of player" + (i + 1) + " : " + players.get(i).getScore());
            }
            System.out.println("Winner is " + winner);
            return ("Winner is " + winner);
        }
        return ("Game do not have any players i.e. players is empty");
    }

}