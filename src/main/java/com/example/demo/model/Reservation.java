package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Calendar;
import java.time.Duration;
import java.time.Instant;

@Entity
@Table(name = "reservation")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "reservation_id")
    private int reservationID;

    @Column(name = "deposit_timestamp", nullable = false)
    private Calendar depositTimestamp;

    @Column(name = "pick_up_timestamp", nullable = false)
    private Calendar pickUpTimestamp;

    @Column(name = "deposit_or_delivery", nullable = false)
    private Boolean depositOrDelivery;

    // Be_Delivered_To
    @Column(name = "delivery_id", nullable = true)
    private int deliveryID;

    @Column(name = "status_picked_up", nullable = true)
    private Boolean statusPickedUp;

    @Column(name = "status_waiting", nullable = true)
    private Boolean statusWaiting;

    @ManyToOne
    @MapsId("lockerID")
    @JoinColumns({
        @JoinColumn(name = "locker_id"/*sql*/, referencedColumnName = "lockerID"/*java*/),
        @JoinColumn(name = "locker_area_id"/*sql*/, referencedColumnName = "locker_areaid"/*java*/)
    })
    private Locker locker; //

    @ManyToOne
    @MapsId("userID"/*java*/)
    @JoinColumn(name = "user_id"/*sql*/)
    private User users;

    // @ManyToOne
    // @MapsId("hotelID"/*java*/)
    // @JoinColumn(name = "hotel_id"/*sql*/)
    // private Hotel hotels;

    public Reservation() {
    }

    public Reservation(int reservationID, Calendar depositTimestamp, Calendar pickUpTimestamp, Boolean depositOrDelivery, int deliveryID, Boolean statusPickedUp, Boolean statusWaiting) {
        this.reservationID = reservationID;
        this.depositTimestamp = depositTimestamp;
        this.pickUpTimestamp = pickUpTimestamp;
        this.depositOrDelivery = depositOrDelivery;
        this.deliveryID = deliveryID;
        this.statusPickedUp = statusPickedUp;
        this.statusWaiting = statusWaiting;
    }

    public int getReservationID() {
        return reservationID;
    }

    public void setReservationID(int reservationID) {
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

    public Boolean getDepositOrDelivery(){
        return depositOrDelivery;
    }

    public void setDepositOrDelivery(Boolean depositOrDelivery){
        this.depositOrDelivery = depositOrDelivery;
    }

    public int getDeliveryID(){
        return deliveryID;
    }

    public void setDeliveryID(int deliveryID){
        this.deliveryID = deliveryID;
    }

    public Boolean getStatusPickedUp(){
        return statusPickedUp;
    }

    public void setStatusPicked(Boolean statusPickedUp){
        this.statusPickedUp = statusPickedUp;
    }

    public Boolean getStatusWaiting(){
        return statusWaiting;
    }

    public void setStatusWaiting(Boolean statusWaiting){
        this.statusWaiting = statusWaiting;
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