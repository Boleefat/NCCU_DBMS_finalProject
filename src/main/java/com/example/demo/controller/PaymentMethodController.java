package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import com.example.demo.model.PaymentMethod;
import com.example.demo.model.paymentMethod;

import org.springframework.security.core.context.SecurityContextHolder;

@RestController
@RequestMapping("/api/paymentMethod")
public class PaymentMethodController {
    @Autowired
    private PaymentMethodService paymentMethodService;

    // 新增一個 paymentMethod   paymentMethodService.createpaymentMethod(paymentMethod)
    @PostMapping("/")
    public ResponseEntity<PaymentMethod> createpaymentMethod(@RequestBody PaymentMethod paymentMethod) {
        PaymentMethod createdpaymentMethod = paymentMethodService.createpaymentMethod(paymentMethod);
        return new ResponseEntity<PaymentMethod>(createdpaymentMethod, HttpStatus.CREATED);
    }

    // 獲取所有 paymentMethod   paymentMethodService.getAllPaymentMethod()
    @GetMapping
    public List<PaymentMethod> listAllPaymentMethod(@RequestParam(required = false, name = "paymentMethod_id") Long PaymentMethodID) {
        return paymentMethodService.getAllPaymentMethod();
    }

    // 獲取單個 paymentMethod   paymentMethodService.getPaymentMethodByPaymentMethodID(PaymentMethod_ID)
    @GetMapping("/{paymentMethod_id}")
    public Optional<PaymentMethod> getPaymentMethodBypaymentMethodID(@PathVariable("paymentMethod_id") Long PaymentMethodID) {
        return paymentMethodService.getPaymentMethodByPaymentMethodID(PaymentMethodID);
    }

    // 更新一個 paymentMethod   updatepaymentMethod(PaymentMethod_ID, paymentMethod)
    @PutMapping("/{paymentMethod_id}")
    public PaymentMethod updatepaymentMethod(@PathVariable("paymentMethod_id") Long PaymentMethodID, @RequestBody PaymentMethod paymentMethod) {
        return updatepaymentMethod(PaymentMethodID, paymentMethod);
    }

    // 刪除一個 paymentMethod   paymentMethodService.deletePaymentMethodByPaymentMethodID(PaymentMethod_ID)
    @DeleteMapping("/{paymentMethod_id}")   
    public void deletePaymentMethod(@PathVariable("paymentMethod_id") Long PaymentMethodID) {
        paymentMethodService.deletePaymentMethodByPaymentMethodID(PaymentMethodID);
    }
}
