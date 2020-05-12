package validator;

import DAO.UserDAOImpl;
import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;

public class UserValidator {

    private final int minLengthPassword = 6;
    private final int minLengthLogin = 4;

    private static UserValidator instance;

    private UserValidator() {

    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }

    public boolean isValid(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException, UserLoginAlreadyExistException {
        if (isUserByLoginExist(user.getLogin())){
            throw new UserLoginAlreadyExistException("User with this login is already exist");
        }
        else if(user.getLogin().length() < minLengthLogin){
            throw new UserShortLengthLoginException("Login is too short (min. 4 characters)");
        }
        else if (user.getPassword().length() < minLengthPassword){
            throw new UserShortLengthPasswordException("Password is too short (min. 6 characters");
        }
        return true;
    }

    private boolean isUserByLoginExist(String login){
        return false;
    }
}
