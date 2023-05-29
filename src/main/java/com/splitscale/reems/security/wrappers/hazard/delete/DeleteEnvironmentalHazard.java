package com.splitscale.reems.security.wrappers.hazard.delete;

import com.splitscale.reems.hazard.environment.delete.DeleteEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteEnvironmentalHazard {

  private SecurityService securityService;
  private DeleteEnvironmentalHazardInteractor interactor;

  public DeleteEnvironmentalHazard(SecurityService securityService, DeleteEnvironmentalHazardInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteEnvironmentalHazard(id);
  }
}
