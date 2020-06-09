package service;

import DAO.UserDAOImpl;
import api.UserDAO;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import validator.UserValidator;

import java.io.IOException;
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
    }

    public List<User> getAllUsers() throws IOException {
        return userDAO.getAllUsers();
    }

    public boolean addUser(User user){
        try {
            if (isUserByLoginExist(user.getLogin())) {
                throw new UserLoginAlreadyExistException();
            }

            if (userValidator.isValid(user)) {
                userDAO.saveUser(user);
                return true;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return false;
    }

    public void removeUserById(Long userId) throws IOException {
        userDAO.removeUserById(userId);
    }

    public User getUserById(Long id) throws IOException {
       List<User> users = getAllUsers();
        for (User user: users) {
            boolean isFoundUser = user.getId().equals(id);
            if (isFoundUser){
                return user;
            }
        }
        return null;
    }

    public User getUserByLogin(String login) {
        List<User> users = null;
        try {
            users = getAllUsers();
            for (User user : users
            ) {
                boolean isFoundUser = user.getLogin().equals(login);
                if (isFoundUser) {
                    return user;
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean isCorrectLoginAndPassword(String login, String password) {
        User user = getUserByLogin(login);

        if (user == null ){
            return false;
        }

        boolean isCorrectLogin = user.getLogin().equals(login);
        boolean isCorrectPassword = user.getPassword().equals(password);

        return  isCorrectLogin && isCorrectPassword;
    }

    private boolean isUserByLoginExist(String login) throws IOException {
        User user = getUserByLogin(login);
        if (user != null){
            return true;
        }
        return false;
    }

}
