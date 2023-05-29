package com.splitscale.reems.wrappers.hazardStats.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.hazardStats.HazardStatsRequest;
import com.splitscale.reems.hazardStats.create.CreateHazardStatsInteractor;

public class CreateHazardStatsWrapper {
  private CreateHazardStatsInteractor interactor;

  public CreateHazardStatsWrapper(CreateHazardStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public String create(HazardStatsRequest hazardStatsRequest)
      throws IOException, GeneralSecurityException {
    return interactor.createHazardStats(hazardStatsRequest);
  }
}
