package com.example.demo.controller;

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
public class depositController {

    @Autowired
    private depositService depositService;

    // 新增一個 deposit
    @PostMapping("/")
    public ResponseEntity<deposit> createDeposit(@RequestBody deposit deposit) {
        deposit savedDeposit = depositService.save(deposit);
        return new ResponseEntity<>(savedDeposit, HttpStatus.CREATED);
    }

    // 獲取所有 deposits
    @GetMapping
    public List<deposit> listAlldeposit(@RequestParam(required = false, name = "Deposit_ID") Long Deposit_ID) {
        if (Deposit_ID != null) {
            return depositService.getDepositByDepositID(Deposit_ID);
        } else {
            return depositService.getAllDeposit();
        }
    }

    // 獲取單個 deposit
    @GetMapping("/{Deposit_ID}")
    public Optional<deposit> getDepositByDepositID(@PathVariable(value = "Deposit_ID") Long Deposit_ID) {
        return depositService.findDepositByDepositID(Deposit_ID);
    }

    // 更新一個 deposit
    @PutMapping("/{Deposit_ID}")
    public deposit updateDeposit(@PathVariable(value = "Deposit_ID") Long Deposit_ID,
                               @RequestBody deposit depositDetails) {
        Optional<deposit> deposit = depositService.findByDepositID(Deposit_ID);
        deposit existingdeposit = deposit.get();
        existingdeposit.setDepositPassword(depositDetails.getDepositPassword());
        existingdeposit.setTotalPrice(depositDetails.getTotalPrice());
        return depositService.save(existingdeposit);
    }

    // 刪除一個 deposit
    @DeleteMapping("/{Deposit_ID}")
    public void deleteDeposit(@PathVariable(value = "Deposit_ID") Long Deposit_ID) {
        depositService.deleteDepositByDepositID(Deposit_ID);
    }

}
