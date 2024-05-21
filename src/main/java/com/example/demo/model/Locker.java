package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Set;
import java.time.Duration;
import java.math.BigDecimal;

@Entity
@Table(name = "locker")
public class Locker {
    @EmbeddedId
    private Locker_ID lockerId;

    @Column(name = "size", nullable = false, length = 255)
    private int size;

    @Column(name = "price", nullable = false, length = 255)
    private int price;

    @Column(name = "locker_password", nullable = false)
    private String lockerPassword;

    @Column(name = "status_used", nullable = false)
    private Boolean statusUsed;

    @Column(name = "status_not_used", nullable = false)
    private Boolean statusNotUsed;

    @Column(name = "status_reserved_but_not_used", nullable = false)
    private Boolean statusReservedButNotUsed;

    @ManyToOne
    @MapsId("lockerAreaID")
    @JoinColumns({
        @JoinColumn(name = "station_id", referencedColumnName = "stationID"),
        @JoinColumn(name = "locker_area_id", referencedColumnName = "lockerAreaID")
    })
    private LockerArea lockerArea; //

    @OneToMany(mappedBy = "locker")
    private Set<Reservation> reservations;

    public Locker(){
    }

    public Locker(Locker_ID IDB, LockerArea lockerArea, int size, int price, String lockerPassword,Boolean statusUsed, Boolean statusNotUsed, Boolean statusReservedButNotUsed){
        this.IDB = IDB;
        this.lockerArea = lockerArea;
        this.size = size;
        this.price = price;
        this.lockerPassword = lockerPassword;
        this.statusUsed = statusUsed;
        this.statusNotUsed = statusNotUsed;
        this.statusReservedButNotUsed = statusReservedButNotUsed;
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

    public String getLockerPassword(){
        return lockerPassword;
    }

    public void setLockerPassword(String lockerPassword){
        this.lockerPassword = lockerPassword;
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

    @Transient
    public BigDecimal getTotalPrice() {
        if (getPrice() > 0 && getTotalRentalTime().toHours() > 0) {
            return BigDecimal.valueOf(getPrice()).multiply(BigDecimal.valueOf(getTotalRentalTime().toHours()));
        } else {
            return BigDecimal.ZERO;
        }
    }

    @Transient
    public Duration getTotalRentalTime() {
        if (reservations != null && !reservations.isEmpty()) {
            Reservation reservation = reservations.iterator().next();
            return reservation.getTotalRentalTime();
        } else {
            return Duration.ZERO;
        }
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        // This setter might not be necessary if totalPrice is always calculated dynamically.
    }
}