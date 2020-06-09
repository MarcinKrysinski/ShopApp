package facade;

import api.UserRegisterLoginFacade;
import api.UserService;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;
import service.UserServiceImpl;

import java.io.IOException;


public class UserRegisterLoginFacadeImpl implements UserRegisterLoginFacade {

    private static UserRegisterLoginFacadeImpl instance = null;
    private UserService userService = UserServiceImpl.getInstance();

    public UserRegisterLoginFacadeImpl(){

    }

    public static UserRegisterLoginFacadeImpl getInstance(){
        if(instance == null){
            instance = new UserRegisterLoginFacadeImpl();
        }
        return instance;
    }


    public boolean registerUser(User user) throws UserLoginAlreadyExistException, UserShortLengthPasswordException, UserShortLengthLoginException, IOException {
        return userService.addUser(user);
    }

    public boolean loginUser(String login, String password) throws IOException {
        return userService.isCorrectLoginAndPassword(login, password);
    }
}
