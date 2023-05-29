package com.splitscale.reems.security.wrappers.mitigation.create;

import com.splitscale.reems.mitigation.MitigationRequest;
import com.splitscale.reems.mitigation.create.CreateMitigationInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateMitigationWrapper {

  private CreateMitigationInteractor interactor;

  public CreateMitigationWrapper(CreateMitigationInteractor interactor) {
    this.interactor = interactor;
  }

  public String create(MitigationRequest mitigationRequest)
      throws IOException, GeneralSecurityException {
    return interactor.createMitigation(mitigationRequest);
  }
}
