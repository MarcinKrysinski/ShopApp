package api;

import entity.User;
import java.util.List;

public interface UserDAO {

    void saveUser(User user);

    void removeUserByLogin(String login);
    void removeUserById(Long id);

    List<User> getAllUsers();

    void updateUser(User user);

}
