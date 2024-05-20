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

    @Column(name = "Size", nullable = false, length = 255)
    private int Size;

    @Column(name = "Price", nullable = false, length = 255)
    private int Price;

    @Column(name = "Status_Used", nullable = true, length = 255)
    private Boolean Status_Used;

    @Column(name = "Status_Not_Used", nullable = true, length = 255)
    private Boolean Status_Not_Used;

    @Column(name = "Status_Reserved_But_Not_Used", nullable = true, length = 255)
    private Boolean Status_Reserved_But_Not_Used;

    @Column(name = "Reservation_ID", nullable = false)
    private Long Reservation_ID;

    @Column(name = "Deposit_Timestamp", nullable = false)
    private Calendar Deposit_Timestamp;

    @Column(name = "PickUp_Timestamp", nullable = false)
    private Calendar PickUp_Timestamp;


    @ManyToOne
    @MapsId("LockerArea_ID")
    @JoinColumns({
        @JoinColumn(name = "Station_ID", referencedColumnName = "Station_ID"),
        @JoinColumn(name = "LockerArea_ID", referencedColumnName = "LockerArea_ID")
    })
    private LockerArea LockerArea;

    public Locker(){
    }

    public Locker(Locker_ID IDB, LockerArea LockerArea, int Size, int Price, Boolean Status_Used, Boolean Status_Not_Used, Boolean Status_Reserved_But_Not_Used, Long Reservation_ID, Calendar Deposit_Timestamp, Calendar PickUp_Timestamp){
        this.IDB = IDB;
        this.LockerArea = LockerArea;
        this.Size = Size;
        this.Price = Price;
        this.Status_Used = Status_Used;
        this.Status_Not_Used = Status_Not_Used;
        this.Status_Reserved_But_Not_Used = Status_Reserved_But_Not_Used;
        this.Reservation_ID = Reservation_ID;
        this.Deposit_Timestamp = Deposit_Timestamp;
        this.PickUp_Timestamp = PickUp_Timestamp;
    }

    public Locker_ID getIDB(){
        return IDB;
    }

    public void setIDB(Locker_ID IDB){
        this.IDB = IDB;
    }

    public LockerArea getLockerArea() {
        return LockerArea;
    }

    public void setLockerArea(LockerArea LockerArea) {
        this.LockerArea = LockerArea;
    }

    public int getSize(){
        return Size;
    }

    public void setSize(int Size){
        this.Size = Size;
    }

    public int getPrice(){
        return Price;
    }

    public void setPrice(int Price){
        this.Price = Price;
    }

    public Boolean getStatusUsed(){
        return Status_Used;
    }

    public void setStatusUsed(Boolean Status_Used){
        this.Status_Used = Status_Used;
    }

    public Boolean getStatusNotUsed(){
        return Status_Not_Used;
    }

    public void setStatusNotUsed(Boolean Status_Not_Used){
        this.Status_Not_Used = Status_Not_Used;
    }

    public Boolean getStatusReservedButNotUsed(){
        return Status_Reserved_But_Not_Used;
    }

    public void setStatusReservedButNotUsed(Boolean Status_Reserved_But_Not_Used){
        this.Status_Reserved_But_Not_Used = Status_Reserved_But_Not_Used;
    }

    public Calendar getDepositTimestamp(){
        return Deposit_Timestamp;
    }

    public void setDepositTimestamp(Calendar Deposit_Timestamp){
        this.Deposit_Timestamp = Deposit_Timestamp;
    }

    public Calendar getPickUpTimestamp(){
        return PickUp_Timestamp;
    }

    public void setPickUpTimestamp(Calendar PickUp_Timestamp){
        this.PickUp_Timestamp = PickUp_Timestamp;
    }

    @Transient
    public Duration getTotalRentalTime() {
        if (PickUp_Timestamp != null && Deposit_Timestamp != null) {
            Instant depositInstant = Deposit_Timestamp.toInstant();
            Instant pickupInstant = PickUp_Timestamp.toInstant();
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