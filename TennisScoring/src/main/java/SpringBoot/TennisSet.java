package SpringBoot;

/**
 * Created by afranzen on 7/10/17.
 */
public class TennisSet {
    private int playerOneSetScore = 0;
    private int playerTwoSetScore = 0;

    public int getPlayerOneSetScore() {
        return playerOneSetScore;
    }

    public int getPlayerTwoSetScore() {
        return playerTwoSetScore;
    }

    public void addPointToPlayerOneSet() {
        playerOneSetScore++;
        //return score();
    }

    public void addPointToPlayerTwoSet() {
        playerTwoSetScore++;
        //return score();
    }

    public static void main(String[] args) {
        TennisSet set = new TennisSet();
        for(int i = 0; i < 6; i++) {
            set.addPointToPlayerTwoSet();
        }

        System.out.println(set.score());
    }

    public String score() {
        if(playerOneSetScore == 0 && playerTwoSetScore == 0) {
            return "love all";
        }
        else if(playerOneSetScore == 6 && playerTwoSetScore == 6) {
            return "Tie Breaker";
        }
        else if(playerOneSetScore >= 6 && playerOneSetScore - playerTwoSetScore >= 2) {
            return "Player One Won Set";
        }
        else if(playerTwoSetScore >= 6 && playerTwoSetScore - playerOneSetScore >= 2) {
            return "Player Two Won Set";
        }

        return playerOneSetScore + "-" + playerTwoSetScore;
    }


}
