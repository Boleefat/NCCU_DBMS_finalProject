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
public class LockerAreaController {

    @Autowired
    private LockerAreaService lockerService;

    // 新增一個 lockerArea   lockerAreaService.createLockerArea(lockerArea)
    @PostMapping("/")
    public ResponseEntity<LockerArea> createLockerArea(@RequestBody LockerArea lockerArea) {
        LockerArea createdLockerArea = lockerAreaService.createLockerArea(lockerArea);
        return new ResponseEntity<LockerArea>(createdLockerArea, HttpStatus.CREATED);
    }

    // 獲取所有 lockerArea   lockerAreaService.getAllLockerArea()
    @GetMapping
    public List<LockerArea> listAllLockerArea(@RequestParam(required = false, name = "LockerArea_ID") Long LockerArea_ID) {
        return lockerAreaService.getAllLockerArea();
    }

    // 利用LockerArea_ID獲取單個 lockerArea   lockerAreaService.getLockerAreaByLockerAreaID(LockerArea_ID)
    @GetMapping("/{LockerArea_ID}")
    public Optional<LockerArea> getLockerAreaByLockerAreaID(@PathVariable(value = "LockerArea_ID") Long LockerArea_ID) {
        return lockerAreaService.getLockerAreaByLockerAreaID(LockerArea_ID);
    }

    // 更新一個 lockerArea
    @PutMapping("/{LockerArea_ID}")   lockerAreaService.updateLockerArea(LockerArea_ID, LockerArea)
    public LockerArea updateLockerArea(@PathVariable("LockerArea_ID") Long LockerArea_ID, @RequestBody LockerArea lockerArea) {
        return lockerAreaService.updateLockerArea(LockerArea_ID, lockerArea);
    }

    // 利用LockerArea_ID刪除一個 locker   lockerAreaService.deleteLockerAreaByLockerAreaID(LockerArea_ID)
    @DeleteMapping("/{LockerArea_ID}")
    public void deleteLockerArea(@PathVariable("LockerArea_ID") Long LockerArea_ID) {
        lockerAreaService.deleteLockerAreaByLockerAreaID(LockerArea_ID);
    }


}
