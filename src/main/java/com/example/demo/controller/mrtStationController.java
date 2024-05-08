package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.mrtStation;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/mrtStation")
public class mrtStationController {

    @Autowired
    private mrtStationService mrtStationService;

    // 新增一個 mrtStation
    @PostMapping("/")
    public ResponseEntity<mrtStation> createmrtStation(@RequestBody mrtStation mrtStation) {
        mrtStation savedmrtStation = mrtStationService.save(mrtStation);
        return new ResponseEntity<>(savedmrtStation, HttpStatus.CREATED);
    }

    // 獲取所有 mrtStation
    @GetMapping
    public List<mrtStation> listAllmrtStation(@RequestParam(required = false, name = "Station_ID") Long Station_ID) {
        if (Station_ID != null) {
            return mrtStationService.getStationByStationID(Station_ID);
        } else {
            return mrtStationService.getAllStation();
        }
    }

    // 獲取單個 mrtStation
    @GetMapping("/{Station_ID}")
    public Optional<mrtStation> getStationByStationID(@PathVariable(value = "Station_ID") Long Station_ID) {
        return mrtStationService.findStationByStationID(Station_ID);
    }

    // 更新一個 mrtStation
    @PutMapping("/{Station_ID}")
    public locker updatemrtStation(@PathVariable(value = "Station_ID") Long Station_ID,
                               @RequestBody mrtStation mrtStationDetails) {
        Optional<mrtStation> mrtStation = mrtStationService.findStationByStationID(Station_ID);
        locker existingmrtStation = mrtStation.get();
        existingmrtStation.setLocation(mrtStationDetails.getLocation());
        existingmrtStation.setStationName(mrtStationDetails.getStationName());
        return mrtStationService.save(existingmrtStation);
    }

    // 刪除一個 mrtStation
    @DeleteMapping("/{Station_ID}")
    public void deleteStation(@PathVariable(value = "Station_ID") Long Station_ID) {
        mrtStationService.deleteStationByStationID(Station_ID);
    }



}
