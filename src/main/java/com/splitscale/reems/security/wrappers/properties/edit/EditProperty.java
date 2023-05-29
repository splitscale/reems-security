package com.splitscale.reems.security.wrappers.properties.edit;

import com.splitscale.reems.properties.Property;
import com.splitscale.reems.properties.edit.EditPropertyInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditProperty {

  private SecurityService securityService;
  private EditPropertyInteractor interactor;

  public EditProperty(SecurityService securityService, EditPropertyInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(Property property, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editProperty(property);
  }
}
