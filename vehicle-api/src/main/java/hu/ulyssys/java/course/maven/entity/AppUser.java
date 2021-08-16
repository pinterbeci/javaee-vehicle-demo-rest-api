package hu.ulyssys.java.course.maven.entity;

import javax.persistence.*;
//: -tal mondom meg, hogy oda várok egy paramétert, oda jn a bindolandó változó
@NamedQuery(name = AppUser.FIND_BY_USERNAME, query = "select u from AppUser u where u.username=:username")
@Entity
@Table(name = "app_user")
public class AppUser extends AbstractEntity{

    public static final String FIND_BY_USERNAME="AppUser.findByUsername";

    @Column(name = "username", unique = true)
    private String username;

    @Column(name = "password_hash")
    private String passwordHash;

    //ha ENUM a type, akkor szükséges ez az annotáció,
    // mivel default-ba csak indexeket néz és nem az ENUM string-es érétékét ENUM.ORDINAL a default
    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private AppUserRole role;


    public AppUser() {
    }

    public AppUserRole getRole() {
        return role;
    }

    public void setRole(AppUserRole role) {
        this.role = role;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }
}
