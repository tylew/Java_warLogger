import java.util.*;

public class Deck{

  private ArrayList<Card> al = new ArrayList<Card>();

  //Creates deck of 52 cards
  public Deck(){
    for(int i = 2;i<=14;i++){
      al.add(new Card(i,"heart"));
      al.add(new Card(i,"club"));
      al.add(new Card(i,"spade"));
      al.add(new Card(i,"diamond"));
    }
  }
  //Distrubutes random card out of deck
  public Card deal(){
    int g = (int)(Math.random()*(al.size()-1));
    Card z = al.get(g);
    al.remove(g);
    return z;
  }

}
