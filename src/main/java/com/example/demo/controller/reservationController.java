package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.Locker;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import com.example.demo.service.LockerService;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {

    @Autowired
    private UserService userService;

    @Autowired
    private LockerService lockerService;

    @Autowired
    private ReservationService reservationService;

    // 新增一個 reservation
    @PostMapping("/")
    public ResponseEntity<Reservation> createReservation(@RequestBody Reservation reservation) {
   
        Reservation createdReservation = reservationService.createReservation(reservation);

        return new ResponseEntity<Reservation>(createdReservation, HttpStatus.CREATED);
    }

    // 獲取所有 reservations
    @GetMapping
    public List<Reservation> listAllReservation(@RequestParam(required = false, name = "Reservation_ID") Long Reservation_ID) {
        return reservationService.getAllReservations();
    }

    // 利用Reservation_ID 獲取單個 reservation
    @GetMapping("/{Reservation_ID}")
    public Optional<Reservation> getReservationByReservationID(@PathVariable(value = "Reservation_ID") Long reservation_ID) {
        return reservationService.getReservationByReservationID(reservation_ID);
    }

    // 更新一個 reservation
    @PutMapping("/{Reservation_ID}")
    public Reservation updateReservation(@PathVariable(value = "Reservation_ID") Long reservation_ID,
                                     @RequestBody Reservation reservationDetails) {
    Optional<Reservation> existingReservation = reservationService.getReservationByReservationID(reservation_ID);
    
    if (existingReservation.isPresent()) {
        Reservation existingReservationObj = existingReservation.get();
        
        existingReservationObj.setUserID(reservationDetails.getUserID());
        existingReservationObj.setLockerID(reservationDetails.getLockerID());
        existingReservationObj.setDepositTimestamp(reservationDetails.getDepositTimestamp());
        existingReservationObj.setPickUpTimestamp(reservationDetails.getPickUpTimestamp());
        existingReservationObj.setTotalRentalTime(reservationDetails.getTotalRentalTime());
        existingReservationObj.setAmount(reservationDetails.getAmount());
        
        return reservationService.save(existingReservationObj);
    } else {
        // Handle case when reservation is not found
        throw new NullPointerException("Reservation with ID " + reservation_ID + " not found");
    }
}


    // 利用Reservation_ID 刪除一個 reservation
    @DeleteMapping("/{Reservation_ID}")
    public void deleteReservation(@PathVariable(value = "Reservation_ID") Long reservation_ID) {
        reservationService.deleteReservationByReservationID(reservation_ID);
    }
}
