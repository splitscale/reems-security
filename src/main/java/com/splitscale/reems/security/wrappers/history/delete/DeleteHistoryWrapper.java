package com.splitscale.reems.security.wrappers.history.delete;

import com.splitscale.reems.history.delete.DeleteHistoryInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteHistoryWrapper {

  private DeleteHistoryInteractor interactor;

  public DeleteHistoryWrapper(DeleteHistoryInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteHistoryById(id);
  }

  public void deleteAll() throws IOException, GeneralSecurityException {
    interactor.deleteAllHistory();
  }
}