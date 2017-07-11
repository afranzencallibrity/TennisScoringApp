package Tennis;

import java.util.HashMap;

/**
 * Created by afranzen on 5/24/17.
 */

public class Game {
    private int playerOnePoints = 0;
    private int playerTwoPoints = 0;
    protected Set set = new Set();

    private HashMap<Integer, String> scoreValue = new HashMap<Integer, String>() {{
        put(0, "love");
        put(1, "15");
        put(2, "30");
        put(3, "40");
    }};

    public void playerOneScored() {
        playerOnePoints++;
    }

    public void playerTwoScored() {
        playerTwoPoints++;
    }

    public String score() {
        if(isPlayerOneWinner()) {
            set.p1WonSetPoint();
            initializeNextGame();
            return "Player One Won Game";
        }
        else if(isPlayerTwoWinner()) {
            set.p2WonSetPoint();
            initializeNextGame();
            return "Player Two Won Game";
        }
        else if(isDeuce()) {
            return "Deuce";
        }
        else if(hasAdvantage()) {
            return getAdvantage();
        }

        return convertPointsToScore();
    }

    private void initializeNextGame() {
        playerOnePoints = playerTwoPoints = 0;
    }

    private boolean isPlayerOneWinner() {
        return playerOnePoints > 3 && playerOnePoints - playerTwoPoints >= 2;
    }

    private boolean isPlayerTwoWinner() {
        return playerTwoPoints > 3 && playerTwoPoints - playerOnePoints >= 2;
    }

    private String convertPointsToScore() {
        if(isInitialScore()) {
            return "love all";
        }
        return scoreValue.get(playerOnePoints) + "-" + scoreValue.get(playerTwoPoints);
    }

    private boolean isInitialScore() {
        return playerOnePoints == 0 && playerTwoPoints == 0;
    }

    private boolean hasAdvantage() {
        return playerOnePoints == 4 || playerTwoPoints == 4;
    }

    private boolean isDeuce() {
        return playerOnePoints == 3 && playerTwoPoints == 3;
    }

    private String getAdvantage() {
        return playerOnePoints == 4 ? "Advantage In" : "Advantage Out";
    }

}
