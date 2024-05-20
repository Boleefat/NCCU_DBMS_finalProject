package com.example.demo.model;

import jakarta.persistence.*;
import java.util.Calendar;

// import org.springframework.security.access.method.P;

@Entity
@DiscriminatorValue("delivery")
public class Delivery extends Locker {

    @Column(name = "Delivery_ID", nullable = false)
    private Long Delivery_ID;

    @Column(name = "Status_Picked_Up", nullable = false)
    private Boolean Status_Picked_Up;

    @Column(name = "Status_Waiting", nullable = false)
    private Boolean Status_Waiting;

    @ManyToOne
    @MapsId("Hotel_ID")
    @JoinColumn(name = "Hotel_ID")
    private Hotel Hotel;

    public Delivery(){
    }

    public Delivery(Locker_ID IDB, LockerArea LockerArea, int Size, int Price, Boolean Status_Used, Boolean Status_Not_Used, Boolean Status_Reserved_But_Not_Used, Long Reservation_ID, Calendar Deposit_Timestamp, Calendar PickUp_Timestamp, Long Delivery_ID, Boolean Status_Picked_Up, Boolean Status_Waiting){
        super(IDB, LockerArea, Size, Price, Status_Used, Status_Not_Used, Status_Reserved_But_Not_Used, Reservation_ID, Deposit_Timestamp, PickUp_Timestamp);
        this.Delivery_ID = Delivery_ID;
        this.Status_Picked_Up = Status_Picked_Up;
        this.Status_Waiting = Status_Waiting;
    }
    
    public Long getDeliveryID(){
        return Delivery_ID;
    }

    public void setDeliveryID(Long Delivery_ID){
        this.Delivery_ID = Delivery_ID;
    }

    public Boolean getStatusPicked_Up(){
        return Status_Picked_Up;
    }

    public void setStatusPickedUp(Boolean Status_Picked_Up){
        this.Status_Picked_Up = Status_Picked_Up;
    }

    public Boolean getStatusWaiting(){
        return Status_Waiting;
    }

    public void setStatusWaiting(Boolean Status_Waiting){
        this.Status_Waiting = Status_Waiting;
    }
}