package com.auth.service.controller;

import com.auth.service.dto.request.AccessRequest;
import com.auth.service.service.AccessService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.UUID;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/access")
public class AccessController {

    private final AccessService accessService;

    @PostMapping
    public ResponseEntity<Void> createAccessRequest(@Valid @RequestBody AccessRequest request) {
        accessService.createAccessRequest(request);
        return ResponseEntity.ok().build();
    }
}
