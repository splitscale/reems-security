package com.splitscale.reems.security.wrappers.energyConsumption.create;

import com.splitscale.reems.energy.consumption.EnergyConsumptionRequest;
import com.splitscale.reems.energy.consumption.create.CreateEnergyConsumptionInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEnergyConsumptionWrapper {

  private CreateEnergyConsumptionInteractor interactor;

  public CreateEnergyConsumptionWrapper(
    CreateEnergyConsumptionInteractor interactor
  ) {
    this.interactor = interactor;
  }

  public String create(EnergyConsumptionRequest energyConsumptionRequest)
    throws IOException, GeneralSecurityException {
    return interactor.createEnergyConsumption(energyConsumptionRequest);
  }
}
