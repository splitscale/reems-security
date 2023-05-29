package com.splitscale.reems.wrappers.energyStats.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.energyStats.EnergyStatsRequest;
import com.splitscale.reems.energyStats.create.CreateEnergyStatsInteractor;

public class CreateEnergyStatsWrapper {
  private CreateEnergyStatsInteractor interactor;

  public CreateEnergyStatsWrapper(CreateEnergyStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public String create(EnergyStatsRequest energyStatsRequest)
      throws IOException, GeneralSecurityException {
    return interactor.createEnergyStats(energyStatsRequest);
  }
}
