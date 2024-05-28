package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Locker;
import com.example.demo.model.Reservation;
import com.example.demo.service.ReservationService;
import com.example.demo.service.UserService;
import com.example.demo.service.LockerService;

@RestController // 讓RequestMapping生效
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
    public List<Reservation> listAllReservation(@RequestParam(required = false, name = "reservation_id") int Reservation_ID) {
        return reservationService.getAllReservations();
    }

    // 利用Reservation_ID 獲取單個 reservation
    @GetMapping("/{reservation_id}")
    public Optional<Reservation> getReservationByReservationID(@PathVariable("reservation_id") int Reservation_ID) {
        return reservationService.getReservationByReservationID(Reservation_ID);
    }

    // 更新一個 reservation
    @PutMapping("/{reservation_id}")
    public Reservation updateReservation(@PathVariable("reservation_id") int Reservation_ID, @RequestBody Reservation reservation) {
        return reservationService.updateReservation(Reservation_ID, reservation);
}

    // 利用Reservation_ID 刪除一個 reservation
    @DeleteMapping("/{reservation_id}")
    public void deleteReservation(@PathVariable("reservation_id") int Reservation_ID) {
        reservationService.deleteReservationByReservationID(Reservation_ID);
    }
}
