package com.splitscale.reems.security.wrappers.hazardStats.delete;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.hazardStats.delete.DeleteHazardStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class DeleteHazardStats {
  private SecurityService securityService;
  private DeleteHazardStatsInteractor interactor;

  public DeleteHazardStats(SecurityService securityService, DeleteHazardStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteHazardStats(id);
  }
}
