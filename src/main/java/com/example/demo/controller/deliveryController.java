package com.example.demo.controller;
import com.example.demo.model.delivery;
import com.example.demo.model.delivery;
import com.example.demo.service.deliveryService;

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
@RequestMapping("/api/delivery")
public class deliveryController {
    // 新增一個 delivery
    @PostMapping("/")
    public ResponseEntity<delivery> createDelivery(@RequestBody delivery delivery) {
        delivery savedDelivery = deliveryService.save(delivery);
        return new ResponseEntity<>(savedDelivery, HttpStatus.CREATED);
    }

    // 獲取所有 deliverys
    @GetMapping
    public List<Delivery> listAllDelivery(@RequestParam(required = false, name = "Delivery_ID") Long Delivery_ID) {
        if (Delivery_ID != null) {
            return deliveryService.getDeliveryByDeliveryID(Delivery_ID);
        } else {
            return deliveryService.getAllDelivery();
        }
    }

    // 獲取單個 delivery
    @GetMapping("/{Delivery_ID}")
    public Optional<delivery> getDeliveryByDeliveryID(@PathVariable(value = "Delivery_ID") Long Delivery_ID) {
        return deliveryService.findDeliveryByDeliveryID(Delivery_ID);
    }

    // 更新一個 delivery
    @PutMapping("/{Delivery_ID}")
    public delivery updateDelivery(@PathVariable(value = "Delivery_ID") Long Delivery_ID,
                               @RequestBody delivery deliveryDetails) {
        Optional<delivery> delivery = deliveryService.findByDeliveryID(Delivery_ID);
        delivery existingdelivery = delivery.get();
        return deliveryService.save(existingdelivery);
    }

    // 刪除一個 delivery
    @DeleteMapping("/{Delivery_ID}")
    public void deleteDelivery(@PathVariable(value = "Delivery_ID") Long Delivery_ID) {
        deliveryService.deleteDeliveryByDeliveryID(Delivery_ID);
    }
}
