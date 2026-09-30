package com.insurance.repository;
import com.insurance.entity.Claim; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
import com.insurance.entity.*;
public interface ClaimRepository extends JpaRepository<Claim,Long> { List<Claim> findByCustomerId(Long id); long countByStatus(ClaimStatus status); }
