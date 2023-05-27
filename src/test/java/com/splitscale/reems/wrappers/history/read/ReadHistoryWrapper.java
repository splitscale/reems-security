package com.splitscale.reems.wrappers.history.read;

import com.splitscale.reems.history.History;
import com.splitscale.reems.history.read.ReadHistoryInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadHistoryWrapper {

  private ReadHistoryInteractor interactor;

  public ReadHistoryWrapper(ReadHistoryInteractor interactor) {
    this.interactor = interactor;
  }

  public List<History> getAllHistory()
      throws IOException, GeneralSecurityException {
    return interactor.getAllHistory();
  }

  public History getHistoryById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getById(id);
  }
}
