package com.splitscale.reems.security.wrappers.energyStats.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.energyStats.EnergyStatsRequest;
import com.splitscale.reems.energyStats.create.CreateEnergyStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class CreateEnergyStats {
  private SecurityService securityService;
  private CreateEnergyStatsInteractor interactor;

  public CreateEnergyStats(SecurityService securityService, CreateEnergyStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(EnergyStatsRequest energyStatsRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createEnergyStats(energyStatsRequest);
  }
}
