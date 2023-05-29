package com.splitscale.reems.security.wrappers.hazard.delete;

import com.splitscale.reems.hazard.environment.delete.DeleteEnvironmentalHazardInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteEnvironmentalHazardWrapper {

  private DeleteEnvironmentalHazardInteractor interactor;

  public DeleteEnvironmentalHazardWrapper(
      DeleteEnvironmentalHazardInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteEnvironmentalHazard(id);
  }
}
