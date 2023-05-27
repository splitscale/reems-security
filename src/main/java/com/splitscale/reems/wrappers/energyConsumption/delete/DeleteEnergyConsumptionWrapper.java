package com.splitscale.reems.wrappers.energyConsumption.delete;

import com.splitscale.reems.energy.consumption.delete.DeleteEnergyConsumptionInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteEnergyConsumptionWrapper {

  private DeleteEnergyConsumptionInteractor interactor;

  public DeleteEnergyConsumptionWrapper(
    DeleteEnergyConsumptionInteractor interactor
  ) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.DeleteEnergyConsumption(id);
  }
}
