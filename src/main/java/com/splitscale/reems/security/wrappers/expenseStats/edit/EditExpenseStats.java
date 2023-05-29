package com.splitscale.reems.security.wrappers.expenseStats.edit;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.core.expenseStats.ExpenseStats;
import com.splitscale.reems.core.expenseStats.edit.EditExpenseStatsInteractor;
import com.splitscale.reems.security.services.SecurityService;

public class EditExpenseStats {
  private SecurityService securityService;
  private EditExpenseStatsInteractor interactor;

  public EditExpenseStats(SecurityService securityService, EditExpenseStatsInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(ExpenseStats expenseStats, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editExpense(expenseStats);;
  }
}
