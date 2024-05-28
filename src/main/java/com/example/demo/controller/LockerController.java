package com.example.demo.controller;

import com.example.demo.model.Locker;
import com.example.demo.model.Reservation;
import com.example.demo.service.LockerService;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public List<Locker> listAllLocker(@RequestParam(required = false, name = "locker_id") int LockerID) {
            return lockerService.getAllLocker();
    }

    // 利用Locker_ID獲取單個locker   lockerService.getLockerByLockerID(LockerID)
    @GetMapping("/{locker_id}")
    public Optional<Locker> getLockerByLockerID(@PathVariable("locker_id") int LockerID) {
        return lockerService.getLockerByLockerID(LockerID);
    }

    // 更新一個 locker   lockerService.updateLocker(LockerID, locker)
    @PutMapping("/{locker_id}")
    public Locker updateLocker(@PathVariable("locker_id") int LockerID, @RequestBody Locker locker) {
        return lockerService.updateLocker(LockerID, locker); 

    }

    // 利用Locker_ID刪除一個 locker   lockerService.deleteLockerByLockerID(LockerID)
    @DeleteMapping("/{locker_id}")
    public void deleteLocker(@PathVariable("locker_id") int LockerID) {
        lockerService.deleteLockerByLockerID(LockerID);
    }
}
