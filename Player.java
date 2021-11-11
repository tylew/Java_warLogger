import java.util.*;

public class Player{

  private LinkedList<Card> hand = new LinkedList<Card>();
  private int cardCount;

  //constructor for a player with 26 cards
  public Player(Deck d){
    cardCount = 0;
    for(int i = 0;i<26;i++){
      cardCount += 1;
      hand.add(d.deal());
    }
  }
  //Checks if player is still in game, returns 0 if out, 1 if still playing, and 2 if has 52 cards
  public int checkHand(){
    if(cardCount==0){
      return 0;
    }else if(hand.size()==52){
      return 2;
    }
    return 1;
  }
  //Removes and returns card from top of deck
  public Card flip(){
    Card c = hand.get(0);
    hand.remove(0);
    cardCount -= 1;
    return c;
  }
  //Gives card to player
  public void collect(Card c){
    hand.add(c);
    cardCount += 1;
  }
}
