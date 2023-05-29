package com.splitscale.reems.security.wrappers.tenantInfo.edit;

import com.splitscale.reems.tenantinfo.TenantInfo;
import com.splitscale.reems.tenantinfo.edit.EditTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditTenantInfo {

  private EditTenantInfoInteractor interactor;

  public EditTenantInfo(EditTenantInfoInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(TenantInfo tenantInfo)
    throws IOException, GeneralSecurityException {
    interactor.editTenantInfo(tenantInfo);
  }
}
