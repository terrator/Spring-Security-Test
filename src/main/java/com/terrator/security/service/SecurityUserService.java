package com.terrator.security.service;

import com.terrator.security.entity.SecurityUser;
import com.terrator.security.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityUserService {
    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Autowired
    private PasswordEncoder encoder;

    public String save(SecurityUser securityUser) {
        securityUser.setPassword(encoder.encode(securityUser.getPassword()));
        securityUserRepository.save(securityUser);
        return "User " + securityUser.getName() +  " has been registered";
    }
}
