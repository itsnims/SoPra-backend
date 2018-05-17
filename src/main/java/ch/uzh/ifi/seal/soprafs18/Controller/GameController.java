package ch.uzh.ifi.seal.soprafs18.Controller;


import ch.uzh.ifi.seal.soprafs18.GameLogic.BoardPart.Blockade;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@CrossOrigin
@RestController
public class GameController {
    private final String CONTEXT = "/Games";

    @Autowired
    private GameService gameService;


    @GetMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<Game> getGames(){
        return gameService.getGames();
    }

    @GetMapping(value = CONTEXT + "/{room}/wait")
    @ResponseStatus(HttpStatus.OK)
    public List<Integer> getPlayersWait(@PathVariable("room")String room){
        return gameService.getCurrent(room);
    }

    @GetMapping(value = CONTEXT + "/{room}")
    @ResponseStatus(HttpStatus.OK)
    public Game getGame(@PathVariable("room")String room){
        return gameService.getOneGame(room);
    }

    @PostMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.CREATED)
    public void createGame(@RequestBody Game game){
        gameService.addGame(game);
    }

    @Transactional
    @DeleteMapping(value = CONTEXT + "/{room}/delete")
    @ResponseStatus(HttpStatus.OK)
    public void deleteGame(@PathVariable("room") String room){
        gameService.deleteGame(room);
    }


    @PutMapping(value = CONTEXT + "/{user}/{room}/{secret}/join")
    @ResponseStatus(HttpStatus.OK)
    public boolean joingame(@PathVariable(value = "user",required = true) String username, @PathVariable(value = "room",required = true) String roomname, @PathVariable(value = "secret",required = false) String secret ){
        Boolean joined = gameService.joinGame(roomname,username,secret);
        return joined;

    }

    @GetMapping(value = CONTEXT + "/{room}/currentPlayer")
    @ResponseStatus(HttpStatus.OK)
    public Player getCurrentPlayer(@PathVariable(value = "room",required = true) String roomname){
        return gameService.getCurrentPlayer(roomname);

    }

    @GetMapping(value = CONTEXT + "/{room}/blockade")
    @ResponseStatus(HttpStatus.OK)
    public List<Blockade> getcurrentblockades(@PathVariable(value = "room",required = true) String roomname){
        return gameService.getBlockade(roomname);
    }

    @GetMapping(value = CONTEXT + "/{room}/CurrentBottom")
    @ResponseStatus(HttpStatus.OK)
    public Integer currBottomCards(@PathVariable(value = "room",required = true) String roomname) {
        return gameService.getCurrBottom(roomname);

    }

    @CrossOrigin
    @PutMapping(value = CONTEXT + "/{room}/Fast")
    @ResponseStatus(HttpStatus.OK)
    public void fast(@PathVariable(value = "room",required = true) String roomname) {
        gameService.FastForward(roomname);

    }

    @GetMapping(value = CONTEXT + "/{room}/{user}/blockadePoints")
    @ResponseStatus(HttpStatus.OK)
    public Integer currPoints(@PathVariable(value = "room",required = true) String roomname,@PathVariable(value = "user",required = true) String user) {
        return gameService.getPoints(roomname, user);

    }

    @GetMapping(value = CONTEXT + "/{room}/Currentblockade")
    @ResponseStatus(HttpStatus.OK)
    public List<Blockade> getcurrentblockades2(@PathVariable(value = "room",required = true) String roomname){
        return gameService.getBlockade(roomname);
    }








    


}
