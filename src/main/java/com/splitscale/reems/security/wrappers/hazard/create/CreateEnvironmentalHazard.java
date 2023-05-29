package com.splitscale.reems.security.wrappers.hazard.create;

import com.splitscale.reems.core.hazard.environment.EnvironmentalHazardRequest;
import com.splitscale.reems.core.hazard.environment.create.CreateEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEnvironmentalHazard {

  private SecurityService securityService;
  private CreateEnvironmentalHazardInteractor interactor;

  public CreateEnvironmentalHazard(SecurityService securityService, CreateEnvironmentalHazardInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(EnvironmentalHazardRequest environmentalHazardRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createEnvironmentalHazard(environmentalHazardRequest);
  }
}
