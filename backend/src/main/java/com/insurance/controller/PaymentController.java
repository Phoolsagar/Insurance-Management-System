package com.insurance.controller;
import com.insurance.entity.Payment; import com.insurance.repository.*; import org.springframework.security.core.Authentication; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/payments") public class PaymentController {
 private final PaymentRepository payments;private final UserRepository users;public PaymentController(PaymentRepository p,UserRepository u){payments=p;users=u;}
 @GetMapping public List<Payment> all(Authentication a){var u=users.findByEmail(a.getName()).orElseThrow();return a.getAuthorities().stream().anyMatch(x->x.getAuthority().equals("ROLE_CUSTOMER"))?payments.findByCustomerId(u.getId()):payments.findAll();}
}
