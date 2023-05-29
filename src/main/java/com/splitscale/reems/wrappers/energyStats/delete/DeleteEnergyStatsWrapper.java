package com.splitscale.reems.wrappers.energyStats.delete;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.energyStats.delete.DeleteEnergyStatsInteractor;

public class DeleteEnergyStatsWrapper {
  private DeleteEnergyStatsInteractor interactor;

  public DeleteEnergyStatsWrapper(DeleteEnergyStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteEnergyStats(id);
  }
}
