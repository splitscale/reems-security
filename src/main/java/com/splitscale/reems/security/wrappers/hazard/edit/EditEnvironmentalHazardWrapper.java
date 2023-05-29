package com.splitscale.reems.security.wrappers.hazard.edit;

import com.splitscale.reems.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.hazard.environment.edit.EditEnvironmentalHazardInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditEnvironmentalHazardWrapper {

  private EditEnvironmentalHazardInteractor interactor;

  public EditEnvironmentalHazardWrapper(
      EditEnvironmentalHazardInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(EnvironmentalHazard environmentalHazard)
      throws IOException, GeneralSecurityException {
    interactor.editEnvironmentalHazard(environmentalHazard);
  }
}
