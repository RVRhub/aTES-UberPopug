package com.auth.service.service;

import com.auth.service.dto.AccountDetailsDto;
import com.auth.service.dto.request.AccountDto;
import com.auth.service.dto.request.UpdateAccountRequest;

public interface AccountService {

	void createAccount(AccountDto request);

	AccountDetailsDto getAccountInfo(String email);

	void updateAccountInfo(UpdateAccountRequest request, String email);
}

