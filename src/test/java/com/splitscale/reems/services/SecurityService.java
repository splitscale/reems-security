package com.splitscale.reems.services;

import com.splitscale.reems.auth.CredentialRequest;

public interface SecurityService<T> {
  public String register(CredentialRequest request);

  public T validate(String token, String validationData);

  public String invalidate(String token);
}
