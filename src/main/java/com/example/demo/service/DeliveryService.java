package com.example.demo.service;

import com.example.demo.model.Delivery;
import com.example.demo.model.User;
import com.example.demo.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;

    public Delivery createdDelivery(Delivery delivery){
        return deliveryRepository.save(delivery);
    }

    public Delivery getAllDelivery(){
        return deliveryRepository.findAll();
    }




    public DeliveryService(DeliveryRepository deliveryRepository) {
        this.deliveryRepository = deliveryRepository;
    }

    public List<Delivery> getUsers() {
        return deliveryRepository.findAll();
    }

    public Optional<Delivery> getUserById(Long id) {
        return deliveryRepository.findById(id);
    }

    public Optional<Delivery> getUserByEmail(String email) {
        return deliveryRepository.findByEmail(email);
    }

    public Delivery createUser(Delivery user) {
        return deliveryRepository.save(user);
    }

    public Delivery updateUser(User user) {
        return deliveryRepository.save(user);
    }

    public Delivery deleteUser(Long id) {
        deliveryRepository.deleteById(id);
    }
}