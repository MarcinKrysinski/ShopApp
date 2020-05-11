package entity.Parse;

import entity.User;

public class UserParser {

    public static User convertStringToUser(String readOneLineFromFile){
        if (readOneLineFromFile != null){
            return lineToObjectUser(readOneLineFromFile);
        }
        return null;
    }

    public static User lineToObjectUser(String lineFromUsersList){
        String[] userInfo = lineFromUsersList.split(User.separator);

        long id = Long.parseLong(userInfo[0]);
        String login = userInfo[1];
        String password = userInfo[2];

        return new User(id, login, password);
    }
}
