package com.insurance.dto;
import jakarta.validation.constraints.*; import java.math.BigDecimal;
public record ClaimRequest(@NotNull Long policyId,@NotBlank String reason,@NotNull @Positive BigDecimal amount,String documentUrl){}
