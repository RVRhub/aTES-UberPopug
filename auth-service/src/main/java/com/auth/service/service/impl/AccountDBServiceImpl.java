package com.auth.service.service.impl;

import com.auth.service.model.AccountEntity;
import com.auth.service.repository.AccountRepository;
import com.auth.service.service.AccountDBService;

import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AccountDBServiceImpl implements AccountDBService {

	private final AccountRepository accountRepository;
	private static final Integer DEFAULT_REFER_ID = 2917878;


	@Override
	public Optional<AccountEntity> findByEmail(String email) {
		return accountRepository.findFirstByEmail(email);
	}

	@Override
	public AccountEntity save(AccountEntity account) {
		return accountRepository.save(account);
	}

}
