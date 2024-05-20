package com.example.demo.controller;

import com.example.demo.model.Locker;
import com.example.demo.model.LockerArea;
import com.example.demo.service.LockerAreaService;

import jakarta.servlet.http.HttpServletRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/lockerArea")
public class lockerAreaController {

    @Autowired
    private LockerAreaService lockerService;

    // 新增一個 lockerArea
    @PostMapping("/")
    public ResponseEntity<LockerArea> createLockerArea(@RequestBody LockerArea lockerArea) {
        LockerArea savedLockerArea = lockerAreaService.createLockerArea(lockerArea);
        return new ResponseEntity<>(createdLockerArea, HttpStatus.CREATED);
    }

    // 獲取所有 lockerArea
    @GetMapping
    public List<LockerArea> listAllLockerArea(@RequestParam(required = false, name = "LockerArea_ID") Long LockerArea_ID) {
        return lockerAreaService.getAllLocker();
    }

    // 利用LockerArea_ID獲取單個 lockerArea
    @GetMapping("/{LockerArea_ID}")
    public Optional<LockerArea> getLockerAreaByLockerAreaID(@PathVariable(value = "LockerArea_ID") Long LockerArea_ID) {
        return lockerAreaService.getLockerAreaByLockerAreaID(LockerArea_ID);
    }

    // 更新一個 lockerArea
    @PutMapping("/{LockerArea_ID}")
    public LockerArea updateLockerArea(@PathVariable(value = "LockerArea_ID") Long LockerArea_ID,
                               @RequestBody LockerArea lockerAreaDetails) {
        Optional<LockerArea> existingLockerArea = lockerAreaService.getLockerAreaByLockerID(LockerArea_ID);
        if (existingLockerArea.isPresent()) {
            Locker existingLockerAreaObj = lockerArea.get();
            existingLockerArea.setLockerAreaLocation(lockerAreaDetails.getLockerAreaLocation());
            return lockerAreaService.save(existingLockerArea);
        } else {
            // Handle case when reservation is not found
            throw new NullPointerException("LockerArea with ID " + locker_ID + " not found");
        }
        
    }

    // 利用LockerArea_ID刪除一個 locker
    @DeleteMapping("/{LockerArea_ID}")
    public void deleteLockerArea(@PathVariable(value = "LockerArea_ID") Long LockerArea_ID) {
        lockerAreaService.deleteLockerAreaByID(LockerArea_ID);
    }


}
