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
    public List<PaymentMethod> listAllPaymentMethod(@RequestParam(required = false, name = "PaymentMethod_ID") Long PaymentMethod_ID) {
        return paymentMethodService.getAllPaymentMethod();
    }

    // 獲取單個 paymentMethod   paymentMethodService.getPaymentMethodByPaymentMethodID(PaymentMethod_ID)
    @GetMapping("/{PaymentMethod_ID}")
    public Optional<PaymentMethod> getPaymentMethodBypaymentMethodID(@PathVariable("PaymentMethod_ID") Long PaymentMethod_ID) {
        return paymentMethodService.getPaymentMethodByPaymentMethodID(PaymentMethod_ID);
    }

    // 更新一個 paymentMethod   updatepaymentMethod(PaymentMethod_ID, paymentMethod)
    @PutMapping("/{PaymentMethod_ID}")
    public PaymentMethod updatepaymentMethod(@PathVariable("PaymentMethod_ID") Long PaymentMethod_ID, @RequestBody PaymentMethod paymentMethod) {
        return updatepaymentMethod(PaymentMethod_ID, paymentMethod);
    }

    // 刪除一個 paymentMethod   paymentMethodService.deletePaymentMethodByPaymentMethodID(PaymentMethod_ID)
    @DeleteMapping("/{PaymentMethod_ID}")   
    public void deletePaymentMethod(@PathVariable("PaymentMethod_ID") Long PaymentMethod_ID) {
        paymentMethodService.deletePaymentMethodByPaymentMethodID(PaymentMethod_ID);
    }
}
