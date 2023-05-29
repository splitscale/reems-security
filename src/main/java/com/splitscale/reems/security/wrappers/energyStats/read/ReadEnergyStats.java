package com.splitscale.reems.security.wrappers.energyStats.read;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.splitscale.reems.core.energyStats.EnergyStats;
import com.splitscale.reems.core.energyStats.read.ReadEnergyStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class ReadEnergyStats {
  private SecurityService securityService;
  private ReadEnergyStatsInteractor interactor;

  public ReadEnergyStats(SecurityService securityService, ReadEnergyStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<EnergyStats> getAllEnergyStats(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllEnergyStats();
  }

  public EnergyStats getEnergystatsById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getEnergyStatsById(id);
  }
}
