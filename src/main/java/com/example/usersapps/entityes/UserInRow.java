package com.example.usersapps.entityes;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "user_in_row")
public class UserInRow {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Rol role; // Renombrado para claridad

    public UserInRow() {
    }

    public UserInRow(Users users, Rol role) {
        this.users = users;
        this.role = role;
    }

    // Getters, setters, equals y hashCode

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    public Rol getRole() { // Método getter actualizado
        return role;
    }

    public void setRole(Rol role) { // Método setter actualizado
        this.role = role;
    }

    // equals y hashCode

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserInRow userInRow = (UserInRow) o;
        return Objects.equals(id, userInRow.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
