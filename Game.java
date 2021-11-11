import java.util.*;

public class Game{
  //lots of variables...
  private ArrayList<Card> table = new ArrayList<Card>();
  private ArrayList<Player> players = new ArrayList<Player>();
  private Deck d1 = new Deck();
  private int[] playerScore;
  private int battleCount;
  private int warCount;
  private int doubleWarCount;
  private int gameNum;
  private Card[] returnCards;
  //Constructor for 2 player game, param gn is game number
  public Game(int gn){
    playerScore = new int[2];
    battleCount = 0;
    gameNum = gn;
    warCount = 0;
    doubleWarCount = 0;
    for(int i=0; i<2;++i){
      players.add(new Player(d1));
    }
  }
  //Returns amount of battles taken plave in game
  public int getBattles(){
    return battleCount;
  }
  //returns amount of wars taken place in game
  public int getWars(){
    return warCount;
  }
  //returns amount of double wars taken place... if any.
  public int getDoubleWars(){
    return doubleWarCount;
  }
  //Contains main logic of game
  public void play(){
    while(players.get(0).checkHand()==players.get(1).checkHand()){
      this.battle();
    }
    if(players.get(1).checkHand()==0){
      WarLogger.getInstance().logGameOutcome(gameNum, "Player 1");

    }else if(players.get(0).checkHand()==0){
      WarLogger.getInstance().logGameOutcome(gameNum, "Player 2");
    }
  }
  //Puts cards on table and undergoes a battle
  public void battle(){

    battleCount += 1;

    for(int i = 0;i<2;++i){
      int numCards = 0;
      playerScore[i] = 0;
      returnCards = new Card[3];

      for(int j = 0; j<3;++j){
        if(players.get(i).checkHand()==1){
          table.add(players.get(i).flip());
          playerScore[i] += table.get(table.size()-1).getValue();
          returnCards[j] = table.get(table.size()-1);
          numCards+=1;
        }
      }
      WarLogger.getInstance().logBattle(battleCount,"Player " + (i+1),returnCards);
      if(numCards>0){
        playerScore[i] += playerScore[i]/numCards;
      }
    }

    Collections.shuffle(table);

    if(playerScore[0]>playerScore[1]){
      WarLogger.getInstance().logBattleOutcome(battleCount,"Player 1");
      for(int i=0; i<table.size(); ++i){
        players.get(0).collect(table.get(0));
        table.remove(0);
      }
    }if(playerScore[1]>playerScore[0]){
      WarLogger.getInstance().logBattleOutcome(battleCount,"Player 2");
      for(int i=0; i<table.size(); ++i){
        players.get(1).collect(table.get(0));
        table.remove(0);
      }
    }if(playerScore[0]==playerScore[1]){
      WarLogger.getInstance().logBattleOutcome(battleCount,"WAR!!!!");
      this.war();
    }
  }
  //Flips additional card for war. If player has no cards he retains score from battle.
  public void war(){

    warCount += 1;

    for(int i = 0;i<2;++i){
      if(players.get(i).checkHand()==1){
        table.add(players.get(i).flip());
        playerScore[i] = table.get(table.size()-1).getValue();
      }
    }

    Collections.shuffle(table);

    if(playerScore[0]>playerScore[1]){
      WarLogger.getInstance().logWarOutcome(warCount,"Player 1");
      for(int i=0; i<table.size(); ++i){
        players.get(0).collect(table.get(0));
        table.remove(0);
      }
    }if(playerScore[1]>playerScore[0]){
      WarLogger.getInstance().logWarOutcome(warCount,"Player 2");
      for(int i=0; i<table.size(); ++i){
        players.get(1).collect(table.get(0));
        table.remove(0);
      }
    }if(playerScore[0]==playerScore[1]){
      WarLogger.getInstance().logWarOutcome(warCount,"WAR!!!!");
      doubleWarCount += 1;
      war();
    }
  }
}
