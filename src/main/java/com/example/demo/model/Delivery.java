package com.example.demo.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "Delivery")
public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Locker_ID")
    private Long Locker_ID;

    @Column(name = "Delivery_ID", nullable = false, length = 255)
    private Long Delivery_ID;

    @OneToMany(mappedBy = "delivery")
    private List<Pick_Up> pickup;

    public Delivery(){
    }

    public Delivery(Long Locker_ID, Long Delivery_ID){
        this.Locker_ID = Locker_ID;
        this.Delivery_ID = Delivery_ID;
    }

    public long getLockerID(){
        return Locker_ID;
    }

    public void setLockerID(Long Locker_ID){
        this.Locker_ID = Locker_ID;
    }

    public long getDeliveryID(){
        return Delivery_ID;
    }

    public void setDeliveryID(long Delivery_ID){
        this.Delivery_ID = Delivery_ID;
    }
}