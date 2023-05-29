package com.splitscale.reems.security.wrappers.history.edit;

import com.splitscale.reems.history.History;
import com.splitscale.reems.history.edit.EditHistoryInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditHistoryWrapper {

  private EditHistoryInteractor interactor;

  public EditHistoryWrapper(EditHistoryInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(History history)
      throws IOException, GeneralSecurityException {
    interactor.editHistory(history);
  }
}
