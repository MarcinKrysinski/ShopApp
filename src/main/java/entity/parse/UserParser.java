package entity.parse;

import entity.User;

public class UserParser {

    public static User lineToObjectUser(String lineFromUsersList){
        String[] userInfo = lineFromUsersList.split(User.separatorUser);

        Long id = Long.parseLong(userInfo[0]);
        String login = userInfo[1];
        String password = userInfo[2];

        return new User(id, login, password);
    }
}
