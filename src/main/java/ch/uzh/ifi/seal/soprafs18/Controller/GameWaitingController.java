package ch.uzh.ifi.seal.soprafs18.Controller;


import ch.uzh.ifi.seal.soprafs18.Entity.User;
import ch.uzh.ifi.seal.soprafs18.Service.GameWaitingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class GameWaitingController {
    private final String CONTEXT = "/Games";

    @Autowired
    private GameWaitingService gameWaitingService;

    @GetMapping(value = CONTEXT + "/{room}/users")
    @ResponseStatus(HttpStatus.OK)
    public List<User> getplayers(@PathVariable("room") String game){
        return gameWaitingService.getUser(game);
    }


    @PutMapping(value = CONTEXT + "/{user}/{room}/exit")
    @ResponseStatus(HttpStatus.OK)
    public void leavePlayers(@PathVariable(value = "user",required = true) String username, @PathVariable(value = "room",required = true) String roomname){
         gameWaitingService.leaveGame(username, roomname);
    }
}
