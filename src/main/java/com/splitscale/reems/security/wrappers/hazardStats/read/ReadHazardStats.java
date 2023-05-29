package com.splitscale.reems.security.wrappers.hazardStats.read;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.splitscale.reems.core.hazardStats.HazardStats;
import com.splitscale.reems.core.hazardStats.read.ReadHazardStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class ReadHazardStats {

  private SecurityService securityService;
  private ReadHazardStatsInteractor interactor;

  public ReadHazardStats(SecurityService securityService, ReadHazardStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<HazardStats> getAllHazardStats(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllHazardStats();
  }

  public HazardStats getEnvironmentalHazardById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getHazardStatsById(id);
  }
}
