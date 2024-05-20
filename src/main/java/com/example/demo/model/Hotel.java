package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;
import java.time.LocalTime;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Hotel_ID")
    private Long Hotel_ID;

    @Column(name = "Hotel_Name", nullable = false, length = 255)
    private String Hotel_Name;

    @Column(name = "Latest_PickUp_Time", nullable = false)
    private LocalTime Latest_PickUp_Time;

    @Column(name = "Booking_ID", nullable = false)
    private Long Booking_ID;

    @OneToMany(mappedBy = "Hotel")
    private Set<Delivery> Deliveries;

    @OneToMany(mappedBy = "Hotel")
    private Set<User> Users;

    public Hotel(){
    }

    public Hotel(Long Hotel_ID, String Hotel_Name, LocalTime Latest_PickUp_Time, Long Booking_ID){
        this.Hotel_ID = Hotel_ID;
        this.Hotel_Name = Hotel_Name;
        this.Latest_PickUp_Time = Latest_PickUp_Time;
        this.Booking_ID = Booking_ID;
    }

    public Long getHotelID(){
        return Hotel_ID;
    }

    public void setHotelID(Long Hotel_ID){
        this.Hotel_ID = Hotel_ID;
    }

    public String getHotelName(){
        return Hotel_Name;
    }

    public void setHotelName(String Hotel_Name){
        this.Hotel_Name = Hotel_Name;
    }

    public LocalTime getLatestPickUpTime(){
        return Latest_PickUp_Time;
    }

    public void setLatestPickUpTime(LocalTime Latest_PickUp_Time){
        this.Latest_PickUp_Time = Latest_PickUp_Time;
    }

    public Long getBookingID(){
        return Booking_ID;
    }

    public void setBookingID(Long Booking_ID){
        this.Booking_ID = Booking_ID;
    }


    public Set<Delivery> getDeliveries() {
        return Deliveries;
    }

    public void setDelivery(Set<Delivery> Deliveries) {
        this.Deliveries = Deliveries;
    }

    public Set<User> getUsers() {
        return Users;
    }

    public void setUsers(Set<User> Users) {
        this.Users = Users;
    }
}