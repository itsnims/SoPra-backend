package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.Entity.User;
import ch.uzh.ifi.seal.soprafs18.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    public void addUser(User user){
        userRepository.save(user);
    }

    public void deleteUser(String name){
        userRepository.deleteByName(name);
    }
}
