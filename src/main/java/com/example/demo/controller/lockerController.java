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
public class lockerController {

    @Autowired
    private LockerService lockerService;

    // 新增一個 locker   lockerService.createLocker(locker)
    @PostMapping("/")
    public ResponseEntity<Locker> createLocker(@RequestBody Locker locker) {
        Locker createLocker = lockerService.createLocker(locker);
        return new ResponseEntity<Locker>(createLocker, HttpStatus.CREATED);
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

    // 更新一個 locker
    @PutMapping("/{Locker_ID}")
    public Locker updateLocker(@PathVariable(value = "Locker_ID") Long Locker_ID,
                               @RequestBody Locker lockerDetails) {
        Optional<Locker> locker = lockerService.getLockerByLockerID(Locker_ID);
        
        if (existingLocker.isPresent()){
            Locker existingLockerObj = existingLocker.get();

            existingLockerObj.setSize(lockerDetails.getSize());
            existingLockerObj.setPrice(lockerDetails.getPrice());
            existingLockerObj.setStatusUsed(lockerDetails.getStatusUsed());
            existingLockerObj.setStatusNotUsed(lockerDetails.getStatusNotUsed());
            existingLockerObj.setStatusReservedButNotUsed(lockerDetails.getStatusReservedButNotUsed());
            
            return lockerService.save(existingLockerObj);
        } else {
            // Handle case when reservation is not found
            throw new NullPointerException("Locker with ID " + locker_ID + " not found");
        }

    }

    // 利用Locker_ID刪除一個 locker   lockerService.deleteLockerByLockerID(Locker_ID)
    @DeleteMapping("/{Locker_ID}")
    public void deleteLocker(@PathVariable(value = "Locker_ID") Long Locker_ID) {
        lockerService.deleteLockerByLockerID(Locker_ID);
    }
}
