package com.splitscale.reems.security.wrappers.history.read;

import com.splitscale.reems.history.History;
import com.splitscale.reems.history.read.ReadHistoryInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.List;

public class ReadHistory {

  private SecurityService securityService;
  private ReadHistoryInteractor interactor;

  public ReadHistory(SecurityService securityService, ReadHistoryInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public List<History> getAllHistory(String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getAllHistory();
  }

  public History getHistoryById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getById(id);
  }
}
