package SpringBoot;

import javax.annotation.sql.DataSourceDefinition;

/**
 * Created by afranzen on 5/24/17.
 */

public class TennisGame {
    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    protected TennisSet set = new TennisSet();

    public void playerOneScored() {
        playerOneScore++;
    }

    public void playerTwoScored() {
        playerTwoScore++;
    }

    public String score() {
        if(isPlayerOneWinner()) {
            set.addPointToPlayerOneSet();
            playerOneScore = 0;
            playerTwoScore = 0;
            return "Player One Won Game";
        }
        else if(isPlayerTwoWinner()) {
            set.addPointToPlayerTwoSet();
            playerOneScore = 0;
            playerTwoScore = 0;
            return "Player Two Won Game";
        }
        if(isDeuce()) {
            return "Deuce";
        }
        else if(isAdvantage()) {
            return getAdvantage();
        }

        return convertPointsToValues();
    }

    private boolean isPlayerOneWinner() {
        return playerOneScore > 3 && playerOneScore - playerTwoScore >= 2;
    }

    private boolean isPlayerTwoWinner() {
        return playerTwoScore > 3 && playerTwoScore - playerOneScore >= 2;
    }

    private String convertPointsToValues() {
        String p1Score = getValue(playerOneScore);
        String p2Score = getValue(playerTwoScore);
        if(p1Score == "love" && p2Score == "love") {
            return "love all";
        }

        return p1Score + "-" + p2Score;
    }

    private boolean isAdvantage() {
        return playerOneScore == 4 || playerTwoScore == 4;
    }

    private boolean isDeuce() {
        return playerOneScore == 3 && playerTwoScore == 3;
    }

    private String getAdvantage() {
        return playerOneScore == 4 ? "Advantage In" : "Advantage Out";
    }

    private String getValue(int point) {
        if(point == 0) {
            return "love";
        }
        else if(point == 1) {
            return "15";
        }
        else if(point == 2) {
            return "30";
        }
        return "40";
    }

}
