package com.insurance.dto;
import com.insurance.entity.Role;
public class AuthDtos {
 public record Register(String name,String email,String password,String phone,String address){}
 public record Login(String email,String password){}
 public record AuthResponse(String token,Long id,String name,String email,Role role){}
}
