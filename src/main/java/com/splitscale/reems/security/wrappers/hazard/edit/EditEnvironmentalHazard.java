package com.splitscale.reems.security.wrappers.hazard.edit;

import com.splitscale.reems.core.hazard.environment.EnvironmentalHazard;
import com.splitscale.reems.core.hazard.environment.edit.EditEnvironmentalHazardInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditEnvironmentalHazard {

  private SecurityService securityService;
  private EditEnvironmentalHazardInteractor interactor;

  public EditEnvironmentalHazard(SecurityService securityService, EditEnvironmentalHazardInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(EnvironmentalHazard environmentalHazard, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editEnvironmentalHazard(environmentalHazard);
  }
}
