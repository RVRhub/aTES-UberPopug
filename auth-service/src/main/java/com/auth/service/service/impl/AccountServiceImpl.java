package com.auth.service.service.impl;

import com.auth.service.dto.AccountDetailsDto;
import com.auth.service.dto.PersonalDetails;
import com.auth.service.dto.request.AccountDto;
import com.auth.service.dto.request.UpdateAccountRequest;
import com.auth.service.events.outbound.AccountStreamProducer;
import com.auth.service.exception.BadRequestException;
import com.auth.service.model.AccountEntity;
import com.auth.service.service.AccountDBService;
import com.auth.service.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccountServiceImpl implements AccountService {

    private final AccountStreamProducer accountStreamProducer;
    private final AccountDBService accountDBService;
    private final ModelMapper mapper;

    @Override
    @Transactional
    public void createAccount(AccountDto request) {
        AccountEntity account = accountDBService.save(request.toAccountEntity());
        accountStreamProducer.sendAccountCreated(account);
    }

    @Override
    @Transactional(readOnly = true)
    public AccountDetailsDto getAccountInfo(String username) {
        log.info("[x] Get Account info request with access id: {}.", username);
        AccountEntity accountEntity = accountDBService.getByEmail(username);
        PersonalDetails details = mapper.map(accountEntity, PersonalDetails.class);
        return new AccountDetailsDto(details);
    }

    @Override
    @Transactional
    public void updateAccountInfo(UpdateAccountRequest request, String email) throws BadRequestException {
        AccountEntity accountEntity = accountDBService.getByEmail(email);
        boolean updated = accountEntity.update(request);
        if (updated) {
            log.info("[x] Successfully updated account: {}, for user with email: {}", accountEntity.toString(), accountEntity.getEmail());
        } else {
            log.warn("[x] Unable to update account info for current user: {}.", email);
            throw new BadRequestException("Bad request for update.");
        }
    }

}
