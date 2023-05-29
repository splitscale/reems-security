package com.splitscale.reems.security.wrappers.hazard.read;

import com.splitscale.reems.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.hazard.environment.read.ReadEnvironmentalHazardInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadEnvironmentalHazardWrapper {

  private ReadEnvironmentalHazardInteractor interactor;

  public ReadEnvironmentalHazardWrapper(
      ReadEnvironmentalHazardInteractor interactor) {
    this.interactor = interactor;
  }

  public List<EnvironmentalHazard> getAllEnvironmentalHazard()
      throws IOException, GeneralSecurityException {
    return interactor.getAllEnvironmentalHazard();
  }

  public EnvironmentalHazard getEnvironmentalHazardById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getEnvironmentalHazardById(id);
  }
}
