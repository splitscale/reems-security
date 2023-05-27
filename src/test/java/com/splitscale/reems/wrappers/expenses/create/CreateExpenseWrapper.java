package com.splitscale.reems.wrappers.expenses.create;

import com.splitscale.reems.expenses.ExpenseRequest;
import com.splitscale.reems.expenses.create.CreateExpenseInteractor;
import java.io.IOException;
import java.security.GeneralSecurityException;

public class CreateExpenseWrapper {

  private CreateExpenseInteractor interactor;

  public CreateExpenseWrapper(CreateExpenseInteractor interactor) {
    this.interactor = interactor;
  }

  public String create(ExpenseRequest expenseRequest)
      throws IOException, GeneralSecurityException {
    return interactor.createExpense(expenseRequest);
  }
}
