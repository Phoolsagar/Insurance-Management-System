package com.insurance.entity;
import jakarta.persistence.*; import com.fasterxml.jackson.annotation.JsonIgnore; import java.math.BigDecimal; import java.time.LocalDate;
@Entity @Table(name="policies")
public class Policy {
 @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
 @Column(nullable=false,unique=true) private String policyNumber;
 @Column(nullable=false) private String name;
 @Enumerated(EnumType.STRING) @Column(nullable=false) private PolicyType type;
 private String description; @Column(nullable=false,precision=12,scale=2) private BigDecimal premium;
 @Column(nullable=false,precision=12,scale=2) private BigDecimal coverageAmount;
 private Integer termMonths=12; private LocalDate startDate; private LocalDate endDate;
 @Enumerated(EnumType.STRING) private PolicyStatus status=PolicyStatus.ACTIVE;
 @JsonIgnore @ManyToOne(fetch=FetchType.LAZY) private User customer;
 public Long getId(){return id;} public String getPolicyNumber(){return policyNumber;} public void setPolicyNumber(String v){policyNumber=v;}
 public String getName(){return name;} public void setName(String v){name=v;} public PolicyType getType(){return type;} public void setType(PolicyType v){type=v;}
 public String getDescription(){return description;} public void setDescription(String v){description=v;} public BigDecimal getPremium(){return premium;} public void setPremium(BigDecimal v){premium=v;}
 public BigDecimal getCoverageAmount(){return coverageAmount;} public void setCoverageAmount(BigDecimal v){coverageAmount=v;} public Integer getTermMonths(){return termMonths;} public void setTermMonths(Integer v){termMonths=v;}
 public LocalDate getStartDate(){return startDate;} public void setStartDate(LocalDate v){startDate=v;} public LocalDate getEndDate(){return endDate;} public void setEndDate(LocalDate v){endDate=v;}
 public PolicyStatus getStatus(){return status;} public void setStatus(PolicyStatus v){status=v;} public User getCustomer(){return customer;} public void setCustomer(User v){customer=v;}
}
