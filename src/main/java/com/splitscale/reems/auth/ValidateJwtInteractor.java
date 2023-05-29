package com.splitscale.reems.auth;

import com.splitscale.reems.services.SecurityService;

public class ValidateJwtInteractor {
  private SecurityService service;

  public ValidateJwtInteractor(SecurityService service) {
    this.service = service;
  }

  public void validate(String jwtToken, String userId) {
    service.validateJwt(jwtToken, userId);
  }
}
