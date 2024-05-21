package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Calendar;

// import org.springframework.security.access.method.P;

@Entity
@DiscriminatorValue("delivery")
public class Delivery extends Locker {

    @Column(name = "delivery_id", nullable = false)
    private Long deliveryID;

    @Column(name = "status_picked_up", nullable = false)
    private Boolean statusPickedUp;

    @Column(name = "status_waiting", nullable = false)
    private Boolean statusWaiting;

    @ManyToOne
    @MapsId("Hotel_ID")
    @JoinColumn(name = "Hotel_ID")
    private Hotel Hotel;

    public Delivery(){
    }

    public Delivery(Locker_ID IDB, LockerArea lockerArea, int size, int price, Boolean statusUsed, Boolean statusNotUsed, Boolean statusReservedButNotUsed, Long reservationID, Calendar depositTimestamp, Calendar pickUpTimestamp, Long deliveryID, Boolean statusPickedUp, Boolean statusWaiting){
        super(IDB, lockerArea, size, price, statusUsed, statusNotUsed, statusReservedButNotUsed, reservationID, depositTimestamp, pickUpTimestamp);
        this.deliveryID = deliveryID;
        this.statusPickedUp = statusPickedUp;
        this.statusWaiting = statusWaiting;
    }
    
    public Long getDeliveryID(){
        return deliveryID;
    }

    public void setDeliveryID(Long deliveryID){
        this.deliveryID = deliveryID;
    }

    public Boolean getStatusPickedUp(){
        return statusPickedUp;
    }

    public void setStatusPickedUp(Boolean statusPickedUp){
        this.statusPickedUp = statusPickedUp;
    }

    public Boolean getStatusWaiting(){
        return statusWaiting;
    }

    public void setStatusWaiting(Boolean statusWaiting){
        this.statusWaiting = statusWaiting;
    }
}