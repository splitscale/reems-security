package com.splitscale.reems.security.wrappers.mitigation.delete;

import com.splitscale.reems.core.mitigation.delete.DeleteMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteMitigation {

  private SecurityService securityService;
  private DeleteMitigationInteractor interactor;

  public DeleteMitigation(SecurityService securityService, DeleteMitigationInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteMitigation(id);
  }
}
