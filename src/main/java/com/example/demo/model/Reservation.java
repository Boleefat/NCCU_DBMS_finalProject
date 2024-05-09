package com.example.demo.model;

import java.sql.Timestamp;
import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Reservation_ID")
    private Long Reservation_ID;

    @Column(name = "User_ID", nullable = false, length = 255)
    private Long User_ID;

    @Column(name = "Locker_ID", nullable = false, length = 255)
    private Long Locker_ID;

    @Column(name = "Deposit_Timestamp", nullable = false, length = 255)
    private Timestamp Deposit_Timestamp;;

    @Column(name = "PickUp_Timestamp", nullable = false, length = 255)
    private Timestamp PickUp_Timestamp;

    @Column(name = "Total_Rental_Time", nullable = false, length = 255)
    private int Total_Rental_Time;

    @Column(name = "Amount", nullable = false, length = 255)
    private int Amount;
    
    @ManyToOne
    @JoinColumn(name = "Locker_ID", nullable = false)
    private Locker Locker_ID;

    @ManyToOne
    @JoinColumn(name = "User_ID", nullable = false)
    private User User_ID;

    public Reservation(){
    }

    public Reservation(Long reservation_id, Long user_id, String name, String category, String description, double price, int quantity, String image,
            User user) {
        this.Reservation_ID = reservation_id;
        this.User_ID = user_id;
        this.category = category;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.image = image;
        this.user = user;
    }

    public possessionAreaLockerKey getIDC() {
        return IDC;
    }

    public void setIDC(possessionAreaLockerKey IDC) {
        this.IDC = IDC;
    }

    public LockerArea getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(LockerArea LockerArea_ID){
        this.LockerArea_ID = LockerArea_ID;
    }

    public Locker getLockerID() {
        return Locker_ID;
    }

    public void setLockerID(Locker Locker_ID){
        this.Locker_ID = Locker_ID;
    }
}

@Embeddable
class possessionAreaLockerKey implements Serializable {
    @Column(name = "LockerArea_ID")
    private Long LockerArea_ID;

    @Column(name = "Locker_ID")
    private Long Locker_ID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        possessionAreaLockerKey that = (possessionAreaLockerKey) o;
        return Objects.equals(LockerArea_ID, that.LockerArea_ID) &&
               Objects.equals(Locker_ID, that.Locker_ID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(LockerArea_ID, Locker_ID);
    }

    // Getters and setters
    public Long getLockerAreaID() {
        return LockerArea_ID;
    }

    public void setLockerAreaID(Long LockerArea_ID) {
        this.LockerArea_ID = LockerArea_ID;
    }

    public Long getLockerID() {
        return Locker_ID;
    }

    public void setLockerID(Long Locker_ID) {
        this.Locker_ID = Locker_ID;
    }
}