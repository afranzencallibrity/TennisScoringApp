/**
 * Created by afranzen on 5/24/17.
 */
import SpringBoot.TennisGame;
import org.junit.Assert;
import org.junit.Test;


public class TennisGameTests {
    TennisGame tennis = new TennisGame();
    private void addPlayerPoints(int points, int player) {
        for(int i = 0; i < points; i++) {
            if(player == 1) {
                tennis.playerOneScored();
            }
            else {
                tennis.playerTwoScored();
            }
        }
    }


    @Test
    public void testPlayerTwoWinsGame() {
        addPlayerPoints(1, 1);
        addPlayerPoints(4,2);
        Assert.assertEquals("Player Two Won Game", tennis.score());
    }

    @Test
    public void testDeuce() {
        addPlayerPoints(3, 1);
        addPlayerPoints(3, 2);
        Assert.assertEquals("Deuce", tennis.score());
    }

    @Test
    public void testAdvantagePlayerTwo() {
        addPlayerPoints(3, 1);
        addPlayerPoints(4, 2);
        Assert.assertEquals("Advantage Out", tennis.score());
    }

    @Test
    public void testAdvantagePlayerOne() {
        addPlayerPoints(4, 1);
        addPlayerPoints(3, 2);
        Assert.assertEquals("Advantage In", tennis.score());
    }

    @Test
    public void testPlayerOneWinsGame() {
        addPlayerPoints(4, 1);
        addPlayerPoints(2, 2);
        Assert.assertEquals("Player One Won Game", tennis.score());
    }

    @Test
    public void testPlayerOneWinsOnDeuce() {
        addPlayerPoints(5, 1);
        addPlayerPoints(3, 2);
        Assert.assertEquals("Player One Won Game", tennis.score());

    }

    @Test
    public void testGetScoring() {
        addPlayerPoints(3,1);
        addPlayerPoints(1,2);
        Assert.assertEquals("40-15", tennis.score());
    }
}


