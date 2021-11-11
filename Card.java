public class Card{
  private int value;
  private String type;
  private String suit;
  //Default card constructor
  public Card(){
    value = 0;
    type = null;
    suit = null;
  }
  //Overload card constructor
  public Card(int v, String s){
    type = getType(v,s);
    value = v;
    suit = s;
  }
  //Associates card value with card type
  private String getType(int v, String s){
    if(v>=2&&v<=10){
      return (v + " of " + s + "s");
    }else if(v==11){
      return "Jack of " + s + "s";
    }else if(v==12){
      return "Queen of " + s + "s";
    }else if(v==13){
      return "King of " + s + "s";
    }else if(v==14){
      return "Ace of " + s + "s";
    }
    value = 0;
    return null;
  }
  //Get number value of a card
  public int getValue(){
    return value;
  }
  //Necessary for warLogger
  public String toString(){
    String ret = "";
    ret += getType(value,suit);
    return ret;
  }



}
