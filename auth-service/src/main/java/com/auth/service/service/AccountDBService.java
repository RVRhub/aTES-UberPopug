package com.auth.service.service;

import com.auth.service.exception.NotFoundException;
import com.auth.service.model.AccountEntity;

import java.util.Optional;
import java.util.UUID;

public interface AccountDBService {

    Optional<AccountEntity> findByEmail(String email);

    default AccountEntity getByEmail(String email) {
        return findByEmail(email).orElseThrow(() -> new NotFoundException("Account not found"));
    }

    AccountEntity save(AccountEntity account);

}
