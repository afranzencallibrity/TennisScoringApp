package Tennis;

/**
 * Created by afranzen on 7/10/17.
 */
public class Set {
    private int playerOneSetPoints = 0;
    private int playerTwoSetPoints = 0;

    public int getPlayerOneSetPoints() { return playerOneSetPoints; }

    public int getPlayerTwoSetPoints() { return playerTwoSetPoints; }

    public void p1WonSetPoint() { playerOneSetPoints++; }

    public void p2WonSetPoint() { playerTwoSetPoints++; }

    public String score() {
        if(playerOneSetPoints == 0 && playerTwoSetPoints == 0) {
            return "love all";
        }
        else if(playerOneSetPoints == 6 && playerTwoSetPoints == 6) {
            return "Tie Breaker";
        }
        else if(playerOneSetPoints >= 6 && playerOneSetPoints - playerTwoSetPoints >= 2) {
            return "Player One Won Set";
        }
        else if(playerTwoSetPoints >= 6 && playerTwoSetPoints - playerOneSetPoints >= 2) {
            return "Player Two Won Set";
        }

        return playerOneSetPoints + "-" + playerTwoSetPoints;
    }


}
