package com.splitscale.reems.wrappers.properties.delete;

import com.splitscale.reems.properties.delete.DeletePropertyInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeletePropertyWrapper {

  private DeletePropertyInteractor interactor;

  public DeletePropertyWrapper(DeletePropertyInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteProperty(id);
  }
}
