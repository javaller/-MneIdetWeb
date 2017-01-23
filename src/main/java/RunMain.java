import model.Friend;
import model.Tag;
import model.User;
import model.UserStorage;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Locale;

/**
 * Created by Home on 02.01.2017.
 */
public class RunMain {


    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        System.out.println("Hello");
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");

            UserStorage userStorage = new UserStorage();

            userStorage.loadAllUserFromDB();

//            userStorage.deleteAllUsers();
//
//            for (int i = 0; i < 10; i++) {
//
//                User user = new User();
//                user.setIndex("123123");
//                user.setGuid("t123123");
//                if (i % 2 == 0) {
//                    user.setActive(false);
//                } else {
//                    user.setActive(true);
//                }
//                user.setBalance(50.0);
//                user.setPicture("C:Test\test");
//                user.setAge(18 + i);
//                user.setEyeColor("blue");
//                user.setName("Sasha");
//                user.setGender("f");
//                user.setCompany("Epam");
//                user.setEmail("Epam@");
//                user.setPhone("+8124445556");
//                user.setAddress("test test test");
//                user.setAbout("Tro lololololo");
//                user.setRegistered("Chelusk 13");
//                user.setLatitude(80.0);
//                user.setLongitude(90.0);
//                user.setGreeting("ola ola ola");
//                user.setFavoriteFruit("mango mango");
//
//                Friend friend1 = new Friend("Mary");
//                Friend friend2 = new Friend("Oksana");
//
//                ArrayList<Friend> girlFriends = new ArrayList<Friend>();
//                girlFriends.add(friend1);
//                girlFriends.add(friend2);
//                user.setFriends(girlFriends);
//
//                Tag tag1 = new Tag("Eto Piter");
//                Tag tag2 = new Tag("Moscow");
//                ArrayList<Tag> uTags = new ArrayList<Tag>();
//                uTags.add(tag1);
//                uTags.add(tag2);
//                user.setTags(uTags);
//
//                userStorage.addUser(user);
//                System.out.println("User storage generated!");
//                userStorage.insertUser(user);
//            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}