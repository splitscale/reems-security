package com.splitscale.reems.security.wrappers.tenantInfo.read;

import com.splitscale.reems.tenantinfo.TenantInfo;
import com.splitscale.reems.tenantinfo.read.ReadTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadTenantInfo {

  private ReadTenantInfoInteractor interactor;

  public ReadTenantInfo(ReadTenantInfoInteractor interactor) {
    this.interactor = interactor;
  }

  public List<TenantInfo> getAllTenantInfo()
      throws IOException, GeneralSecurityException {
    return interactor.getAllTenantInfo();
  }

  public TenantInfo getTenantInfoById(String id)
      throws IOException, GeneralSecurityException {
    return interactor.getTenantInfoById(id);
  }
}
