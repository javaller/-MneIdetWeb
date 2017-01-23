package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by Home on 03.01.2017.
 */
public class Tag {
    private Long userId;
    private String name;

    public Long getUserId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Tag(String name) {
        this.name = name;
    }

    public  void postTag(Connection conn, int userId) throws SQLException {
        PreparedStatement ps = null;
        try {
            ps = conn
                    .prepareStatement("INSERT INTO USER_TAG (TAG_NAME, ID_USER) VALUES (?, ?)");
            ps.setString(1, getName());
            ps.setInt(2, userId);
            ps.executeUpdate();
        } finally {
            if (ps != null) {
                ps.close();
            }
        }


    }
}