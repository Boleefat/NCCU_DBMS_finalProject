package com.example.demo.controller;

import com.example.demo.model.Locker;
import com.example.demo.model.Reservation;
import com.example.demo.service.LockerService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/locker")
public class LockerController {

    @Autowired
    private LockerService lockerService;

    // 新增一個 locker   lockerService.createLocker(locker)
    @PostMapping("/")
    public ResponseEntity<Locker> createLocker(@RequestBody Locker locker) {
        Locker createdLocker = lockerService.createLocker(locker);
        return new ResponseEntity<Locker>(createdLocker, HttpStatus.CREATED);
    }

    // 獲取所有 lockers   lockerService.getAllLocker()
    @GetMapping
    public List<Locker> listAllLocker(@RequestParam(required = false, name = "Locker_ID") Long Locker_ID) {
            return lockerService.getAllLocker();
    }

    // 利用Locker_ID獲取單個locker   lockerService.getLockerByLockerID(Locker_ID)
    @GetMapping("/{Locker_ID}")
    public Optional<Locker> getLockerByLockerID(@PathVariable(value = "Locker_ID") Long Locker_ID) {
        return lockerService.getLockerByLockerID(Locker_ID);
    }

    // 更新一個 locker   lockerService.updateLocker(Locker_ID, locker)
    @PutMapping("/{Locker_ID}")
    public Locker updateLocker(@PathVariable("Locker_ID") Long Locker_ID, @RequestBody Locker locker) {
        return lockerService.updateLocker(Locker_ID, locker); 

    }

    // 利用Locker_ID刪除一個 locker   lockerService.deleteLockerByLockerID(Locker_ID)
    @DeleteMapping("/{Locker_ID}")
    public void deleteLocker(@PathVariable("Locker_ID") Long Locker_ID) {
        lockerService.deleteLockerByLockerID(Locker_ID);
    }
}
