/**
 * SYST 17796 Project Base code.
 * Students can modify and extend to implement their game.
 * Add your name as an author and the date!
 */
package deliverable3;

import java.util.ArrayList;

/**
 * A concrete class that represents any grouping of cards for a Game. HINT, you
 * might want to subclass this more than once. The group of cards has a maximum
 * size attribute which is flexible for reuse.
 *
 * @author dancye
 * @author Paul Bonenfant Jan 2020
 */
public class GroupOfCards {

    //The group of cards, stored in an ArrayList
    private ArrayList<Card> cards;
    ArrayList<Card> deckOfCards;

    /**
     *
     * @param card
     */
    public static String addCard(Card card, ArrayList<Card> hand) {
        boolean existingCardMatched = false;
        if (hand.size() == 0) {
            hand.add(card);
            return "card added to your hand successfully";
        } else {
            for (int i = 0; i < hand.size(); i++) {
                if (hand.get(i).getSuit().compareTo(card.getSuit()) == 0
                        && hand.get(i).getValue().compareTo(card.getValue()) == 0) {
                    existingCardMatched = true;
                }
            }
            if (!existingCardMatched) {
                hand.add(card);
                return "card added to your hand successfully";

            } else {
                return "the match of existing card is also found in your hand";
            }
        }
    }

    /**
     *
     * @param index
     */
    public static String   removeCard(Card card, ArrayList<Card> hand) {
        boolean cardRemoved = false;
        for (int i = 0; i < hand.size(); i++) {
            if (card.getValue().compareTo(hand.get(i).getValue()) == 0
                    && card.getSuit().compareTo(hand.get(i).getSuit()) == 0) {
                hand.remove(i);
                cardRemoved = true;
            }
        }
        if (cardRemoved == false) {
         return "NO match for similar card you need to gofish ";
        }else{  return " ";}

    }

    public static boolean matchPairs(Card card, ArrayList<Card> hand) {
        int sameRankCards = 0;
        for (int k = 0; k < hand.size(); k++) {
            if (card.getValue().compareTo(hand.get(k).getValue()) == 0) {
                sameRankCards++;
            }
        }

        if (sameRankCards == 3) {
            System.out.print("you got 1 score as one pair matches");

            return true;
        } else {
            System.out.println(" matching pairs of four do not exist in your hand");
            return false;
        }
    }

    
}