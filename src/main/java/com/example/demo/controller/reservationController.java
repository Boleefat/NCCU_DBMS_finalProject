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
import com.example.demo.model.reservationService;
import com.example.demo.service.userService;
import com.example.demo.service.lockerService;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/reservation")
public class reservationController {

    @Autowired
    private UserService userService;

    @Autowired
    private LockerService lockerService;

    @Autowired
    private ReservationService reservationService;

    // 新增一個 reservation
    @PostMapping("/")
    public ResponseEntity<Reservation> createreservation(@RequestBody Reservation reservation) {
        Reservation savedReservation = reservationService.save(reservation);

        Reservation createdReservation = reservationService.createReservation(reservation);

        return new ResponseEntity<>(savedReservation, HttpStatus.CREATED);
    }

    // 獲取所有 reservations
    @GetMapping
    public Optional<Reservation> listAllReservation(@RequestParam(required = false, name = "Reservation_ID") Long Reservation_ID) {
        if (Reservation_ID != null) {
            return ReservationService.getReservationByReservationID(Reservation_ID);
        } else {
            return ReservationService.getAllReservation();
        }
    }

    // 利用Reservation_ID 獲取單個 reservation
    @GetMapping("/{Reservation_ID}")
    public Optional<reservation> getReservationByReservationID(@PathVariable(value = "Reservation_ID") Long Reservation_ID) {
        return reservationService.findReservationByReservationID(Reservation_ID);
    }

    // 更新一個 reservation
    @PutMapping("/{Reservation_ID}")
    public reservation updateReservation(@PathVariable(value = "Reservation_ID") Long Reservation_ID,
                               @RequestBody reservation reservationDetails) {
        Optional<reservation> reservation = reservationService.findByreservationID(reservation_ID);
        reservation existingreservation = reservation.get();
        existingreservation.setUserID(reservationDetails.getUserID());
        existingreservation.setLockerID(reservationDetails.getLockerID());
        existingreservation.setDepositTimestamp(reservationDetails.getDepositTimestamp());
        existingreservation.setPickUpTimestamp(reservationDetails.getPickUpTimestamp());
        existingreservation.setTotalRentalTime(reservationDetails.getTotalRentalTime());
        existingreservation.setAmount(reservationDetails.getAmount());
        return reservationService.save(existingreservation);
    }

    // 利用Reservation_ID 刪除一個 reservation
    @DeleteMapping("/{Reservation_ID}")
    public void deleteReservation(@PathVariable(value = "Reservation_ID") Long Reservation_ID) {
        reservationService.deleteReservationByReservationID(Reservation_ID);
    }
}
