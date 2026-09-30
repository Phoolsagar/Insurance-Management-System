package com.insurance.controller;
import com.insurance.dto.*; import com.insurance.entity.Claim; import com.insurance.service.ClaimService; import jakarta.validation.Valid; import org.springframework.security.core.Authentication; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/claims") public class ClaimController {
 private final ClaimService s;public ClaimController(ClaimService s){this.s=s;}
 @GetMapping public List<Claim> all(Authentication a){return a.getAuthorities().stream().anyMatch(x->x.getAuthority().equals("ROLE_CUSTOMER"))?s.mine(a.getName()):s.all();}
 @PostMapping public Claim create(@Valid @RequestBody ClaimRequest r,Authentication a){return s.create(r,a.getName());}
 @PatchMapping("/{id}/status") @PreAuthorize("hasAnyRole('ADMIN','AGENT')") public Claim status(@PathVariable Long id,@RequestBody StatusRequest r){return s.status(id,r);}
}
