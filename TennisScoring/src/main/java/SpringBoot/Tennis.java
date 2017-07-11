package SpringBoot;

/**
 * Created by afranzen on 5/25/17.
 */

import org.springframework.web.bind.annotation.*;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@RestController
public class Tennis {
    private TennisMatch match = new TennisMatch();

    @RequestMapping(value="/tennis", method=GET)
    @ResponseBody
    public String tennis() {
        return "love all";
    }

    @RequestMapping(value="/tennis/playerOne", method=GET)
    @ResponseBody
    public String playerOneScored() {
        match.incrementPlayerOneScore();
        return match.score();
    }

    @RequestMapping(value="/tennis/playerTwo", method=GET)
    @ResponseBody
    public String playerTwoScored() {
        match.incrementPlayerTwoScore();
        return match.score();
    }

    @RequestMapping(value="/tennis/newGame", method=GET)
    @ResponseBody
    public String newMatch() {
        this.match = new TennisMatch();
        return "love all";
    }

    @RequestMapping(value="/tennis/matchScore", method=GET)
    @ResponseBody
    public String[] getMatchScore() {
        return match.sets;
    }
}
