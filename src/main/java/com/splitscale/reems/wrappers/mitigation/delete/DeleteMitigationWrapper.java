package com.splitscale.reems.wrappers.mitigation.delete;

import com.splitscale.reems.mitigation.delete.DeleteMitigationInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteMitigationWrapper {

  private DeleteMitigationInteractor interactor;

  public DeleteMitigationWrapper(DeleteMitigationInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteMitigation(id);
  }
}
