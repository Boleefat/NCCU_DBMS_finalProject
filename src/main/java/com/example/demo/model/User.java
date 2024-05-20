package com.example.demo.model;

import java.util.Set;
import jakarta.persistence.*;

// import org.springframework.security.access.method.P;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_ID;

    @Column(nullable = false, unique = true, length = 255)
    private String Email;

    @Column(nullable = false, length = 64)
    private String Password;

    @ManyToOne
    @MapsId("Hotel_ID")
    @JoinColumn(name = "Hotel_ID")
    private Hotel Hotel;

    @OneToMany(mappedBy = "Locker")
    private Set<Locker> Lockers;

    // Constructors
    public User() {
    }

    public User(Long User_ID, String Email, String Password) {
        this.User_ID = User_ID;
        this.Email = Email;
        this.Password = Password;
    }

    // Getters and Setters
    public Long getUserID() {
        return User_ID;
    }

    public void setUserID(Long User_ID) {
        this.User_ID = User_ID;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }
}
