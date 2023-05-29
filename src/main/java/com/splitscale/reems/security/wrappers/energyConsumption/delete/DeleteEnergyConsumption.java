package com.splitscale.reems.security.wrappers.energyConsumption.delete;

import com.splitscale.reems.core.energy.consumption.delete.DeleteEnergyConsumptionInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteEnergyConsumption {

  private SecurityService securityService;
  private DeleteEnergyConsumptionInteractor interactor;

  public DeleteEnergyConsumption(SecurityService securityService, DeleteEnergyConsumptionInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.DeleteEnergyConsumption(id);
  }
}
