package com.splitscale.reems.security.wrappers.expenses.create;

import com.splitscale.reems.expenses.ExpenseRequest;
import com.splitscale.reems.expenses.create.CreateExpenseInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateExpense {

  private SecurityService securityService;
  private CreateExpenseInteractor interactor;

  public CreateExpense(SecurityService securityService, CreateExpenseInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public String create(ExpenseRequest expenseRequest, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.createExpense(expenseRequest);
  }
}
