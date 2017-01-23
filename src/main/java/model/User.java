package model;

import java.sql.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class User {

    private String id;
    private String index;
    private String guid;
    private Boolean isActive;
    private Double balance;
    private String picture;
    private Integer age;
    private String eyeColor;
    private String name;
    private String gender;
    private String company;
    private String email;
    private String phone;
    private String address;
    private String about;
    private String registered;
    private Double latitude;
    private Double longitude;
    private ArrayList<Tag> tags;
    private ArrayList<Friend> friends;
    private String greeting;
    private String favoriteFruit;

    public void setId(String id) {
        this.id = id;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEyeColor(String eyeColor) {
        this.eyeColor = eyeColor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public void setRegistered(String registered) {
        this.registered = registered;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public void setFriends(ArrayList<Friend> friends) {
        this.friends = friends;
    }

    public void setGreeting(String greeting) {
        this.greeting = greeting;
    }

    public void setFavoriteFruit(String favoriteFruit) {
        this.favoriteFruit = favoriteFruit;
    }


    public String getId() {

        return id;

    }

    public String getIndex() {

        return index;

    }

    public String getGuid() {

        return guid;

    }

    public Boolean getActive() {

        return isActive;

    }

//    public Double getDoubleBallans() {
//
//        Double doubleBallans = new Double(balance.substring(1).replace(",", ""));
//
//        return doubleBallans;
//
//    }

    public Double getDoubleBallans() {

        return balance;

    }

    public String getAbout() {

        return about;

    }

    public String getAddress() {

        return address;

    }

    public String getPhone() {

        return phone;

    }

    public String getEmail() {

        return email;

    }

    public String getCompany() {

        return company;

    }

    public String getGender() {

        return gender;

    }

    public String getName() {

        return name;

    }

    public String getEyeColor() {

        return eyeColor;

    }

    public Integer getAge() {

        return age;

    }

    public String getPicture() {

        return picture;

    }

    public Date getDateRegistered() {

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss XXX", Locale.ENGLISH);

        try {

            return df.parse(registered);

        } catch (ParseException e1) {

            e1.printStackTrace();

            return null;

        }

    }

    public Double getLatitude() {

        return latitude;

    }

    public Double getLongitude() {

        return longitude;

    }

    public ArrayList<Tag> getTags() {

        return tags;

    }

    public ArrayList<Friend> getFriends() {

        return friends;
    }

    public String getGreeting() {

        return greeting;
    }

    public String getFavoriteFruit() {

        return favoriteFruit;
    }

    public int postUser(Connection conn) throws SQLException {

        PreparedStatement ps = null;

        int userID = 0;

        try {
            ps = conn
                    .prepareStatement("INSERT INTO MI_USER (BALANCE, AGE, NAME_USER, GENDER, COMPANY, EMAIL, ADDRESS)\n" +
                            " VALUES (?, ?, ?, ?, ?, ?, ?)", new String[]{"ID_USER"} /*Statement.RETURN_GENERATED_KEYS*/);

            ps.setDouble(1, getDoubleBallans());
            ps.setInt(2, getAge());
            ps.setString(3, getName());
            ps.setString(4, getGender());
            ps.setString(5, getCompany());
            ps.setString(6, getEmail());
            ps.setString(7, getAddress());

            ps.executeUpdate();

            ResultSet resultSet = ps.getGeneratedKeys();


            if (resultSet != null) {
                resultSet.next();
                userID = resultSet.getInt(1);
                System.out.println(userID);
            }
        } finally {
            if (ps != null) {
                ps.close();
            }
        }
        return userID;
    }
}