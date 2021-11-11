import java.util.*;

public class Simulation{
  //Holds all games in simulatiion
  private ArrayList<Game> game = new ArrayList<Game>();

  //Creates simulation with desired amount of games
  public Simulation(int gameNum){
    simulate(gameNum);
  }
  //Creates desired amount of games and plays.
  private void simulate(int gameNum){
    for(int i = 0;i<gameNum;++i){
      game.add(new Game(i+1));
      game.get(i).play();
    }
  }
  //Gets and returns all game statistics
  public String toString(){
    String ret = "\n";
    double averageBattles = 0;
    double averageWars = 0;
    double averageDoubleWars = 0;
    int maxBattles = 0;
    int minBattles = game.get(0).getBattles();;
    int maxWars = 0;
    int minWars = game.get(0).getWars();;
    int holdVar;

    for(int i = 0;i < game.size();++i){

      holdVar = game.get(i).getBattles();
      averageBattles += holdVar;
      if (holdVar>maxBattles){
        maxBattles = holdVar;
      }
      if (holdVar<minBattles){
        minBattles = holdVar;
      }

      holdVar = game.get(i).getWars();
      averageWars += holdVar;
      if (holdVar>maxWars){
        maxWars = holdVar;
      }
      if (holdVar<minWars){
        minWars = holdVar;
      }

      averageDoubleWars += game.get(i).getDoubleWars();
    }

    averageBattles = averageBattles/game.size();
    averageWars = averageWars/game.size();
    averageDoubleWars = averageDoubleWars/game.size();
    ret += "Out of " + game.size() + " games... \n\n";
    ret += "Average number of battles per game: " + averageBattles + ".\n";
    ret += "Average number of wars per game: " + averageWars + ".\n";
    ret += "Average number of double wars per game: " + averageDoubleWars + ".\n";
    ret += "Max number of battles in a game: " + maxBattles + ".\n";
    ret += "Min number of battles in a game: " + minBattles + ".\n";
    ret += "Max number of wars in a game: " + maxWars + ".\n";
    ret += "Min number of wars in a game: " + minWars + ".\n\n";
    return ret;

  }
  //Mainmainmain
  public static void main(String[] args){
    int num = Integer.parseInt(args[0]);
    Simulation s1 = new Simulation(num);
    System.out.print(s1);

    WarLogger.getInstance().release();
  }
}
