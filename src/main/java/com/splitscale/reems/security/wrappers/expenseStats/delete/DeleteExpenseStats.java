package com.splitscale.reems.security.wrappers.expenseStats.delete;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.expenseStats.delete.DeleteExpenseStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class DeleteExpenseStats {
  private SecurityService securityService;
  private DeleteExpenseStatsInteractor interactor;

  public DeleteExpenseStats(SecurityService securityService, DeleteExpenseStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteExpenseStats(id);
  }
}
