package com.insurance.repository;
import com.insurance.entity.User; import org.springframework.data.jpa.repository.JpaRepository; import java.util.*;
import com.insurance.entity.*;
public interface UserRepository extends JpaRepository<User,Long> { Optional<User> findByEmail(String email); long countByRole(Role role); }
