package com.splitscale.reems.security.wrappers.expenseStats.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.expenseStats.ExpenseStatsRequest;
import com.splitscale.reems.expenseStats.create.CreateExpenseStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class CreateExpenseStats {
  private SecurityService securityService;
  private CreateExpenseStatsInteractor interactor;

  public CreateExpenseStats(SecurityService securityService, CreateExpenseStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(ExpenseStatsRequest expenseStatsRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createExpenseStats(expenseStatsRequest);
  }
}
