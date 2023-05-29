package com.splitscale.reems.security.wrappers.energyConsumption.edit;

import com.splitscale.reems.core.energy.consumption.EnergyConsumption;
import com.splitscale.reems.core.energy.consumption.edit.EditEnergyConsumptionInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditEnergyConsumption {

  private SecurityService securityService;
  private EditEnergyConsumptionInteractor interactor;

  public EditEnergyConsumption(SecurityService securityService, EditEnergyConsumptionInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(EnergyConsumption energyConsumption, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editEnergyConsumption(energyConsumption);
  }
}
