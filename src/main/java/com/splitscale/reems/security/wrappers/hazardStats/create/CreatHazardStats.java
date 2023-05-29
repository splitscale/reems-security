package com.splitscale.reems.security.wrappers.hazardStats.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.core.hazardStats.HazardStatsRequest;
import com.splitscale.reems.core.hazardStats.create.CreateHazardStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class CreatHazardStats {
  private SecurityService securityService;
  private CreateHazardStatsInteractor interactor;

  public CreatHazardStats(SecurityService securityService, CreateHazardStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(HazardStatsRequest hazardStatsRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createHazardStats(hazardStatsRequest);
  }
}
