package com.insurance.entity;
import jakarta.persistence.*; import com.fasterxml.jackson.annotation.JsonIgnore; import java.math.BigDecimal; import java.time.LocalDateTime;
@Entity @Table(name="claims")
public class Claim {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String claimNumber;
 @ManyToOne(optional=false) private Policy policy;
 @JsonIgnore @ManyToOne(optional=false) private User customer;
 @Column(nullable=false) private String reason;
 @Column(precision=12,scale=2) private BigDecimal amount;
 private String documentUrl; private String remarks;
 @Enumerated(EnumType.STRING) private ClaimStatus status=ClaimStatus.SUBMITTED;
 private LocalDateTime createdAt=LocalDateTime.now(); private LocalDateTime updatedAt=LocalDateTime.now();
 public Long getId(){return id;} public String getClaimNumber(){return claimNumber;} public void setClaimNumber(String v){claimNumber=v;}
 public Policy getPolicy(){return policy;} public void setPolicy(Policy v){policy=v;} public User getCustomer(){return customer;} public void setCustomer(User v){customer=v;}
 public String getReason(){return reason;} public void setReason(String v){reason=v;} public BigDecimal getAmount(){return amount;} public void setAmount(BigDecimal v){amount=v;}
 public String getDocumentUrl(){return documentUrl;} public void setDocumentUrl(String v){documentUrl=v;} public String getRemarks(){return remarks;} public void setRemarks(String v){remarks=v;}
 public ClaimStatus getStatus(){return status;} public void setStatus(ClaimStatus v){status=v;} public LocalDateTime getCreatedAt(){return createdAt;} public LocalDateTime getUpdatedAt(){return updatedAt;} public void touch(){updatedAt=LocalDateTime.now();}
}
