package com.splitscale.reems.security.wrappers.energyStats.delete;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.energyStats.delete.DeleteEnergyStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class DeleteEnergyStats {

  private SecurityService securityService;
  private DeleteEnergyStatsInteractor interactor;

  public DeleteEnergyStats(SecurityService securityService, DeleteEnergyStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteEnergyStats(id);
  }
}
