package com.splitscale.reems.security.wrappers.properties.create;

import com.splitscale.reems.core.properties.PropertyRequest;
import com.splitscale.reems.core.properties.create.CreatePropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateProperty {
  private SecurityService securityService;
  private CreatePropertyInteractor interactor;

  public CreateProperty(SecurityService securityService, CreatePropertyInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(PropertyRequest propertyRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createProperty(propertyRequest);
  }
}
