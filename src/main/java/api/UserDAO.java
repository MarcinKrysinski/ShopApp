package api;

import entity.User;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

public interface UserDAO {

    void saveUser(User user) throws FileNotFoundException, IOException;
    void saveUsers(List<User> users) throws FileNotFoundException;
    void removeUserByLogin(String login) throws IOException;
    void removeUserById(long id) throws IOException;

    List<User> getAllUsers() throws IOException;
    User getUserByLogin(String login) throws IOException;
    User getUserById(long id) throws IOException;

}
