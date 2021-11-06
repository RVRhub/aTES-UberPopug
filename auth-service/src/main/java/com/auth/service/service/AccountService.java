package com.auth.service.service;

import com.auth.service.dto.AccountDetailsDto;
import com.auth.service.dto.request.UpdateAccountRequest;

public interface AccountService {

    AccountDetailsDto getAccountInfo(String email);

    void updateAccountInfo(UpdateAccountRequest request, String email);
}

