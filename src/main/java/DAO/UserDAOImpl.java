package DAO;

import api.UserDAO;
import entity.Parse.UserParser;
import entity.User;
import utilities.FileUtilites;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private final String fileName = "data";
    private static UserDAOImpl instance = null;

    public static UserDAOImpl getInstance(){
        if(instance == null){
            instance = new UserDAOImpl();
        }
        return instance;
    }

    public UserDAOImpl() {

    }


    public void saveUser(User user) throws IOException {
        List<User> usersList = new ArrayList<User>();
        usersList.add(user);
        saveUsers(usersList);
    }

    public void saveUsers(List<User> usersList) throws FileNotFoundException {
        FileUtilites.clearFile(fileName);
        PrintWriter printWriter = new PrintWriter(new FileOutputStream(fileName, true));
        for (User iUser: usersList) {
            printWriter.write(iUser.toString() + "\n");
        }
        printWriter.close();
    }


    public void removeUserByLogin(String login) throws IOException {
        List<User> usersList = getAllUsers();

        for (User iUser : usersList) {
            if (login.equals(iUser.getLogin()))
                usersList.remove(login);
            break;
        }
        saveUsers(usersList);
    }

    public void removeUserById(long id) throws IOException {
        List<User> usersList = getAllUsers();

        for (User iUser:usersList) {
            if (iUser.getId() == id)
                usersList.remove(id);
            break;
        }
        saveUsers(usersList);
    }

    public List<User> getAllUsers() throws IOException {
        List<User> usersList = new ArrayList<User>();

        FileReader fileReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fileReader);
        String readOneLineFromFile = reader.readLine();
        while(readOneLineFromFile != null) {
            User user = UserParser.convertStringToUser(readOneLineFromFile);
//            System.out.println(readOneLineFromFile);
            readOneLineFromFile = reader.readLine();
            usersList.add(user);
        }
        reader.close();
        return usersList;
    }

    public User getUserByLogin(String login) throws IOException {
        List<User> usersList = getAllUsers();

        for (User iUser : usersList) {
            if (login.equals(iUser.getLogin()))
                return iUser;
        }
        return null;
    }

    public User getUserById(long id) throws IOException {
        List<User> usersList = getAllUsers();

        for (User iUser : usersList) {
            if (iUser.getId() == id)
                return iUser;
        }
        return null;
    }
}
