package com.auth.service.controller;

import com.auth.service.config.security.jwt.CurrentUser;
import com.auth.service.dto.AccountDetailsDto;
import com.auth.service.dto.request.UpdateAccountRequest;
import com.auth.service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<AccountDetailsDto> getAccountInfo(CurrentUser currentUser) {
        AccountDetailsDto accountInfo = accountService.getAccountInfo(currentUser.getEmail());
        return ResponseEntity.ok(accountInfo);
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateAccountInfo(@Valid @RequestBody UpdateAccountRequest updateAccountRequest, CurrentUser currentUser) {
        accountService.updateAccountInfo(updateAccountRequest, currentUser.getEmail());
        return ResponseEntity.ok().build();
    }

}
