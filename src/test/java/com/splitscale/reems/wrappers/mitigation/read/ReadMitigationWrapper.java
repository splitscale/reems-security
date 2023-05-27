package com.splitscale.reems.wrappers.mitigation.read;

import com.splitscale.reems.mitigation.Mitigation;
import com.splitscale.reems.mitigation.read.ReadMitigationInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadMitigationWrapper {

  private ReadMitigationInteractor interactor;

  public ReadMitigationWrapper(ReadMitigationInteractor interactor) {
    this.interactor = interactor;
  }

  public List<Mitigation> getAllMitigations()
      throws IOException, GeneralSecurityException {
    return interactor.getAllMitigation();
  }

  public Mitigation getMitigationById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getMitigationById(id);
  }
}
