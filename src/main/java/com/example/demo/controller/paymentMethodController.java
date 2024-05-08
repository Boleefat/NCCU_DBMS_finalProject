package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.paymentMethod;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/paymentMethod")
public class paymentMethodController {
    @Autowired
    private paymentMethodService paymentMethodService;

    // 新增一個 paymentMethod
    @PostMapping("/")
    public ResponseEntity<paymentMethod> createpaymentMethod(@RequestBody paymentMethod paymentMethod) {
        paymentMethod savedpaymentMethod = paymentMethodService.save(paymentMethod);
        return new ResponseEntity<>(savedpaymentMethod, HttpStatus.CREATED);
    }

    // 獲取所有 paymentMethod
    @GetMapping
    public List<paymentMethod> listAllPaymentMethod(@RequestParam(required = false, name = "PaymentMethod_ID") Long PaymentMethod_ID) {
        if (PaymentMethod_ID != null) {
            return paymentMethodService.getPaymentMethodByPaymentMethodID(PaymentMethod_ID);
        } else {
            return paymentMethodService.getAllPaymentMethod();
        }
    }

    // 獲取單個 paymentMethod
    @GetMapping("/{PaymentMethod_ID}")
    public Optional<paymentMethod> getPaymentMethodBypaymentMethodID(@PathVariable(value = "PaymentMethod_ID") Long PaymentMethod_ID) {
        return paymentMethodService.findPaymentMethodByPaymentMethodID(PaymentMethod_ID);
    }

    // 更新一個 paymentMethod
    @PutMapping("/{PaymentMethod_ID}")
    public paymentMethod updatepaymentMethod(@PathVariable(value = "PaymentMethod_ID") Long PaymentMethod_ID,
                               @RequestBody paymentMethod paymentMethodDetails) {
        Optional<paymentMethod> paymentMethod = paymentMethodService.findPaymentMethodByPaymentMethod(PaymentMethod_ID);
        paymentMethod existingpaymentMethod = paymentMethod.get();
        existingpaymentMethod.setStationName(paymentMethodDetails.getPaymentMethodName());
        return paymentMethodService.save(existingpaymentMethod);
    }

    // 刪除一個 paymentMethod
    @DeleteMapping("/{PaymentMethod_ID}")
    public void deletePaymentMethod(@PathVariable(value = "PaymentMethod_ID") Long PaymentMethod_ID) {
        paymentMethodService.deletePaymentMethodByPaymentMethodID(PaymentMethod_ID);
    }
}
