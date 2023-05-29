package com.splitscale.reems.security.auth;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.security.services.SecurityService;

public class RegisterDefaultUserInteractor {
  private SecurityService service;

  public RegisterDefaultUserInteractor(SecurityService service) {
    this.service = service;
  }

  public void validate(String jwtToken, String userId) throws GeneralSecurityException, IOException {
    service.validateJwt(jwtToken, userId);
  }
}
