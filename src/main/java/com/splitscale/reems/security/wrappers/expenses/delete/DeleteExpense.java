package com.splitscale.reems.security.wrappers.expenses.delete;

import com.splitscale.reems.expenses.delete.DeleteExpenseInteractor;
import com.splitscale.reems.security.services.SecurityService;

import java.io.IOException;
import java.security.GeneralSecurityException;

public class DeleteExpense {

  private SecurityService securityService;
  private DeleteExpenseInteractor interactor;

  public DeleteExpense(SecurityService securityService, DeleteExpenseInteractor interactor) {
    this.securityService = securityService;
    this.interactor = interactor;
  }

  public void delete(String id, String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteExpense(id);
  }

  public void deleteAll(String jwtToken, String userId) throws IOException, GeneralSecurityException {

    securityService.validateJwt(jwtToken, userId);

    interactor.deleteAllExpense();
  }
}
