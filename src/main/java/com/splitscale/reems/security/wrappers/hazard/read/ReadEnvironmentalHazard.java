package com.splitscale.reems.security.wrappers.hazard.read;

import com.splitscale.reems.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.hazard.environment.read.ReadEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadEnvironmentalHazard {

  private SecurityService securityService;
  private ReadEnvironmentalHazardInteractor interactor;

  public ReadEnvironmentalHazard(SecurityService securityService, ReadEnvironmentalHazardInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<EnvironmentalHazard> getAllEnvironmentalHazard(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllEnvironmentalHazard();
  }

  public EnvironmentalHazard getEnvironmentalHazardById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getEnvironmentalHazardById(id);
  }
}
