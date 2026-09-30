package com.insurance.entity;
import jakarta.persistence.*; import com.fasterxml.jackson.annotation.JsonIgnore; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="payments")
public class Payment {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String transactionId;
 @JsonIgnore @ManyToOne(optional=false) private User customer; @JsonIgnore @ManyToOne(optional=false) private Policy policy;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal amount;
 @Enumerated(EnumType.STRING) private PaymentStatus status=PaymentStatus.PAID;
 private LocalDateTime paidAt=LocalDateTime.now();
 public Long getId(){return id;} public String getTransactionId(){return transactionId;} public void setTransactionId(String v){transactionId=v;}
 public User getCustomer(){return customer;} public void setCustomer(User v){customer=v;} public Policy getPolicy(){return policy;} public void setPolicy(Policy v){policy=v;}
 public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;} public PaymentStatus getStatus(){return status;} public void setStatus(PaymentStatus v){status=v;} public LocalDateTime getPaidAt(){return paidAt;}
}
