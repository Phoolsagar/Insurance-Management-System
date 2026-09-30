package com.insurance.config;
import com.insurance.entity.*; import com.insurance.repository.*; import org.springframework.boot.CommandLineRunner; import org.springframework.context.annotation.Bean; import org.springframework.context.annotation.Configuration; import org.springframework.security.crypto.password.PasswordEncoder; import java.math.BigDecimal;
@Configuration public class DataInitializer {
 @Bean CommandLineRunner seed(UserRepository users,PolicyRepository policies,PasswordEncoder enc){
  return args->{if(users.count()==0){User a=new User();a.setName("System Admin");a.setEmail("admin@insurance.local");a.setPassword(enc.encode("Admin@123"));a.setRole(Role.ADMIN);users.save(a);
   User ag=new User();ag.setName("Demo Agent");ag.setEmail("agent@insurance.local");ag.setPassword(enc.encode("Agent@123"));ag.setRole(Role.AGENT);users.save(ag);
   User c=new User();c.setName("Demo Customer");c.setEmail("customer@insurance.local");c.setPassword(enc.encode("Customer@123"));c.setRole(Role.CUSTOMER);users.save(c);
   add(policies,"Secure Life Plus",PolicyType.LIFE,"Life cover with flexible term options",12000,1000000);
   add(policies,"Health Shield",PolicyType.HEALTH,"Family health insurance cover",8500,500000);
   add(policies,"Motor Protect",PolicyType.MOTOR,"Comprehensive motor insurance",6500,300000);
   add(policies,"Home Secure",PolicyType.HOME,"Protection for home and contents",7000,800000);
   add(policies,"Travel Safe",PolicyType.TRAVEL,"Travel protection for domestic and international trips",2500,200000);
  }};
 }
 private void add(PolicyRepository r,String n,PolicyType t,String d,double p,double c){Policy x=new Policy();x.setPolicyNumber("POL-"+t.name()+"-"+System.nanoTime());x.setName(n);x.setType(t);x.setDescription(d);x.setPremium(BigDecimal.valueOf(p));x.setCoverageAmount(BigDecimal.valueOf(c));x.setTermMonths(12);x.setStatus(PolicyStatus.ACTIVE);r.save(x);}
}
