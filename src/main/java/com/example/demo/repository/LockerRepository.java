package com.example.demo.repository;

import com.example.demo.model.Locker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LockerRepository extends JpaRepository<Locker, Long> {
    Optional<Locker> findByEmail(String email);
}

public interface LockerRepository extends JpaRepository<Locker, Long> {
    Optional<Locker> deleteById(String Locker_ID);
}