package com.splitscale.reems.security.wrappers.tenantInfo.edit;

import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.core.tenantinfo.TenantInfo;
import com.splitscale.reems.core.tenantinfo.edit.EditTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditTenantInfo {
  private SecurityService securityService;
  private EditTenantInfoInteractor interactor;

  public EditTenantInfo(SecurityService securityService, EditTenantInfoInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(TenantInfo tenantInfo, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {
        
    securityService.validateJwt(jwtToken, userId);

    interactor.editTenantInfo(tenantInfo);
  }
}
