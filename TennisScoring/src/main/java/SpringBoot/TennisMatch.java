package SpringBoot;

/**
 * Created by afranzen on 7/10/17.
 */
public class TennisMatch {
    private TennisGame game = new TennisGame();
    public String[] sets = new String[3];
    private int numOfSets = 0;

    public String score() {
        if(game.set.score().contains("Won") && numOfSets < 3) {
            sets[numOfSets] = game.set.getPlayerOneSetScore() + " " + game.set.getPlayerTwoSetScore();
            numOfSets++;
            game.set = new TennisSet();
        }
        return game.set.score() + " " + game.score();
    }
    public void incrementPlayerOneScore() {
        game.playerOneScored();
    }

    public void incrementPlayerTwoScore() {
        game.playerTwoScored();
    }

}