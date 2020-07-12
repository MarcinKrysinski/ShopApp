package DAO;

import api.UserDAO;
import entity.parse.UserParser;
import entity.User;
import utilities.FileUtilites;

import java.io.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOImpl implements UserDAO {

    private Connection connection;
    private final String databaseName = "management";
    private final String tableName = "users";
    private final String user = "rootMK";
    private final String password = "admin";

    private final String fileName = "users.data";
    private static UserDAOImpl instance = null;

    public static UserDAOImpl getInstance(){
        if(instance == null){
            instance = new UserDAOImpl();
        }
        return instance;
    }

    public UserDAOImpl() {
        init();
    }

    private void init() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection =
                    DriverManager.getConnection("jdbc:mysql://localhost/"+databaseName+
                            "?useSSL=false", user, password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void saveUser(User user) {
        PreparedStatement statement;
        try{
            String query = "insert into " + tableName + " (login, password) values (?, ?)";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            statement.execute();
            statement.close();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }


    public void removeUserByLogin(String login) {
        PreparedStatement statement;
        try{
            String query = "delete from " + tableName + " where login = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, login);

            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void removeUserById(Long id) {
        PreparedStatement statement;
        try{
            String query = "delete from " + tableName + " where ID = ?";
            statement = connection.prepareStatement(query);

            statement.setLong(1, id);

            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public List<User> getAllUsers() {
        List<User> usersList = new ArrayList<User>();
        Statement statement = null;
        try{
            statement = connection.createStatement();
            String query = "select * from " + tableName;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()){
                Long id = resultSet.getLong("ID");
                String login = resultSet.getString("login");
                String password =resultSet.getString("password");

                User user = new User(id, login, password);
                usersList.add(user);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return usersList;
    }

    public void updateUser(User user) {
        PreparedStatement statement;
        try{
            String query = "update " + tableName + " set login = ?, password = ? where id = ?";
            statement = connection.prepareStatement(query);

            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            statement.execute();
            statement.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


}
