package service;

import DAO.UserDAOImpl;
import api.UserDAO;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import validator.UserValidator;
import java.util.List;


public class UserServiceImpl implements UserService {


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
    }

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    public boolean addUser(User user) throws UserLoginAlreadyExistException, UserShortLengthLoginException, UserShortLengthPasswordException {

            if (isUserByLoginExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValid(user)) {
                userDAO.saveUser(user);
                return true;
            }

        return false;
    }

    public void removeUserById(Long userId) {
        userDAO.removeUserById(userId);
    }

    public User getUserById(Long id) {
       List<User> users = getAllUsers();
       return users.stream().filter(user -> user.getId().equals(id)).findAny().orElse(null);

    }

    public User getUserByLogin(String login) {
        List<User> users = null;
            users = getAllUsers();
            return users.stream().filter(user -> user.getLogin().equals(login))
                    .findFirst().orElse(null);
    }

    public boolean isCorrectLoginAndPassword(String login, String password){
        User user = getUserByLogin(login);
        if (user == null ){
            return false;
        }

        boolean isCorrectLogin = user.getLogin().equals(login);
        boolean isCorrectPassword = user.getPassword().equals(password);

        return  isCorrectLogin && isCorrectPassword;
    }

    private boolean isUserByLoginExist(String login) {
        User user = getUserByLogin(login);
        if (user != null){
            return true;
        }
        return false;
    }

}
