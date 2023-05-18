package com.terrator.security.repository;

import com.terrator.security.entity.SecurityUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityUserRepository extends JpaRepository<SecurityUser, Long> {
    Optional<SecurityUser> findByName(String username);
}
