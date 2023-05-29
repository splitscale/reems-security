package com.splitscale.reems.security.wrappers.mitigation.create;

import com.splitscale.reems.mitigation.MitigationRequest;
import com.splitscale.reems.mitigation.create.CreateMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateMitigation {

  private SecurityService securityService;
  private CreateMitigationInteractor interactor;

  public CreateMitigation(SecurityService securityService, CreateMitigationInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(MitigationRequest mitigationRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createMitigation(mitigationRequest);
  }
}
