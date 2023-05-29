package com.splitscale.reems.security.wrappers.energyConsumption.read;

import com.splitscale.reems.energy.consumption.EnergyConsumption;
import com.splitscale.reems.energy.consumption.read.ReadEnergyConsumptionInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadEnergyConsumptionWrapper {

  private ReadEnergyConsumptionInteractor interactor;

  public ReadEnergyConsumptionWrapper(
      ReadEnergyConsumptionInteractor interactor) {
    this.interactor = interactor;
  }

  public List<EnergyConsumption> getAllEnergyConsumption()
      throws IOException, GeneralSecurityException {
    return interactor.getAllEnergyConsumption();
  }

  public EnergyConsumption getEnergyConsumptionById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getEnergyConsumptionById(id);
  }
}
