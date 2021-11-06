package com.auth.service.config.security;

import com.auth.service.model.AccountEntity;
import com.auth.service.service.AccountDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class UserDetailsServiceImpl implements UserDetailsService {

    private final AccountDBService accessService;

    @Override
    public UserDetails loadUserByUsername(String email) {
        AccountEntity accessRequestEntity = accessService.getByEmail(email);
        return new CustomUserDetails(accessRequestEntity.getEmail(), accessRequestEntity.getPassword());
    }
}
