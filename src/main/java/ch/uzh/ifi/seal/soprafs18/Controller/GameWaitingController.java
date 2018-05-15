package ch.uzh.ifi.seal.soprafs18.Controller;


import ch.uzh.ifi.seal.soprafs18.GameLogic.Market;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Service.GameWaitingService;
import ch.uzh.ifi.seal.soprafs18.Service.TurnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin
@RestController
public class GameWaitingController {
    private final String CONTEXT = "/Games";

    @Autowired
    private GameWaitingService gameWaitingService;
    @Autowired
    private TurnService turnService;

    @GetMapping(value = CONTEXT + "/{room}/users")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> getplayers(@PathVariable("room") String game){
        return gameWaitingService.getUser(game);
    }




    @GetMapping(value = CONTEXT + "/{room}/market")
    @ResponseStatus(HttpStatus.OK)
    public Market getcurrentmarket(@PathVariable(value = "room") String room){
        return turnService.getCurrentMarket(room);
    }

    @PutMapping(value = CONTEXT + "/{user}/{room}/exit")
    @ResponseStatus(HttpStatus.OK)
    public List<Player> leavePlayers(@PathVariable(value = "user",required = true) String user, @PathVariable(value = "room",required = true) String room){
        List<Player> players= gameWaitingService.leavegame(room,user);
        return players;
    }
}
