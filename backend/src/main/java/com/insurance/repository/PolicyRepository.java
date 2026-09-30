package com.insurance.repository;
import com.insurance.entity.Policy; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
import com.insurance.entity.*;
public interface PolicyRepository extends JpaRepository<Policy,Long> { List<Policy> findByCustomerId(Long id); long countByStatus(PolicyStatus status); }
