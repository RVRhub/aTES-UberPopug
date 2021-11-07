package com.auth.service.controller;

import com.auth.service.config.security.jwt.CurrentUser;
import com.auth.service.dto.AccountDetailsDto;
import com.auth.service.dto.PersonalDetails;
import com.auth.service.dto.request.AccountDto;
import com.auth.service.dto.request.UpdateAccountRequest;
import com.auth.service.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.jwt.Jwt;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.Collections;
import java.util.Map;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    @GetMapping
    public ResponseEntity<PersonalDetails> getAccountInfo(CurrentUser currentUser) {
        AccountDetailsDto accountInfo = accountService.getAccountInfo(currentUser.getEmail());
        return ResponseEntity.ok(accountInfo.getPersonalDetails());
    }

    @PostMapping
    public ResponseEntity<Void> createAccount(@Valid @RequestBody AccountDto request) {
        accountService.createAccount(request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/update")
    public ResponseEntity<Void> updateAccountInfo(@Valid @RequestBody UpdateAccountRequest updateAccountRequest, CurrentUser currentUser) {
        accountService.updateAccountInfo(updateAccountRequest, currentUser.getEmail());
        return ResponseEntity.ok().build();
    }

}
