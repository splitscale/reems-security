package com.splitscale.reems.security.wrappers.hazardStats.edit;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.hazardStats.HazardStats;
import com.splitscale.reems.hazardStats.edit.EditHazardStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class EditHazardStats {
  private SecurityService securityService;
  private EditHazardStatsInteractor interactor;

  public EditHazardStats(SecurityService securityService, EditHazardStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(HazardStats hazardStats, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.EditHazardStats(hazardStats);;
  }
}
