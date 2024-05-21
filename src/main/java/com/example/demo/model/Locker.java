


package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Calendar;
import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "locker")
public class Locker {
    @EmbeddedId
    private Locker_ID IDB;

    @Column(name = "size", nullable = false, length = 255)
    private int size;

    @Column(name = "price", nullable = false, length = 255)
    private int price;

    @Column(name = "status_used", nullable = false)
    private Boolean statusUsed;

    @Column(name = "status_not_used", nullable = false)
    private Boolean statusNotUsed;

    @Column(name = "status_reserved_but_not_used", nullable = false)
    private Boolean statusReservedButNotUsed;

    @Column(name = "reservation_id", nullable = false)
    private Long reservationID;

    @Column(name = "deposit_timestamp", nullable = false)
    private Calendar depositTimestamp;

    @Column(name = "pick_up_timestamp", nullable = false)
    private Calendar pickUpTimestamp;

    @ManyToOne
    @MapsId("lockerAreaID")
    @JoinColumns({
        @JoinColumn(name = "station_id", referencedColumnName = "station_id"),
        @JoinColumn(name = "locker_area_id", referencedColumnName = "locker_areaid")
    })
    private LockerArea lockerArea;

    @ManyToOne
    @MapsId("userID")
    @JoinColumn(name = "user_id")
    private User user;

    public Locker(){
    }

    public Locker(Locker_ID IDB, LockerArea lockerArea, int size, int price, Boolean statusUsed, Boolean statusNotUsed, Boolean statusReservedButNotUsed, Long reservationID, Calendar depositTimestamp, Calendar pickUpTimestamp){
        this.IDB = IDB;
        this.lockerArea = lockerArea;
        this.size = size;
        this.price = price;
        this.statusUsed = statusUsed;
        this.statusNotUsed = statusNotUsed;
        this.statusReservedButNotUsed = statusReservedButNotUsed;
        this.reservationID = reservationID;
        this.depositTimestamp = depositTimestamp;
        this.pickUpTimestamp = pickUpTimestamp;
    }

    public Locker_ID getIDB(){
        return IDB;
    }

    public void setIDB(Locker_ID IDB){
        this.IDB = IDB;
    }

    public LockerArea getLockerArea() {
        return lockerArea;
    }

    public void setLockerArea(LockerArea lockerArea) {
        this.lockerArea = lockerArea;
    }

    public int getSize(){
        return size;
    }

    public void setSize(int size){
        this.size = size;
    }

    public int getPrice(){
        return price;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public Boolean getStatusUsed(){
        return statusUsed;
    }

    public void setStatusUsed(Boolean statusUsed){
        this.statusUsed = statusUsed;
    }

    public Boolean getStatusNotUsed(){
        return statusNotUsed;
    }

    public void setStatusNotUsed(Boolean statusNotUsed){
        this.statusNotUsed = statusNotUsed;
    }

    public Boolean getStatusReservedButNotUsed(){
        return statusReservedButNotUsed;
    }

    public void setStatusReservedButNotUsed(Boolean statusReservedButNotUsed){
        this.statusReservedButNotUsed = statusReservedButNotUsed;
    }

    public Long getReservationID(){
        return reservationID;
    }

    public void setReservationID(Long reservationID){
        this.reservationID = reservationID;
    }

    public Calendar getDepositTimestamp(){
        return depositTimestamp;
    }

    public void setDepositTimestamp(Calendar depositTimestamp){
        this.depositTimestamp = depositTimestamp;
    }

    public Calendar getPickUpTimestamp(){
        return pickUpTimestamp;
    }

    public void setPickUpTimestamp(Calendar pickUpTimestamp){
        this.pickUpTimestamp = pickUpTimestamp;
    }

    @Transient
    public Duration getTotalRentalTime() {
        if (pickUpTimestamp != null && depositTimestamp != null) {
            Instant depositInstant = depositTimestamp.toInstant();
            Instant pickupInstant = pickUpTimestamp.toInstant();
            return Duration.between(depositInstant, pickupInstant);
        } else {
            return Duration.ZERO;
        }
    }

    @Transient
    public Long getTotalRentalHours() {
        return getTotalRentalTime().toHours();
    }

    @Transient
    public Long getTotalRentalMinutes() {
        return getTotalRentalTime().toMinutes();
    }

    @Transient
    public Long getTotalRentalSeconds() {
        return getTotalRentalTime().getSeconds();
    }
}