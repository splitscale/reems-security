package com.splitscale.reems.wrappers.mitigation.edit;

import com.splitscale.reems.mitigation.Mitigation;
import com.splitscale.reems.mitigation.edit.EditMitigationInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditMitigationWrapper {

  private EditMitigationInteractor interactor;

  public EditMitigationWrapper(EditMitigationInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(Mitigation mitigation)
      throws IOException, GeneralSecurityException {
    interactor.editMitigation(mitigation);
  }
}
