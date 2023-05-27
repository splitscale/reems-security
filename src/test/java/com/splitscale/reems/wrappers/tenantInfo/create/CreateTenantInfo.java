package com.splitscale.reems.wrappers.tenantInfo.create;

import com.splitscale.reems.tenantinfo.TenantInfoRequest;
import com.splitscale.reems.tenantinfo.create.CreateTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateTenantInfo {

  private CreateTenantInfoInteractor interactor;

  public CreateTenantInfo(CreateTenantInfoInteractor interactor) {
    this.interactor = interactor;
  }

  public String create(TenantInfoRequest tenantInfoRequest)
    throws IOException, GeneralSecurityException {
    return interactor.createTenantInfo(tenantInfoRequest);
  }
}
