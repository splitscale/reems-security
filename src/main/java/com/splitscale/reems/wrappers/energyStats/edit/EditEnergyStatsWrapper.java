package com.splitscale.reems.wrappers.energyStats.edit;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.energyStats.EnergyStats;
import com.splitscale.reems.energyStats.edit.EditEnergyStatsInteractor;

public class EditEnergyStatsWrapper {
  private EditEnergyStatsInteractor interactor;

  public EditEnergyStatsWrapper(EditEnergyStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(EnergyStats energyStats)
      throws IOException, GeneralSecurityException {
    interactor.editEnergyStats(energyStats);;
  }
}
