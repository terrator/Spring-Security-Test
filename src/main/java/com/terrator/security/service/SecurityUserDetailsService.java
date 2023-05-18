package com.terrator.security.service;

import com.terrator.security.entity.SecurityUser;
import com.terrator.security.model.SecurityUserDetails;
import com.terrator.security.repository.SecurityUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class SecurityUserDetailsService implements UserDetailsService {
    @Autowired
    private SecurityUserRepository securityUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<SecurityUser> securityUser = securityUserRepository.findByName(username);
        return securityUser.map(SecurityUserDetails::new)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
