package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.GameLogic.Player;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<Player> getUsers(){
        List<Player> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(Player player){
        userRepository.save(player);
    }

    public void deleteUser(String name){
        userRepository.deleteByName(name);
    }
}
