package com.splitscale.reems.security.wrappers.properties.delete;

import com.splitscale.reems.properties.delete.DeletePropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteProperty {

  private SecurityService securityService;
  private DeletePropertyInteractor interactor;

  public DeleteProperty(SecurityService securityService, DeletePropertyInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteProperty(id);
  }
}
