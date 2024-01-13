package com.example.usersapps.entityes;



import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    public Rol( String name) {

        this.name = name;
    }

    public Rol() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rol rol = (Rol) o;
        return Objects.equals(id, rol.id) && Objects.equals(name, rol.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    // Getters and setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
