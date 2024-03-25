package com.example.PP_3_1_2_CRUD_SpringBoot.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.util.Objects;

@Entity
@Table(name="users")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false, length = 20, unique = false)
    @NotBlank(message = "Name is required")
    private String name;

    @Column(name = "last_name", nullable = false, length = 20, unique = false)
    @NotBlank(message = "Last name is required")
    private String lastName;

    @Column(name = "email", nullable = false, length = 20)
    @NotBlank(message = "Email is required")
    @Email(message = "Email must be a valid email address")
    private String email;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(getId(), user.getId())
                && Objects.equals(getName(), user.getName())
                && Objects.equals(getLastName(), user.getLastName())
                && Objects.equals(getEmail(), user.getEmail());
    }

    // hashCode method
    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getLastName(), getEmail());
    }

    public User() {}


    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
