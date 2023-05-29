package com.splitscale.reems.security.wrappers.mitigation.edit;

import com.splitscale.reems.mitigation.Mitigation;
import com.splitscale.reems.mitigation.edit.EditMitigationInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditMitigation {

  private SecurityService securityService;
  private EditMitigationInteractor interactor;

  public EditMitigation(SecurityService securityService, EditMitigationInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(Mitigation mitigation, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editMitigation(mitigation);
  }
}
