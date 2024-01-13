package com.example.usersapps.entityes;

import jakarta.persistence.*;


import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "Profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "firstname_name")
    private String firstname;
    @Column(name = "lastname_name")
    private String lastname;

    @Column(name = "birthday_name")
    private Date birthday;
    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
    }

    @OneToOne
    @JoinColumn(name = "user_id",referencedColumnName = "id")
    private Users user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(id, profile.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
