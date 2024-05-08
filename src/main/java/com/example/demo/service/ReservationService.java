package com.example.demo.service;

import com.example.demo.model.User;
import com.example.demo.model.Reservation;
import com.example.demo.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    //新建一個 reservation
    public Reservation createReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //獲取所有 reservation
       public List<Reservation> getReservations() {
        return reservationRepository.findAll();
    }

    //獲取單個reservation
    public Optional<Reservation> getReservaitonById(Long id) {
        return reservationRepository.findById(id);
    }

    //更新一個reservation
    public User updateReservation(Reservation reservation) {
        return reservationRepository.save(reservation);
    }

    //刪除一個reservation
    public void deleteUser(Long id) {
        reservationRepository.deleteById(id);
    }
}