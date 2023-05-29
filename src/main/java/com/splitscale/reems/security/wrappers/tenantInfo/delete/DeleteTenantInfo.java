package com.splitscale.reems.security.wrappers.tenantInfo.delete;

import com.splitscale.reems.security.services.SecurityService;
import com.splitscale.reems.tenantinfo.delete.DeleteTenantInfoInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteTenantInfo {

  private SecurityService securityService;
  private DeleteTenantInfoInteractor interactor;

  public DeleteTenantInfo(SecurityService securityService, DeleteTenantInfoInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {
    
    securityService.validateJwt(jwtToken, userId);

    interactor.deleteTenantInfo(id);
  }
}
