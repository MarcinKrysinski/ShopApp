package service;

import api.UserService;
import entity.User;

import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    List<User> users;
    private static UserServiceImpl instance =null;

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public UserServiceImpl() {
//        this.users = new ArrayList<User>();
    }

    public UserServiceImpl(List<User> usersList) {
        this.users = new ArrayList<User>(usersList);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUserById(Long userId) {
        for(int i=0; i < users.size(); i++) {
            User userFromList = users.get(i);
            if (userFromList.getId() == userId){
                users.remove(i);
                break;
            }
        }
    }
}
