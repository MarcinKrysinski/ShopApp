package service;

import DAO.UserDAOImpl;
import api.UserDAO;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserServiceImpl implements UserService {

    private List<User> users;
    private static UserServiceImpl instance =null;
    private UserDAO userDAO = UserDAOImpl.getInstance();
    private UserValidator userValidator = UserValidator.getInstance();

    public static UserServiceImpl getInstance(){
        if(instance == null){
            instance = new UserServiceImpl();
        }
        return instance;
    }

    public UserServiceImpl() {
//        this.users = new ArrayList<User>();
    }

//    public UserServiceImpl(List<User> usersList) {
//        this.users = new ArrayList<User>(usersList);
//    }

    public List<User> getAllUsers() throws IOException {
        return userDAO.getAllUsers();
    }

    public void addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException {
        if(userValidator.isValid(user)){
            userDAO.saveUser(user);
        }

    }

    public void removeUserById(Long userId) throws IOException {
        userDAO.removeUserById(userId);
    }
}
