package com.example.demo.controller;
import com.example.demo.model.Delivery;
import com.example.demo.service.DeliveryService;
import com.example.demo.repository.DeliveryRepository;
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
    public List<Delivery> listAllDelivery(@RequestParam(required = false, name = "delivery_id") Long DeliveryID) {
        return deliveryService.getAllDelivery();
    }

    // 獲取單個 delivery   deliveryService.getDeliveryByDeliveryID(DeliveryID);
    @GetMapping("/{delivery_id}")
    public Optional<Delivery> getDeliveryByDeliveryID(@PathVariable("delivery_id") Long DeliveryID) {
        return deliveryService.getDeliveryByDeliveryID(DeliveryID);
    }

    // 更新一個 delivery   delivery.updateDelivery(DeliveryID, delivery);
    @PutMapping("/{Delivery_ID}")
    public Delivery updateDelivery(@PathVariable("delivery_id") Long DeliveryID, @RequestBody Delivery delivery) {
        return delivery.updateDelivery(DeliveryID, delivery);
    }

    // 刪除一個 delivery   deliveryService.deleteDeliveryByDeliveryID(DeliveryID);
    @DeleteMapping("/{delivery_id}")
    public void deleteDelivery(@PathVariable("delivery_id") Long DeliveryID) {
        deliveryService.deleteDeliveryByDeliveryID(DeliveryID);
    }
}
