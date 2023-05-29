package com.splitscale.reems.wrappers.expenseStats.edit;

import java.io.IOException;
import java.security.GeneralSecurityException;

import com.splitscale.reems.expenseStats.ExpenseStats;
import com.splitscale.reems.expenseStats.edit.EditExpenseStatsInteractor;

public class EditExpenseStatsWrapper {
  private EditExpenseStatsInteractor interactor;

  public EditExpenseStatsWrapper(EditExpenseStatsInteractor interactor) {
    this.interactor = interactor;
  }

  public void edit(ExpenseStats expenseStats)
      throws IOException, GeneralSecurityException {
    interactor.editExpense(expenseStats);
  }
}
