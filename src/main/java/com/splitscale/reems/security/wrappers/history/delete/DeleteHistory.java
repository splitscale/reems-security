package com.splitscale.reems.security.wrappers.history.delete;

import com.splitscale.reems.history.delete.DeleteHistoryInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteHistory {

  private SecurityService securityService;
  private DeleteHistoryInteractor interactor;

  public DeleteHistory(SecurityService securityService, DeleteHistoryInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteHistoryById(id);
  }

  public void deleteAll(String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteAllHistory();
  }
}
