package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Home on 02.01.2017.
 */
public class Friend {

    public Friend (String name) {
        this.name = name;
    }
    private Long id_user;
    private String name;
    public void setId(Long id_user) {
        this.id_user = id_user;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id_user;
    }

    public String getName() {
        return name;
    }

    public void addFriend() {}

    public void postFriend(Connection conn, int userID) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement("INSERT INTO Friends (NAME, ID_USER) VALUES (?, ?)");
            ps.setString(1, getName());
            ps.setInt(2, userID);
            ps.executeUpdate();
            // INSERT INTO Friends VALUES (2, 'Vadim', 244)

        } finally {
            if (ps != null) {
                ps.close();
            }
        }
    }
}