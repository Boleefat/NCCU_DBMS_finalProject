package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.possession_area_lockerService;
import com.example.demo.service.lockerAreaService;
import com.example.demo.service.lockerService;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/possession_area_lockerMethod")
public class possession_area_lockerController {

    @Autowired
    private lockerAreaService lockerAreaService;

    @Autowired
    private lockerService lockerService;

}
