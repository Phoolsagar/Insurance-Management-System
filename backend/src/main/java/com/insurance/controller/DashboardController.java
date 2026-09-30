package com.insurance.controller;
import com.insurance.entity.*; import com.insurance.repository.*; import org.springframework.web.bind.annotation.*; import java.math.BigDecimal; import java.util.*;
@RestController @RequestMapping("/dashboard") public class DashboardController {
 private final UserRepository users;private final PolicyRepository policies;private final ClaimRepository claims;private final PaymentRepository payments;
 public DashboardController(UserRepository u,PolicyRepository p,ClaimRepository c,PaymentRepository pay){users=u;policies=p;claims=c;payments=pay;}
 @GetMapping("/summary") public Map<String,Object> summary(){Map<String,Object> result=new LinkedHashMap<>();result.put("customers",users.countByRole(Role.CUSTOMER));result.put("agents",users.countByRole(Role.AGENT));result.put("policies",policies.count());result.put("activePolicies",policies.countByStatus(PolicyStatus.ACTIVE));result.put("claims",claims.count());result.put("pendingClaims",claims.countByStatus(ClaimStatus.SUBMITTED));result.put("approvedClaims",claims.countByStatus(ClaimStatus.APPROVED));result.put("settledClaims",claims.countByStatus(ClaimStatus.SETTLED));result.put("payments",payments.count());result.put("paidPremiums",payments.sumAmountByStatus(PaymentStatus.PAID));result.put("pendingPayments",payments.countByStatus(PaymentStatus.PENDING));return result;}
}
