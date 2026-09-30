package com.insurance.dto;
import com.insurance.entity.Role; import jakarta.validation.constraints.*;
public record UserRequest(@NotBlank String name,@Email @NotBlank String email,String password,@NotNull Role role,String phone,String address) {}