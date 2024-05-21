package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;
import java.time.LocalTime;

@Entity
@Table(name = "hotel")
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "hotel_id")
    private Long hotelID;

    @Column(name = "hotel_name", nullable = false, length = 255)
    private String hotelName;

    @Column(name = "latest_pick_up_time", nullable = false)
    private LocalTime latestPickUpTime;

    @Column(name = "bookingID", nullable = false)
    private Long bookingID;

    @OneToMany(mappedBy = "Hotel")
    private Set<Delivery> Deliveries;

    @OneToMany(mappedBy = "Hotel")
    private Set<User> Users;

    public Hotel(){
    }

    public Hotel(Long hotelID, String hotelName, LocalTime latestPickUpTime, Long bookingID){
        this.hotelID = hotelID;
        this.hotelName = hotelName;
        this.latestPickUpTime = latestPickUpTime;
        this.bookingID = bookingID;
    }

    public Long getHotelID(){
        return hotelID;
    }

    public void setHotelID(Long hotelID){
        this.hotelID = hotelID;
    }

    public String getHotelName(){
        return hotelName;
    }

    public void setHotelName(String hotelName){
        this.hotelName = hotelName;
    }

    public LocalTime getLatestPickUpTime(){
        return latestPickUpTime;
    }

    public void setLatestPickUpTime(LocalTime latestPickUpTime){
        this.latestPickUpTime = latestPickUpTime;
    }

    public Long getBookingID(){
        return bookingID;
    }

    public void setBookingID(Long bookingID){
        this.bookingID = bookingID;
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