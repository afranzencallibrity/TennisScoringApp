package Tennis;

/**
 * Created by afranzen on 7/10/17.
 */
public class Match {
    protected Game game = new Game();
    public String[] sets = new String[3];
    private int currentSet = 0;

    public String score() {
        if(game.set.score().contains("Won") && currentSet < 3) {
            sets[currentSet] = game.set.getPlayerOneSetPoints() + " " + game.set.getPlayerTwoSetPoints();
            currentSet++;
            game.set = new Set();
        }
        return game.set.score() + " " + game.score();
    }

}