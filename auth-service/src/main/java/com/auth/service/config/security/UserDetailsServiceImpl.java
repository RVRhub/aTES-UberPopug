package com.auth.service.config.security;

import java.util.ArrayList;
import java.util.List;

import com.auth.service.model.AccountEntity;
import com.auth.service.service.AccountDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.common.utils.SecurityUtils;

import org.springframework.security.core.GrantedAuthority;
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

		List<GrantedAuthority> roles = new ArrayList<>();
		roles.add((GrantedAuthority) () -> "USER");
		return new CustomUserDetails(accessRequestEntity.getEmail(), accessRequestEntity.getPassword(), roles);
	}
}
