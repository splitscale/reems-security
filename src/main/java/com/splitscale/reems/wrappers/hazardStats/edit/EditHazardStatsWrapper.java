package com.splitscale.reems.wrappers.hazardStats.edit;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.hazardStats.HazardStats;
import com.splitscale.reems.hazardStats.edit.EditHazardStatsInteractor;

public class EditHazardStatsWrapper {
  private EditHazardStatsInteractor interactor;

  public EditHazardStatsWrapper(EditHazardStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(HazardStats hazardStats)
      throws IOException, GeneralSecurityException {
    interactor.EditHazardStats(hazardStats);
  }
}
