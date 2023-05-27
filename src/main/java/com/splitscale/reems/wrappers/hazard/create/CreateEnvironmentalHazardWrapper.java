package com.splitscale.reems.wrappers.hazard.create;

import com.splitscale.reems.hazard.environment.EnvironmentalHazardRequest;
import com.splitscale.reems.hazard.environment.create.CreateEnvironmentalHazardInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateEnvironmentalHazardWrapper {

  private CreateEnvironmentalHazardInteractor interactor;

  public String create(EnvironmentalHazardRequest environmentalHazardRequest)
      throws IOException, GeneralSecurityException {
    return interactor.createEnvironmentalHazard(environmentalHazardRequest);
  }
}
