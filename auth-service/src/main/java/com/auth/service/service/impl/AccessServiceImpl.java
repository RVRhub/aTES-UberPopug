package com.auth.service.service.impl;

import com.auth.service.dto.request.AccessRequest;
import com.auth.service.service.AccessService;
import com.auth.service.service.AccountDBService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
@RequiredArgsConstructor
public class AccessServiceImpl implements AccessService
{
    private final AccountDBService accountDBService;

    @Override
    @Transactional
    public void createAccessRequest(AccessRequest request) {
        accountDBService.save(request.toAccountEntity());
    }

}
