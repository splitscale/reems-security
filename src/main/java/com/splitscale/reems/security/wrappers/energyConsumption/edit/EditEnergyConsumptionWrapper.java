package com.splitscale.reems.security.wrappers.energyConsumption.edit;

import com.splitscale.reems.energy.consumption.EnergyConsumption;
import com.splitscale.reems.energy.consumption.edit.EditEnergyConsumptionInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditEnergyConsumptionWrapper {

  private EditEnergyConsumptionInteractor interactor;

  public EditEnergyConsumptionWrapper(EditEnergyConsumptionInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(EnergyConsumption energyConsumption)
      throws IOException, GeneralSecurityException {
    interactor.editEnergyConsumption(energyConsumption);
  }
}
