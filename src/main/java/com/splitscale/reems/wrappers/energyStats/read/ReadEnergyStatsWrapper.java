package com.splitscale.reems.wrappers.energyStats.read;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

import com.splitscale.reems.energyStats.EnergyStats;
import com.splitscale.reems.energyStats.read.ReadEnergyStatsInteractor;

public class ReadEnergyStatsWrapper {
  private ReadEnergyStatsInteractor interactor;

  public ReadEnergyStatsWrapper(ReadEnergyStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public List<EnergyStats> getAllEnergyStats()
      throws IOException, GeneralSecurityException {
    return interactor.getAllEnergyStats();
  }

  public EnergyStats getEnergyStatsById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getEnergyStatsById(id);
  }
}
