package com.splitscale.reems.security.wrappers.properties.read;

import com.splitscale.reems.core.properties.Property;
import com.splitscale.reems.core.properties.read.ReadPropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadProperty {

  private SecurityService securityService;
  private ReadPropertyInteractor interactor;

  public ReadProperty(SecurityService securityService, ReadPropertyInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<Property> getProperty(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllProperty();
  }

  public Property getPropertyId(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getById(id);
  }
}
