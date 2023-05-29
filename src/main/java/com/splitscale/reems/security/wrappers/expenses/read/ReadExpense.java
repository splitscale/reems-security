package com.splitscale.reems.security.wrappers.expenses.read;

import com.splitscale.reems.expenses.Expense;
import com.splitscale.reems.expenses.read.ReadExpenseInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class ReadExpense {

  private SecurityService securityService;
  private ReadExpenseInteractor interactor;

  public ReadExpense(SecurityService securityService, ReadExpenseInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public Expense getExpenseById(String id, String jwtToken, String userId)
      throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    return interactor.getExpenseById(id);
  }
}
