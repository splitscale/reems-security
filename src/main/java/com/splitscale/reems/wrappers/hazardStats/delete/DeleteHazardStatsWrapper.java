package com.splitscale.reems.wrappers.hazardStats.delete;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.hazardStats.delete.DeleteHazardStatsInteractor;

public class DeleteHazardStatsWrapper {

  private DeleteHazardStatsInteractor interactor;

  public DeleteHazardStatsWrapper(DeleteHazardStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteHazardStats(id);
  }
}
