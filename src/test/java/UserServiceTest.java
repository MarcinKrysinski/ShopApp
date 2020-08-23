import entity.User;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import service.UserServiceImpl;

import java.util.ArrayList;
import java.util.List;

public class UserServiceTest {

//    @Test
//    public void getAllUsersTest(){
//
//        //is
//        List<User> usersList = new ArrayList<User>();
//        usersList.add(new User(1L, "Marcin", "qwerty"));
//        usersList.add(new User(2L, "Zuzia", "kotki2"));
//        usersList.add(new User(3L, "admin", "admin"));
//
//        //then
//        UserServiceImpl userService = new UserServiceImpl(usersList);
//        List<User> usersFromTestClass = userService.getAllUsers();
//
//        //when
//        Assertions.assertEquals(usersList, usersFromTestClass);
//
//    }
//
//    @Test
//    public void addUserTest(){
//
//        //is
//        List<User> usersList = new ArrayList<User>();
//        User user = new User(1L, "Marcin", "qwerty");
//        usersList.add(user);
//
//        //then
//        UserServiceImpl userService = new UserServiceImpl();
//        userService.addUser(user);
//        List<User> usersFromTestClass = userService.getAllUsers();
//
//        //when
//        Assertions.assertEquals(usersList, usersFromTestClass);
//
//    }
//
//    @Test
//    public void removeUserTest(){
//
//        //is
//        List<User> usersList = new ArrayList<User>();
//        User userOne = new User(1L, "Marcin", "qwerty");
//        User userTwo = new User(2L, "Zuzia", "kotki2");
//        usersList.add(userOne);
//        usersList.add(userTwo);
//
//        //then
//        UserServiceImpl userService = new UserServiceImpl(usersList);
//        userService.removeUserById(2L);
//        usersList.remove(userTwo);
//        List<User> usersFromTestClass = userService.getAllUsers();
//
//        //when
//        Assertions.assertEquals(usersList, usersFromTestClass);
//
//    }
//

}
