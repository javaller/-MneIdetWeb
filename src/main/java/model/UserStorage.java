package model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Home on 04.01.2017.
 */
public class UserStorage {

    private ArrayList<User> users;
    private static UserStorage sUserStorage;

    private static UserStorage get() {
        if (sUserStorage == null) {
            return new UserStorage();
        }
        return sUserStorage;
    }

    public void insertUser(User user) throws ClassNotFoundException, SQLException {
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            ps = conn
                    .prepareStatement("INSERT INTO MI_USER (BALANCE, AGE, NAME_USER, GENDER, COMPANY, EMAIL, ADDRESS)\n" +
                            "    VALUES (?, ?, ?, ?, ?, ?, ?)");
            ps.setDouble(1, user.getDoubleBallans());
            ps.setInt(2, user.getAge());
            ps.setString(3, user.getName());
            ps.setString(4, user.getGender());
            ps.setString(5, user.getCompany());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getAddress());

            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (ps != null) {
                ps.close();
            }
            if (conn != null) {
                conn.close();
            }
        }
    }

    public UserStorage() {
        users = new ArrayList<User>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setIndex("123123");
            user.setGuid("t123123");
            if (i % 2 == 0) {
                user.setActive(false);
            } else {
                user.setActive(true);
            }
            user.setBalance(50.0);
            user.setPicture("C:Test\test");
            user.setAge(18 + i);
            user.setEyeColor("blue");
            user.setName("Sasha");
            user.setGender("f");
            user.setCompany("Epam");
            user.setEmail("Epam@");
            user.setPhone("+8124445556");
            user.setAddress("test test test");
            user.setAbout("Tro lololololo");
            user.setRegistered("Chelusk 13");
            user.setLatitude(80.0);
            user.setLongitude(90.0);
            user.setGreeting("ola ola ola");
            user.setFavoriteFruit("mango mango");
            user.setFriends(null);
            user.setTags(null);
            users.add(user);
            System.out.println("User storage generated!");
        }
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public User getUser(Long userID){
        for(User user: users) {
            if (user.getId().equals(userID)) {
                return user;
            }
        }
        return null;
    }

    public Boolean addUser(User user) {
        users.add(user);
        return true;
    }

    public Boolean saveUsers() throws ClassNotFoundException {
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            Statement stmt = conn.createStatement();
            int deleteResult = stmt
                    .executeUpdate("delete from MI_USER");

            for (User user: users) {
                PreparedStatement ps = conn.prepareStatement("INSERT INTO MI_USER (BALANCE, AGE, NAME_USER, GENDER, COMPANY, EMAIL, ADDRESS)\n" +
                        "    VALUES (?, ?, ?, ?, ?, ?, ?)");
                ps.setDouble(1, user.getDoubleBallans());
                ps.setInt(2, user.getAge());
                ps.setString(3, user.getName());
                ps.setString(4, user.getGender());
                ps.setString(5, user.getCompany());
                ps.setString(6, user.getEmail());
                ps.setString(7, user.getAddress());

                ps.executeUpdate();

                System.out.println("User storage saved!");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}