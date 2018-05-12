package ch.uzh.ifi.seal.soprafs18.Service;

import org.junit.Test;

import static org.junit.Assert.*;
import ch.uzh.ifi.seal.soprafs18.Application;
import ch.uzh.ifi.seal.soprafs18.Constant.GameStatus;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Game;
import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;


import javax.xml.ws.http.HTTPBinding;
import javax.xml.ws.http.HTTPException;
import java.lang.annotation.Repeatable;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Application.class)
@WebAppConfiguration
//@SpringBootTest(webEnvironment=SpringBootTest.WebEnvironment.DEFINED_PORT)
public class UserServiceTest {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    private List<Game> games = new ArrayList<>();
    private Player player= new Player();
    private Player player2= new Player();


    @Test
    public void createUser() {
        player.setName("testName");
        userService.addUser(player);
        Player user = userService.getUsers().get(0);
        assertNotNull(userRepository.findByName(user.getName()));
        assertEquals(user.getName(),"testName");
        assertNotNull(user.getName());
    }


    @Test
    public void getUsers() {
        player2.setName("player2");
        userService.addUser(player2);
        userService.addUser(player);
        List<Player> players = userService.getUsers();
        Assert.assertEquals(3,players.size());

    }


}