package com.splitscale.reems.security.wrappers.expenses.edit;

import com.splitscale.reems.expenses.Expense;
import com.splitscale.reems.expenses.edit.EditExpenseInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class EditExpense {

  private SecurityService securityService;
  private EditExpenseInteractor interactor;

  public EditExpense(SecurityService securityService, EditExpenseInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void edit(Expense expense, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.editExpense(expense);
  }
}
