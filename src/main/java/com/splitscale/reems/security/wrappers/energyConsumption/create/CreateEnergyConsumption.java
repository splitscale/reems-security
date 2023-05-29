package com.splitscale.reems.security.wrappers.energyConsumption.create;

import com.splitscale.reems.core.energy.consumption.EnergyConsumptionRequest;
import com.splitscale.reems.core.energy.consumption.create.CreateEnergyConsumptionInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEnergyConsumption {

  private SecurityService securityService;
  private CreateEnergyConsumptionInteractor interactor;

  public CreateEnergyConsumption(SecurityService securityService, CreateEnergyConsumptionInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(EnergyConsumptionRequest energyConsumptionRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createEnergyConsumption(energyConsumptionRequest);
  }
}
