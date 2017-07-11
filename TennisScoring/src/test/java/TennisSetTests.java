import Tennis.Set;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by afranzen on 7/10/17.
 */
public class TennisSetTests {
    Set set = new Set();
    private void addPlayerOneSetPoints(int points) {
        for(int i = 0; i < points; i++) {
            set.p1WonSetPoint();
        }
    }

    private void addPlayerTwoSetPoints(int points) {
        for(int i = 0; i < points; i++) {
            set.p2WonSetPoint();
        }
    }

    @Test
    public void testPlayerOneWinsSet() {
        addPlayerOneSetPoints(6);
        Assert.assertEquals("Player One Won Set", set.score());
    }

    @Test
    public void testPlayerTwoWinsSet() {
        addPlayerTwoSetPoints(6);
        Assert.assertEquals("Player Two Won Set", set.score());
    }

    @Test
    public void testPlayerOneHasNotWonSet() {
        addPlayerOneSetPoints(6);
        addPlayerTwoSetPoints(5);
        Assert.assertEquals("6-5", set.score());
    }

    @Test
    public void testPlayerOneWinsBy2() {
        addPlayerOneSetPoints(7);
        addPlayerTwoSetPoints(5);
        Assert.assertEquals("Player One Won Set", set.score());
    }

    @Test
    public void testTieBreaker() {
        addPlayerOneSetPoints(6);
        addPlayerTwoSetPoints(6);
        Assert.assertEquals("Tie Breaker", set.score());
    }

    @Test
    public void testSomethingBrokenInMatch() {
        addPlayerTwoSetPoints(5);
        Assert.assertEquals("0-5", set.score());
    }


}
