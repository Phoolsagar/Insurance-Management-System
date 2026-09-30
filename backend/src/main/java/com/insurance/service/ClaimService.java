package com.insurance.service;
import com.insurance.dto.*; import com.insurance.entity.*; import com.insurance.repository.*; import org.springframework.stereotype.Service; import java.util.*;
@Service public class ClaimService {
 private final ClaimRepository claims; private final PolicyRepository policies; private final UserRepository users;
 public ClaimService(ClaimRepository c,PolicyRepository p,UserRepository u){claims=c;policies=p;users=u;}
 public List<Claim> all(){return claims.findAll();}
 public List<Claim> mine(String email){User u=users.findByEmail(email).orElseThrow();return claims.findByCustomerId(u.getId());}
 public Claim create(ClaimRequest r,String email){User u=users.findByEmail(email).orElseThrow();Policy p=policies.findById(r.policyId()).orElseThrow(()->new RuntimeException("Policy not found"));if(p.getCustomer()==null||!p.getCustomer().getId().equals(u.getId()))throw new RuntimeException("You can only claim your own policy");Claim c=new Claim();c.setClaimNumber("CLM-"+UUID.randomUUID().toString().substring(0,8).toUpperCase());c.setCustomer(u);c.setPolicy(p);c.setReason(r.reason());c.setAmount(r.amount());c.setDocumentUrl(r.documentUrl());return claims.save(c);}
 public Claim status(Long id,StatusRequest r){Claim c=claims.findById(id).orElseThrow(()->new RuntimeException("Claim not found"));c.setStatus(r.status());c.setRemarks(r.remarks());c.touch();return claims.save(c);}
}
