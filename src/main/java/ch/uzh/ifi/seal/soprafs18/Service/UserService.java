package ch.uzh.ifi.seal.soprafs18.Service;

import ch.uzh.ifi.seal.soprafs18.Resource.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class UserService {

    private List<User> users = new ArrayList<>(Arrays.asList(
            new User("Nimra"),
            new User("Angela"),
            new User("Alexandra")
    )
    );

    public List<User> getUsers(){
        return users;
    }

    public void addUser(User user){
        users.add(user);
    }

    public void deleteUser(String username){
        users.remove(username);
    }

}

