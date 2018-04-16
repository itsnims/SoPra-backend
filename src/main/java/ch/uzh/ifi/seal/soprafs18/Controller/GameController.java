package ch.uzh.ifi.seal.soprafs18.Controller;


import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GameController {
    private final String CONTEXT = "/Games";

    @Autowired
    private GameService gameService;

    @GetMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getUsers(){
        return gameService.getGames();
    }

    @PostMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Game game){
        gameService.addGame(game);
    }

    @PutMapping(value = CONTEXT + "/{user}/{room}/{secret}/join")
    @ResponseStatus(HttpStatus.OK)
    public boolean joingame(@PathVariable(value = "user",required = true) String username, @PathVariable(value = "room",required = true) String roomname, @PathVariable("secret") String secret){
        Boolean joined = gameService.joinGame(roomname,username,secret);
        return joined;

    }


}
