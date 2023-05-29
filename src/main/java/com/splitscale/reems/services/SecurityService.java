package com.splitscale.reems.services;

import com.splitscale.reems.auth.CredentialRequest;

public interface SecurityService {
  public void register(CredentialRequest request);

  public void validateJwt(String jwtToken, String userId);
}
