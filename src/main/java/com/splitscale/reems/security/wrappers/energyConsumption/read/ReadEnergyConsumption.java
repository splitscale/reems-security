package com.splitscale.reems.security.wrappers.energyConsumption.read;

import com.splitscale.reems.core.energy.consumption.EnergyConsumption;
import com.splitscale.reems.core.energy.consumption.read.ReadEnergyConsumptionInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadEnergyConsumption {

  private SecurityService securityService;
  private ReadEnergyConsumptionInteractor interactor;

  public ReadEnergyConsumption(SecurityService securityService, ReadEnergyConsumptionInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<EnergyConsumption> getAllEnergyConsumption(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllEnergyConsumption();
  }

  public EnergyConsumption getEnergyConsumptionById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getEnergyConsumptionById(id);
  }
}
