package com.example.demo.repository;

import java.util.List;
import org.springframework.stereotype.Repository;
import com.example.demo.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
// import com.example.demo.model.User;
// import com.example.demo.model.Reservation;

import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByUser_Id(Long userId);
    Optional<Reservation> findByReservation_Id(Long reservationId);
}
