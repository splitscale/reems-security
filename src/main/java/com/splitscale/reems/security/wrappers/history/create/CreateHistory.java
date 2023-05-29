package com.splitscale.reems.security.wrappers.history.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.core.history.HistoryRequest;
import com.splitscale.reems.core.history.create.CreateHistoryInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class CreateHistory {
  private SecurityService securityService;
  private CreateHistoryInteractor interactor;

  public CreateHistory(SecurityService securityService, CreateHistoryInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(HistoryRequest historyRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createHistory(historyRequest);
  }
}
