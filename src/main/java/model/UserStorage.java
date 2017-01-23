package model;

import oracle.sql.ROWID;

import java.sql.*;
import java.util.ArrayList;
import java.util.Locale;

/**
 * Created by Home on 04.01.2017.
 */
public class UserStorage {

    private ArrayList<User> users;
    private static UserStorage sUserStorage;

    public UserStorage() {
        users = new ArrayList<User>();
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

    public Boolean deleteAllUsers() throws ClassNotFoundException {
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            Statement stmt = conn
                    .createStatement();

            int deleteResult = stmt
                    .executeUpdate("delete from FRIENDS");

            deleteResult = stmt
                    .executeUpdate("delete from USER_TAG");


            deleteResult = stmt
                    .executeUpdate("delete from MI_USER");

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public void loadAllUserFromDB () throws ClassNotFoundException {
//        Locale.setDefault(Locale.ENGLISH);
//        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            Statement stmt = conn
                    .createStatement();
            ResultSet rs = stmt
                    .executeQuery("select ID_USER, INDEX_USER, GUID, ISACTIVE, BALANCE, " +
                            "PICTURE, AGE, EYECOLOR, NAME_USER, GENDER, COMPANY, EMAIL," +
                            "PHONE, ADDRESS , ABOUT, REGISTERED, LATITUDE, LONGITUDE," +
                            "GREETING, FAVORITEFRUIT" +
                            " from MI_USER");
            while (rs.next()) {
                User user = new User();
                Long userID = rs.getLong(1);
                System.out.println(userID);
                Long index = rs.getLong(2);
                user.setIndex(index.toString());
                System.out.print(index + " ");
                String guid = rs.getString(3);
                user.setIndex(guid);
                System.out.print(guid + " ");
                Integer isActive = rs.getInt(4);
                if (isActive == 0) {
                    user.setActive(false);
                } else {
                    user.setActive(true);
                }
                Double balance = rs.getDouble(5);
                user.setBalance(balance);
                System.out.print(balance + " ");
                String picture = rs.getString(6);
                user.setPicture(picture);
                System.out.print(picture + " ");
                Integer age = rs.getInt(7);
                user.setAge(age);
                System.out.print(age + " ");
                String eyeColor = rs.getString(8);
                user.setEyeColor(eyeColor);
                System.out.print(eyeColor + " ");
                String name_user = rs.getString(9);
                user.setName(name_user);
                System.out.print(name_user + " ");
                String gender = rs.getString(10);
                user.setGender(gender);
                System.out.print(gender + " ");
                String conpany = rs.getString(11);
                user.setCompany(conpany);
                System.out.print(conpany + " ");
                String email = rs.getString(12);
                user.setEmail(email);
                System.out.print(email + " ");
                String phone = rs.getString(13);
                user.setPhone(phone);
                System.out.print(phone + " ");
                String address = rs.getString(14);
                user.setAddress(address);
                System.out.print(address + " ");
                String about = rs.getString(15);
                user.setAbout(about);
                System.out.print(about + " ");
                String registered = rs.getString(16);
                user.setRegistered(registered);
                System.out.print(registered + " ");
                Double latitude = rs.getDouble(17);
                user.setLatitude(latitude);
                System.out.print(latitude + " ");
                Double longitude = rs.getDouble(18);
                user.setLongitude(longitude);
                System.out.print(longitude + " ");
                String greeting = rs.getString(19);
                user.setGreeting(greeting);
                System.out.print(greeting + " ");
                String favoriteFruit = rs.getString(20);
                user.setFavoriteFruit(favoriteFruit);
                System.out.println(favoriteFruit);

                ArrayList<Friend> friends = new ArrayList<Friend>();
                Statement stmt1 = conn.createStatement();
                ResultSet rs1 = stmt1
                        .executeQuery("SELECT * FROM FRIENDS WHERE ID_USER = " + userID.toString());
                while (rs1.next()){
                    String friendName = rs1.getString(2);
                    System.out.println(friendName);
                    Friend friend = new Friend(friendName);
                    friends.add(friend);
                }

                ArrayList<Tag> tags = new ArrayList<>();
                Statement stmt2 = conn.createStatement();
                ResultSet rs2 = stmt2
                        .executeQuery("SELECT * FROM USER_TAG WHERE ID_USER = " + userID.toString());
                while (rs2.next()){
                    String tagName = rs2.getString(2);
                    System.out.println(tagName);
                    Tag tag = new Tag(tagName);
                    tags.add(tag);
                }
                users.add(user);
            }
            System.out.println(users.size());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

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

        try {
            conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            int userID = user.postUser(conn);

            for (Friend friend : user.getFriends()) {
                friend.postFriend(conn, userID);
            }

            for (Tag tag : user.getTags()) {
                tag.postTag(conn, userID);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (conn != null) {
                conn.close();
            }
        }
    }
}