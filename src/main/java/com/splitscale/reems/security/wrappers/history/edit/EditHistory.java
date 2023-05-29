package com.splitscale.reems.security.wrappers.history.edit;

import com.splitscale.reems.core.history.History;
import com.splitscale.reems.core.history.edit.EditHistoryInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditHistory {

  private SecurityService securityService;
  private EditHistoryInteractor interactor;

  public EditHistory(SecurityService securityService, EditHistoryInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(History history, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editHistory(history);
  }
}
