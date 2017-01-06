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

    public void addMIUser(Long index, String guid, Integer isActive, Double balance, String picture,
                             Integer age, String eyeColor, String name_user, String gender, String conpany, String email, String phone,
                             String address, String about, String registered, Double latitude, Double longitude, String greeting,
                             String favoriteFruit, Friend[] friends, Tag[] tags) throws ClassNotFoundException, SQLException {
        User user = new User();
        user.setIndex(index.toString());
        user.setGuid(guid);
        if (isActive == 0) {
            user.setActive(false);
        } else {
            user.setActive(true);
        }
        user.setBalance(balance);
        user.setPicture(picture);
        user.setAge(age);
        user.setEyeColor(eyeColor);
        user.setName(name_user);
        user.setGender(gender);
        user.setCompany(conpany);
        user.setEmail(email);
        user.setPhone(phone);
        user.setAddress(address);
        user.setAbout(about);
        user.setRegistered(registered);
        user.setLatitude(latitude);
        user.setLongitude(longitude);
        user.setGreeting(greeting);
        user.setFavoriteFruit(favoriteFruit);

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
            ps.setDouble(1, balance);
            ps.setInt(2, age);
            ps.setString(3, name_user);
            ps.setString(4, gender);
            ps.setString(5, conpany);
            ps.setString(6, email);
            ps.setString(7, address);

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

    public void viewListMIUser (Long id_user) throws ClassNotFoundException {
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
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

            Friend[] friends = new Friend[5];
            for (int i = 0; i < 5; i++) {
                Friend friend = new Friend();
                friends[i] = friend;
            }

            Tag[] tags = new Tag[5];
            for (int i = 0; i < 5; i++) {
                Tag tag = new Tag();
                tags[i] = tag;
            }

            while (rs.next()) {
                User user = new User();
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
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("Hello");
        Locale.setDefault(Locale.ENGLISH);
        Class.forName("oracle.jdbc.driver.OracleDriver");
        try {
            Connection conn = DriverManager
                    .getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
            Statement stmt = conn
                    .createStatement();
//            ResultSet rs = stmt
//                    .executeQuery("SELECT ID_USER, INDEX_USER, GUID, ISACTIVE, BALANCE," +
//                            "PICTURE, AGE, EYECOLOR, NAME_USER, GENDER, COMPANY,EMAIL," +
//                            "PHONE, ADDRESS , ABOUT, REGISTERED, LATITUDE, LONGITUDE," +
//                            "GREETING, FAVORITEFRUIT" +
//                            "FROM MI_USER;");

            Friend[] friends = new Friend[5];
            for (int i = 0; i < 5; i++) {
                Friend friend = new Friend();
                friends[i] = friend;
            }

            Tag[] tags = new Tag[5];
            for (int i = 0; i < 5; i++) {
                Tag tag = new Tag();
                tags[i] = tag;
            }

            RunMain runMain = new RunMain();

            runMain.addMIUser(150L, "testets", 0, 55.55, "Testtest",
                    35, "red_red", "Filipp", "Male", "Orlean",
                    "ttt@ttt.ru", "int int", "Chelusk", "beatBox rocket",
                    "trans", 44.66, 33.33, "Testtest",
                    "banana", friends, tags);

            UserStorage userStorage = new UserStorage();

            userStorage.saveUsers();


            User user = new User();
            user.setIndex("123123");
            user.setGuid("t123123");
            user.setActive(false);
            user.setActive(true);
            user.setBalance(50.0);
            user.setPicture("C:Test\test");
            user.setAge(18);
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

            Friend friend1 = new Friend();
            friend1.setName("Mary");
            Friend friend2 = new Friend();
            friend2.setName("Oksana");
            ArrayList<Friend> girlFriends = new ArrayList<Friend>();
            girlFriends.add(friend1);
            girlFriends.add(friend2);
            user.setFriends(girlFriends);

            Tag tag1 = new Tag();
            tag1.setName("Eto Piter");
            Tag tag2 = new Tag();
            tag2.setName("Moscow");
            ArrayList<Tag> uTags = new ArrayList<Tag>();
            uTags.add(tag1);
            uTags.add(tag2);
            user.setTags(uTags);

            userStorage.addUser(user);
            userStorage.insertUser(user);



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}