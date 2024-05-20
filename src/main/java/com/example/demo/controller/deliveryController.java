package com.example.demo.controller;
import com.example.demo.model.Delivery;
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
public class DeliveryController {
    // 新增一個 delivery   deliveryService.createdDelivery(delivery);
    @PostMapping("/")
    public ResponseEntity<Delivery> createDelivery(@RequestBody Delivery delivery) {
        Delivery createdDelivery = deliveryService.createdDelivery(delivery);
        return new ResponseEntity<Delivery>(createdDelivery, HttpStatus.CREATED);
    }

    // 獲取所有 deliverys   deliveryService.getAllDelivery();
    @GetMapping
    public List<Delivery> listAllDelivery(@RequestParam(required = false, name = "Delivery_ID") Long Delivery_ID) {
        return deliveryService.getAllDelivery();
    }

    // 獲取單個 delivery   deliveryService.getDeliveryByDeliveryID(Delivery_ID);
    @GetMapping("/{Delivery_ID}")
    public Optional<Delivery> getDeliveryByDeliveryID(@PathVariable("Delivery_ID") Long Delivery_ID) {
        return deliveryService.getDeliveryByDeliveryID(Delivery_ID);
    }

    // 更新一個 delivery   delivery.updateDelivery(Delivery_ID, delivery);
    @PutMapping("/{Delivery_ID}")
    public Delivery updateDelivery(@PathVariable("Delivery_ID") Long Delivery_ID, @RequestBody Delivery delivery) {
        return delivery.updateDelivery(Delivery_ID, delivery);
    }

    // 刪除一個 delivery   deliveryService.deleteDeliveryByDeliveryID(Delivery_ID);
    @DeleteMapping("/{Delivery_ID}")
    public void deleteDelivery(@PathVariable("Delivery_ID") Long Delivery_ID) {
        deliveryService.deleteDeliveryByDeliveryID(Delivery_ID);
    }
}
