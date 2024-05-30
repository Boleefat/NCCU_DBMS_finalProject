package com.example.demo.repository;
import com.example.demo.model.Locker;
import com.example.demo.model.Locker_ID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Locker_ID> {
<<<<<<< HEAD
    Optional<Locker> findByLockerID(Locker_ID lockerId);
=======
    Optional<Locker> findByLockerID(Locker lockerId);
>>>>>>> 9546621260f6a59f998ef4fbffcb1fc09739039a
}