package ch.uzh.ifi.seal.soprafs18.Controller;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Service.EndGameService;
import ch.uzh.ifi.seal.soprafs18.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


public class EndGameController {

    private final String CONTEXT = "/Games";

    @Autowired
    private EndGameService endGameService;

    @GetMapping(value = CONTEXT + "/{room}/reached")
    @ResponseStatus(HttpStatus.OK)
    public Boolean reached(@PathVariable("room")String room){
        return endGameService.endgame(room);
    }

    @GetMapping(value = CONTEXT + "/{room}/end")
    @ResponseStatus(HttpStatus.OK)
    public Player winner(@PathVariable("room")String room){
        return endGameService.getWinner(room);
    }



}
