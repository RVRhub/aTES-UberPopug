package com.auth.service.dto.response;

import com.auth.service.dto.AccountDto;

import lombok.Value;

import java.util.List;

@Value(staticConstructor = "of")
public class GetAllAccountsResponse {

    List<AccountDto> accounts;
}
