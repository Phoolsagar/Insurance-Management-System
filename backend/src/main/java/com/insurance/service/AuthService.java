package com.insurance.service;
import com.insurance.dto.AuthDtos.*; import com.insurance.entity.*; import com.insurance.repository.UserRepository; import com.insurance.security.JwtService; import org.springframework.security.crypto.password.PasswordEncoder; import org.springframework.stereotype.Service;
@Service public class AuthService {
 private final UserRepository users; private final PasswordEncoder encoder; private final JwtService jwt;
 public AuthService(UserRepository u,PasswordEncoder e,JwtService j){users=u;encoder=e;jwt=j;}
 public AuthResponse register(Register r){if(users.findByEmail(r.email()).isPresent())throw new RuntimeException("Email already registered");User u=new User();u.setName(r.name());u.setEmail(r.email());u.setPassword(encoder.encode(r.password()));u.setPhone(r.phone());u.setAddress(r.address());u.setRole(Role.CUSTOMER);users.save(u);return response(u);}
 public AuthResponse login(Login r){User u=users.findByEmail(r.email()).orElseThrow(()->new RuntimeException("Invalid email or password"));if(!encoder.matches(r.password(),u.getPassword()))throw new RuntimeException("Invalid email or password");return response(u);}
 private AuthResponse response(User u){return new AuthResponse(jwt.generate(u.getEmail(),u.getRole().name()),u.getId(),u.getName(),u.getEmail(),u.getRole());}
}
