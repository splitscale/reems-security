package com.splitscale.reems.wrappers.expenseStats.create;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.expenseStats.ExpenseStatsRequest;
import com.splitscale.reems.expenseStats.create.CreateExpenseStatsInteractor;

public class CreateExpenseStatsWrapper {

  private CreateExpenseStatsInteractor interactor;

  public CreateExpenseStatsWrapper(CreateExpenseStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public String create(ExpenseStatsRequest expenseStatsRequest)
      throws IOException, GeneralSecurityException {
    return interactor.createExpenseStats(expenseStatsRequest);
  }
}
