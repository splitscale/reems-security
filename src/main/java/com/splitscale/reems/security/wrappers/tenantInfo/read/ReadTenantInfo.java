package com.splitscale.reems.security.wrappers.tenantInfo.read;

import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.tenantinfo.TenantInfo;
import com.splitscale.reems.tenantinfo.read.ReadTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadTenantInfo {
  private SecurityService securityService;
  private ReadTenantInfoInteractor interactor;

  public ReadTenantInfo(SecurityService securityService, ReadTenantInfoInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<TenantInfo> getAllTenantInfo(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllTenantInfo();
  }

  public TenantInfo getTenantInfoById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getTenantInfoById(id);
  }
}
