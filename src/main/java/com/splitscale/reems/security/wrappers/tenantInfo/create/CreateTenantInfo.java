package com.splitscale.reems.security.wrappers.tenantInfo.create;

import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.core.tenantinfo.TenantInfoRequest;
import com.splitscale.reems.core.tenantinfo.create.CreateTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateTenantInfo {
  private SecurityService securityService;
  private CreateTenantInfoInteractor interactor;

  public CreateTenantInfo(SecurityService securityService, CreateTenantInfoInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(TenantInfoRequest tenantInfoRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createTenantInfo(tenantInfoRequest);
  }
}
