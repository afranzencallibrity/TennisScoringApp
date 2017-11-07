package Tennis;

/**
 * Created by afranzen on 5/25/17.
 */

import org.springframework.web.bind.annotation.*;


import static org.springframework.web.bind.annotation.RequestMethod.GET;

@CrossOrigin
@RestController
public class SpringBoot {
    private Match match = new Match();

    @RequestMapping(value="/tennis", method=GET)
    @ResponseBody
    public String tennis() {
        return match.score();
    }

    @RequestMapping(value="/tennis/playerOne", method=GET)
    @ResponseBody
    public String playerOneScored() {
        match.game.playerTwoScored();
        return match.score();
    }

    @RequestMapping(value="/tennis/playerTwo", method=GET)
    @ResponseBody
    public String playerTwoScored() {
        match.game.playerTwoScored();
        return match.score();
    }

    @RequestMapping(value="/tennis/newMatch", method=GET)
    @ResponseBody
    public String newMatch() {
        this.match = new Match();
        this.match.sets = new String[3];
        return "love all";
    }

    @RequestMapping(value="/tennis/matchScore", method=GET)
    @ResponseBody
    public String[] getMatchScore() {
        return match.sets;
    }

}
