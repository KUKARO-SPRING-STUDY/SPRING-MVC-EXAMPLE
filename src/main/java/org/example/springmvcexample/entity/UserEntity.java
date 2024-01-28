package org.example.springmvcexample.entity;


import jakarta.persistence.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity
@Table(name="groom_user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;
    @Column(name = "email")
    private String email;
    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;


    public UserEntity(String email, String password,String name) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserEntity(long id, String email,  String password,String name) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserEntity() {

    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public long getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity encodePassword(PasswordEncoder passwordEncoder) {
        this.password = passwordEncoder.encode(this.password);
        return this;
    }
}