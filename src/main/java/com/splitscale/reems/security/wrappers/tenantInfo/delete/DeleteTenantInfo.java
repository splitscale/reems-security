package com.splitscale.reems.security.wrappers.tenantInfo.delete;

import com.splitscale.reems.tenantinfo.delete.DeleteTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteTenantInfo {

  private DeleteTenantInfoInteractor interactor;

  public DeleteTenantInfo(DeleteTenantInfoInteractor interactor) {
    this.interactor = interactor;
  }

  public void delete(String id) throws IOException, GeneralSecurityException {
    interactor.deleteTenantInfo(id);
  }
}
