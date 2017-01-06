package model;

/**
 * Created by Home on 02.01.2017.
 */
public class Friend {
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
}