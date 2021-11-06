package com.auth.service.service;


import com.auth.service.dto.request.AccessRequest;

import java.util.UUID;

public interface AccessService {

    void createAccessRequest(AccessRequest request);
}
