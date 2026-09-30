package com.insurance.dto;
import com.insurance.entity.PolicyType; import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record PolicyRequest(@NotBlank String name,@NotNull PolicyType type,String description,@NotNull @Positive BigDecimal premium,@NotNull @Positive BigDecimal coverageAmount,@Positive Integer termMonths){}
