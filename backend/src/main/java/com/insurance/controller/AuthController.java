package com.insurance.controller;
import com.insurance.dto.AuthDtos.*; import com.insurance.service.AuthService; import jakarta.validation.Valid; import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/auth") public class AuthController {private final AuthService s;public AuthController(AuthService s){this.s=s;}@PostMapping("/register") public AuthResponse register(@Valid @RequestBody Register r){return s.register(r);}@PostMapping("/login") public AuthResponse login(@Valid @RequestBody Login r){return s.login(r);}}
