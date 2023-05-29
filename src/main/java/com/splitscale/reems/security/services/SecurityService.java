package com.splitscale.reems.security.services;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.security.auth.CredentialRequest;

public interface SecurityService {
  public void register(CredentialRequest request) throws IOException, IllegalArgumentException;

  public void validateJwt(String jwtToken, String userId) throws GeneralSecurityException, IOException;
}
