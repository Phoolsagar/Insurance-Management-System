package com.insurance.controller;
import com.insurance.dto.PolicyRequest; import com.insurance.entity.Policy; import com.insurance.service.PolicyService; import jakarta.validation.Valid; import org.springframework.security.core.Authentication; import org.springframework.security.access.prepost.PreAuthorize; import org.springframework.web.bind.annotation.*; import java.util.*;
@RestController @RequestMapping("/policies") public class PolicyController {
 private final PolicyService s; public PolicyController(PolicyService s){this.s=s;}
 @GetMapping public List<Policy> all(){return s.all();}
 @GetMapping("/mine") public List<Policy> mine(Authentication a){return s.mine(a.getName());}
 @PostMapping @PreAuthorize("hasRole('ADMIN')") public Policy create(@Valid @RequestBody PolicyRequest r){return s.create(r);}
 @PutMapping("/{id}") @PreAuthorize("hasRole('ADMIN')") public Policy update(@PathVariable Long id,@Valid @RequestBody PolicyRequest r){return s.update(id,r);}
 @DeleteMapping("/{id}") @PreAuthorize("hasRole('ADMIN')") public void delete(@PathVariable Long id){s.delete(id);}
 @PostMapping("/{id}/purchase") public Policy purchase(@PathVariable Long id,Authentication a){return s.purchase(id,a.getName());}
}
