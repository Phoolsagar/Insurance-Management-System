package com.insurance.repository;
import com.insurance.entity.Payment; import com.insurance.entity.PaymentStatus; import org.springframework.data.jpa.repository.JpaRepository; import org.springframework.data.jpa.repository.Query; import org.springframework.data.repository.query.Param; import java.math.BigDecimal; import java.util.*;
import com.insurance.entity.*;
public interface PaymentRepository extends JpaRepository<Payment,Long> { List<Payment> findByCustomerId(Long id); long countByStatus(PaymentStatus status); @Query("select coalesce(sum(p.amount),0) from Payment p where p.status = :status") BigDecimal sumAmountByStatus(@Param("status") PaymentStatus status); }
