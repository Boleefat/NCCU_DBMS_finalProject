package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.locker;
import com.example.demo.model.pickUpService;
import com.example.demo.service.deliveryService;
import com.example.demo.service.hotelService;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/pickUp")
public class pickUpController {

    @Autowired
    private deliveryService deliveryService;

    @Autowired
    private hotelService hotelService;

    // 新增一個 pickUp
    @PostMapping("/")
    public ResponseEntity<pickUp> createpickUp(@RequestBody pickUp pickUp) {
        pickUp savedPickUp = pickUpService.save(pickUp);
        return new ResponseEntity<>(savedPickUp, HttpStatus.CREATED);
    }

    // 獲取所有 pickUps
    @GetMapping
    public List<pickUp> listAllPickUp(@RequestParam(required = false, name = "Delivery_ID") Long Delivery_ID) {
        if (Delivery_ID != null) {
            return pickUpService.getPickUpByDeliveryID(Delivery_ID);
        } else {
            return pickUpService.getAllPickUp();
        }
    }

    // 獲取單個 pickUp
    @GetMapping("/{Delivery_ID}")
    public Optional<pickUp> getPickUpByDeliveryID(@PathVariable(value = "Delivery_ID") Long Delivery_ID) {
        return pickUpService.findPickUpByDeliveryID(Delivery_ID);
    }

    // 更新一個 pickUp
    @PutMapping("/{Delivery_ID}")
    public pickUp updatePickUp(@PathVariable(value = "Delivery_ID") Long Delivery_ID,
                               @RequestBody pickUp pickUpDetails) {
        Optional<pickUp> pickUp = pickUpService.findByDeliveryID(Delivery_ID);
        pickUp existingpickUp = pickUp.get();
        existingpickUp.setHotelID(pickUpDetails.getHotelID());
        existingpickUp.setStatus(pickUpDetails.getStatus());
        existingpickUp.setPickedUp(pickUpDetails.getPickedUp());
        existingpickUp.setWaiting(pickUpDetails.getWaiting());
        return pickUpService.save(existingpickUp);
    }

    // 刪除一個 pickUp
    @DeleteMapping("/{Delivery_ID}")
    public void deletepickUp(@PathVariable(value = "Delivery_ID") Long Delivery_ID) {
        pickUpService.deletepickUpByDeliveryID(Delivery_ID);
    }

}
