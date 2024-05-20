package com.example.demo.controller;

import com.example.demo.model.Deposit;
import com.example.demo.model.deposit;
import com.example.demo.service.depositService;

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
@RequestMapping("/api/deposit")
public class DepositController {

    @Autowired
    private DepositService depositService;

    // 新增一個 deposit   depositService.createDeposit(deposit);
    @PostMapping("/")
    public ResponseEntity<Deposit> createDeposit(@RequestBody Deposit deposit) {
        Deposit createdDeposit = depositService.createDeposit(deposit);
        return new ResponseEntity<Deposit>(createdDeposit, HttpStatus.CREATED);
    }

    // 獲取所有 deposits   depositService.getAllDeposit();
    @GetMapping
    public List<Deposit> listAlldeposit(@RequestParam(required = false, name = "deposit_id") Long DepositID) {
        return depositService.getAllDeposit();
    }

    // 獲取單個 deposit   depositService.getDepositByDepositID(DepositID);
    @GetMapping("/{deposit_id}")
    public Optional<Deposit> getDepositByDepositID(@PathVariable("deposit_id") Long DepositID) {
        return depositService.getDepositByDepositID(DepositID);
    }

    // 更新一個 deposit   updateDeposit(DepositID, deposit);
    @PutMapping("/{deposit_id}")
    public Deposit updateDeposit(@PathVariable("deposit_id") Long DepositID, @RequestBody Deposit deposit) {
        return updateDeposit(DepositID, deposit);
    }

    // 刪除一個 deposit   depositService.deleteDepositByDepositID(DepositID);
    @DeleteMapping("/{deposit_id}")
    public void deleteDeposit(@PathVariable("deposit_id") Long DepositID) {
        depositService.deleteDepositByDepositID(DepositID);
    }

}
