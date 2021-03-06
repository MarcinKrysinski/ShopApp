package validator;

import entity.User;
import exception.UserLoginAlreadyExistException;
import exception.UserShortLengthLoginException;
import exception.UserShortLengthPasswordException;


public class UserValidator {

    private final int minLengthPassword = 6;
    private final int minLengthLogin = 4;

    private static UserValidator instance = null;

    private UserValidator() {

    }

    public static UserValidator getInstance() {
        if (instance == null) {
            instance = new UserValidator();
        }
        return instance;
    }


    public boolean isValid(User user) throws UserShortLengthLoginException, UserShortLengthPasswordException, UserLoginAlreadyExistException {
        if(isUserLoginLengthIsTooShort(user.getLogin())){
            throw new UserShortLengthLoginException("Login is too short (min. 4 characters)");
        }
        else if (isUserPasswordLengthIsTooShort(user.getPassword())){
            throw new UserShortLengthPasswordException("Password is too short (min. 6 characters");
        }
        return true;
    }


    private boolean isUserLoginLengthIsTooShort(String login){
        if (login.length() < minLengthLogin){
            return true;
        }
        return false;
    }

    private boolean isUserPasswordLengthIsTooShort(String password){
        if (password.length() < minLengthPassword){
            return true;
        }
        return false;
    }
}
