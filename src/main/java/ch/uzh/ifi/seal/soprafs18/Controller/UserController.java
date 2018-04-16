package ch.uzh.ifi.seal.soprafs18.Controller;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
public class UserController {
    private final String CONTEXT = "/User";

    @Autowired
    private UserService userService;

    @GetMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.OK)
    public List<Player> getUsers(){
        return userService.getUsers();
    }

    @PostMapping(value = CONTEXT)
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody Player user){
        userService.addUser(user);
    }

    @Transactional
    @RequestMapping(value = CONTEXT +"/{name}",method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteUser(@PathVariable("name") String name){
        userService.deleteUser(name);
    }
}